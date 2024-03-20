package com.mygdx.game.systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.components.ComponentInput;
import com.mygdx.game.entities.Entity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * SystemUpdateInput class updates Input components to reflect the current input state.
 * It checks for keyboard input and updates the list of keys being pressed.
 */
public class SystemUpdateInput extends UpdateSystem{

    /**
     * Constructs a SystemUpdateInput object.
     */
    public SystemUpdateInput() {}

    /**
     * Updates Input components of entities to reflect the current input state.
     * @param entities The list of entities to update
     */
    public void update(HashMap<String, Entity> entities) {
        // Loop through entities to find those with the Input component.
        for(Entity entity : entities.values()){
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
                    // We differentiate between the first cycle frame is pressed
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
