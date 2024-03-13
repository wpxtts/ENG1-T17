package com.mygdx.game.systems;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.components.ComponentPosition;
import com.mygdx.game.components.ComponentVelocity;
import com.mygdx.game.Entity;

import java.util.ArrayList;

public class SystemUpdatePositionByVelocity {
    public SystemUpdatePositionByVelocity(){}

    public void Update(ArrayList<Entity> entities){
        for(Entity entity : entities){
            if(entity.hasComponent(ComponentPosition.class) && entity.hasComponent(ComponentVelocity.class)){
                ComponentPosition position = (ComponentPosition) entity.getComponent(ComponentPosition.class);
                ComponentVelocity velocity = (ComponentVelocity) entity.getComponent(ComponentVelocity.class);

                if (((0<position.getX())||(velocity.getXSpeed()>0))
                    &&((position.getX())<500||(velocity.getXSpeed()<0))) {
                    position.setX(position.getX()+ velocity.getXSpeed()* Gdx.graphics.getDeltaTime());
                }

                if (((0<position.getY())||(velocity.getYSpeed()>0))
                        &&((position.getY())<500||(velocity.getYSpeed()<0))) {
                    position.setY(position.getY()+ velocity.getYSpeed()* Gdx.graphics.getDeltaTime());
                }
            }
        }
    }
}
