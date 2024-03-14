package com.mygdx.game.systems;

import com.mygdx.game.components.ComponentInput;
import com.mygdx.game.components.ComponentVelocity;
import com.mygdx.game.entities.Entity;

import java.util.ArrayList;

/**
 * System to update an entities velocity in accordance to user
 * input (as opposed to being controlled by an AI for example).
 */
public class SystemUpdateVelocityByInput {

    public SystemUpdateVelocityByInput(){}

    /**
     * Update velocities in accordance to user input
     * @param entities all the entities.
     */
    public void update(ArrayList<Entity> entities) {
        // Loop through all entities to find those with Input and Velocity components.
        for(Entity entity : entities){
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
                int speedIncrement = 200;
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
                    // this being faster the going in a straight line (as you
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
