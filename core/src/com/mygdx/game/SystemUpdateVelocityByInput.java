package com.mygdx.game;

import java.util.ArrayList;

public class SystemUpdateVelocityByInput {
    SystemUpdateVelocityByInput(){}

    public void Update(ArrayList<Entity> entities) {
    for(Entity entity : entities){
        if(entity.hasComponent(ComponentInput.class) && entity.hasComponent(ComponentVelocity.class)){
            ComponentInput input = (ComponentInput) entity.getComponent(ComponentInput.class);
            ComponentVelocity velocity = (ComponentVelocity) entity.getComponent(ComponentVelocity.class);
            ArrayList<String> keysPressed = input.getKeysPressed();
            boolean left = keysPressed.contains("LEFT");
            boolean right = keysPressed.contains("RIGHT");
            boolean up = keysPressed.contains("UP");
            boolean down = keysPressed.contains("DOWN");
            int speedIncrement = 200;
            int newXSpeed = 0;
            int newYSpeed = 0;
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
                newXSpeed = (int) (newXSpeed * 0.707);
                newYSpeed = (int) (newYSpeed * 0.707);
            }

            velocity.setXSpeed(newXSpeed);
            velocity.setYSpeed(newYSpeed);

        }
    }
    }
}
