package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class SystemUpdatePositionByVelocity {
    SystemUpdatePositionByVelocity(){}

    public void Update(Entity[] entities){
        for(Entity entity : entities){
            if(entity.hasComponent(ComponentPosition.class) && entity.hasComponent(ComponentVelocity.class)){
                ComponentPosition position = (ComponentPosition) entity.getComponent(ComponentPosition.class);
                ComponentVelocity velocity = (ComponentVelocity) entity.getComponent(ComponentVelocity.class);

                position.x += velocity.xSpeed;
                position.y += velocity.ySpeed;

                if (0<position.x && position.x<720) {
                    position.x += velocity.xSpeed * Gdx.graphics.getDeltaTime();
                }
                if(0<position.y && position.y<480){
                    position.y += velocity.ySpeed * Gdx.graphics.getDeltaTime();
                }
            }
        }
    }
}
