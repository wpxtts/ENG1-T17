package com.mygdx.game.systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.components.ComponentInput;
import com.mygdx.game.entities.Entity;

import java.util.ArrayList;

public class SystemUpdateInput {
    public SystemUpdateInput() {}

    public void update(ArrayList<Entity> entities) {

        ArrayList<String> keysPressed = new ArrayList<>();

        // Moves the player according to the user's input.
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            keysPressed.add("LEFT");
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            keysPressed.add("RIGHT");
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            keysPressed.add("UP");
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            keysPressed.add("DOWN");
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            keysPressed.add("SPACE");
        }

        for(Entity entity : entities){
            if(entity.hasComponent(ComponentInput.class)){
                ((ComponentInput)entity.getComponent(ComponentInput.class)).setKeysPressed(keysPressed);
            }
        }
    }
}