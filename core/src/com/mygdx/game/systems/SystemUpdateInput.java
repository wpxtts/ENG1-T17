package com.mygdx.game.systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.components.ComponentInput;
import com.mygdx.game.entities.Entity;

import java.util.ArrayList;

/**
 * Updates Input components to reflect current input
 */
public class SystemUpdateInput {
    public SystemUpdateInput() {}

    public void update(ArrayList<Entity> entities) {
        // Loop through entities to find those with the Input component.
        for(Entity entity : entities){
            if(entity.hasComponent(ComponentInput.class)){
                ComponentInput inputComponent = ((ComponentInput)entity.getComponent(ComponentInput.class));
                ArrayList<String> oldKeysPressed = inputComponent.getKeysPressed();

                ArrayList<String> newKeysPressed = new ArrayList<>();

                // Add keys being pressed to the list.
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
                    // We differentiated between the first cycle frame is pressed
                    // down ("SPACE") and then the subsequent cycles when space is still
                    // held down because the user hasn't let go yet ("SPACE_CONTINUED").
                    if(oldKeysPressed.contains("SPACE") || oldKeysPressed.contains("SPACE_CONTINUED")){
                        newKeysPressed.add("SPACE_CONTINUED");
                    }else {
                        newKeysPressed.add("SPACE");
                    }
                }
                if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
                    newKeysPressed.add("ESCAPE");
                }

                // Save results back to input component.
                inputComponent.setKeysPressed(newKeysPressed);
            }
        }
    }
}
