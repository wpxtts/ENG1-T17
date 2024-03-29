package com.mygdx.game.systems;

import com.mygdx.game.components.ComponentInput;
import com.mygdx.game.components.ComponentVelocity;
import com.mygdx.game.entities.Entity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * SystemUpdateVelocityByInput class updates the velocity of entities based on user input.
 * It checks for entities with both input and velocity components and modifies the velocity
 * according to the keys pressed by the user.
 */
public class SystemUpdateVelocityByInput extends UpdateSystem{

    /**
     * Constructs a SystemUpdateVelocityByInput object.
     */
    public SystemUpdateVelocityByInput(){}

    /**
     * Update velocities of entities based on user input.
     * @param entities The list of entities to update
     */
    public void update(HashMap<String, Entity> entities) {
        // Loop through all entities to find those with Input and Velocity components.
        for(Entity entity : entities.values()){
            if(entity.hasComponent(ComponentInput.class) && entity.hasComponent(ComponentVelocity.class)){
                ComponentInput input = (ComponentInput) entity.getComponent(ComponentInput.class);
                ComponentVelocity velocity = (ComponentVelocity) entity.getComponent(ComponentVelocity.class);
                // Check what keys are pressed
                ArrayList<String> keysPressed = input.getKeysPressed();
                boolean left = keysPressed.contains("LEFT");
                boolean right = keysPressed.contains("RIGHT");
                boolean up = keysPressed.contains("UP");
                boolean down = keysPressed.contains("DOWN");
                // Speed increment determines the speed of the player.
                double speedIncrement = 0.2;
                float newXSpeed = 0;
                float newYSpeed = 0;
                if(left){
                    newXSpeed -= speedIncrement;
                }
                if(right){
                    newXSpeed += speedIncrement;
                }
                if(up){
                    newYSpeed += speedIncrement;
                }
                if(down){
                    newYSpeed -= speedIncrement;
                }
                if((left||right)&&(up||down)){
                    // If we are moving diagonally (meaning we are moving
                    // left/right and up/down at the same time), then to avoid
                    // this being faster than going in a straight line (as you
                    // will get the xSpeed and the ySpeed), we have to apply a
                    // damping.
                    // The 0.707 is an approximation of 1/sqrt(2), which can
                    // be derived via the Pythagorean equation.
                    newXSpeed = (float) (newXSpeed * 0.707);
                    newYSpeed = (float) (newYSpeed * 0.707);
                }

                // Set velocity to new speed.
                velocity.setXSpeed(newXSpeed);
                velocity.setYSpeed(newYSpeed);

            }
        }
    }
}
