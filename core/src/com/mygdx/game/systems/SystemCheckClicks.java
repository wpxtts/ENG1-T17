package com.mygdx.game.systems;

import com.mygdx.game.components.*;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.screens.Screen;
import com.mygdx.game.serviceProviders.ClickEffectProvider;

import java.util.ArrayList;

public class SystemCheckClicks{

    ArrayList<Entity> clickableEntities;

    public SystemCheckClicks() {}

    public Screen update(ArrayList<Entity> entities) {


        ArrayList<Entity> clickableEntities = new ArrayList<Entity>();

        // Finds collision object entities and player entity.
        for (Entity entity : entities) {

            if(entity.hasComponent(ComponentClick.class) &&
                    entity.hasComponent(ComponentPosition.class)){
                clickableEntities.add(entity);

            }
        }

        // If the entity is the player, check its collision with all objects.
        for (Entity clickableEntity : clickableEntities) {
            //if(entityClicked){
            if(true){
                ComponentClick clickComponent = (ComponentClick) clickableEntity.getComponent(ComponentClick.class);
                ClickEffectProvider clickEffect = clickComponent.getClickEffect();
                clickEffect.clickEffect();
            }
        }
//            if(true){
//                int mouseX = Gdx.input.getX(); //Uses top left as (0,0)
//                int mouseY = Gdx.input.getY();
//
//                if(mouseX>100 & mouseY>100){
//                    return new GameScreen();
//                }
//            }
//        }
        return null;
    }
}
