package com.mygdx.game.systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.components.ComponentInput;
import com.mygdx.game.entities.Entity;

import java.util.ArrayList;

public class SystemUpdateInput {
    public SystemUpdateInput() {}

    public void update(ArrayList<Entity> entities) {



        for(Entity entity : entities){
            if(entity.hasComponent(ComponentInput.class)){
                ComponentInput inputComponent = ((ComponentInput)entity.getComponent(ComponentInput.class));
                ArrayList<String> oldKeysPressed = inputComponent.getKeysPressed();

                ArrayList<String> newKeysPressed = new ArrayList<>();

                // Moves the player according to the user's input.
                if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                    newKeysPressed.add("LEFT");
                }
                if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                    newKeysPressed.add("RIGHT");
                }
                if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                    newKeysPressed.add("UP");
                }
                if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                    newKeysPressed.add("DOWN");
                }
                if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
                    if(oldKeysPressed.contains("SPACE") || oldKeysPressed.contains("SPACE_CONTINUED")){
                        newKeysPressed.add("SPACE_CONTINUED");
                    }else {
                        newKeysPressed.add("SPACE");
                    }
                }
                inputComponent.setKeysPressed(newKeysPressed);
            }
        }
    }
}
