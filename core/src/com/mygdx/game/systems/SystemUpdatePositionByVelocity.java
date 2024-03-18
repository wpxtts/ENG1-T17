package com.mygdx.game.systems;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.components.ComponentPosition;
import com.mygdx.game.components.ComponentSpecialEntityFlag;
import com.mygdx.game.components.ComponentVelocity;
import com.mygdx.game.entities.Entity;

import java.util.ArrayList;

/**
 * System to update any entities position by their velocity (if
 * they have a position and velocity).
 */
public class SystemUpdatePositionByVelocity {
    public SystemUpdatePositionByVelocity(){}

    /**
     * This updates all entities position by their velocity (if
     * they have a position and velocity).
     * @param entities all the entities
     */
    public void update(ArrayList<Entity> entities){
        float mapWidth = 1;
        float mapHeight = 1;
        // Get map height and width
        for(Entity entity : entities){
            if(entity.hasComponent(ComponentSpecialEntityFlag.class)){
                ComponentSpecialEntityFlag flag = (ComponentSpecialEntityFlag) entity.getComponent(ComponentSpecialEntityFlag.class);
                if(flag.getFlag().equals("Map")){
                    ComponentPosition mapPosition = (ComponentPosition) entity.getComponent(ComponentPosition.class);
                    mapWidth = (float) mapPosition.getRawWidth();
                    mapHeight = (float) mapPosition.getRawHeight();
                }
            }
        }

        for(Entity entity : entities){
            if(entity.hasComponent(ComponentPosition.class) && entity.hasComponent(ComponentVelocity.class)){
                ComponentPosition position = (ComponentPosition) entity.getComponent(ComponentPosition.class);
                ComponentVelocity velocity = (ComponentVelocity) entity.getComponent(ComponentVelocity.class);

                // We check the player is within bounds before changing position.
                if ((0<position.getRawX() || velocity.getXSpeed()>0) &&
                        (position.getRawX()<(mapWidth - position.getRawWidth())||velocity.getXSpeed()<0)) {
                    // We use deltaTime to avoid speed being tied to frame rate (which
                    // can vary from computer to computer).
                    position.setX(position.getRawX() +velocity.getXSpeed() * Gdx.graphics.getDeltaTime());
                }
                if ((0<position.getRawY() || velocity.getYSpeed()>0) &&
                        (position.getRawY()<(mapHeight - position.getRawHeight())||velocity.getYSpeed()<0)) {
                    position.setY(position.getRawY() +velocity.getYSpeed() * Gdx.graphics.getDeltaTime());
                }
            }
        }
    }
}
