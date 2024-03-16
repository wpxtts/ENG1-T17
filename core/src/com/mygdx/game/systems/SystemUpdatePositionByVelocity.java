package com.mygdx.game.systems;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.components.ComponentPosition;
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
        for(Entity entity : entities){
            if(entity.hasComponent(ComponentPosition.class) && entity.hasComponent(ComponentVelocity.class)){
                ComponentPosition position = (ComponentPosition) entity.getComponent(ComponentPosition.class);
                ComponentVelocity velocity = (ComponentVelocity) entity.getComponent(ComponentVelocity.class);

                // We check the player is within bounds before changing position.
                if ((0<position.getX() || velocity.getXSpeed()>0) &&
                        (position.getX()<(3000 - position.getWidth())||velocity.getXSpeed()<0)) {
                    // We use deltaTime to avoid speed being tied to frame rate (which
                    // can vary from computer to computer).
                    position.setX(position.getX() +velocity.getXSpeed() * Gdx.graphics.getDeltaTime());
                }
                if ((0<position.getY() || velocity.getYSpeed()>0) &&
                        (position.getY()<(1896 - position.getHeight())||velocity.getYSpeed()<0)) {
                    position.setY(position.getY() +velocity.getYSpeed() * Gdx.graphics.getDeltaTime());
                }
            }
        }
    }
}
