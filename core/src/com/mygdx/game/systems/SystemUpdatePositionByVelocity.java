package com.mygdx.game.systems;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.components.ComponentPosition;
import com.mygdx.game.components.ComponentVelocity;
import com.mygdx.game.entities.Entity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * SystemUpdatePositionByVelocity class updates the position of entities based on their velocity,
 * if they have both position and velocity components.
 * It also ensures entities stay within the bounds of the map.
 */
public class SystemUpdatePositionByVelocity extends UpdateSystem{

    /**
     * Constructs a SystemUpdatePositionByVelocity object.
     */
    public SystemUpdatePositionByVelocity(){}

    /**
     * Updates the position of all entities based on their velocity.
     * @param entities The list of entities to update
     */
    public void update(HashMap<String,Entity> entities){
        float mapWidth = 1;
        float mapHeight = 1;

        // Get map height and width

        Entity map = entities.get("Map");
        ComponentPosition mapPosition = (ComponentPosition) map.getComponent(ComponentPosition.class);
        mapWidth = (float) mapPosition.getRawWidth();
        mapHeight = (float) mapPosition.getRawHeight();

        // Update positions based on velocity
        for(Entity entity : entities.values()){
            if(entity.hasComponent(ComponentPosition.class) && entity.hasComponent(ComponentVelocity.class)){
                ComponentPosition position = (ComponentPosition) entity.getComponent(ComponentPosition.class);
                ComponentVelocity velocity = (ComponentVelocity) entity.getComponent(ComponentVelocity.class);

                // Ensure entities stay within map bounds
                if ((0<position.getRawX() || velocity.getXSpeed()>0) &&
                        (position.getRawX()<(mapWidth - position.getRawWidth())||velocity.getXSpeed()<0)) {
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
