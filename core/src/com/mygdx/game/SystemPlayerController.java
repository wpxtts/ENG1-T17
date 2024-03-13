package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class SystemPlayerController {

    SystemPlayerController() {}

    public void Update(Entity[] entities) {

        // Note the player controller is initialised as null, meaning the code will break if there
        // is no player entity.
        ComponentPosition playerPosition = null;

        // Finds the player.
        for (Entity entity : entities) {

            if(entity.hasComponent(ComponentPlayerController.class.getName())){
                playerPosition = (ComponentPosition) entity.getComponent(ComponentPosition.class.getName());
                break;
            }

        }

        // Moves the player according to the user's input.
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && playerPosition.x > 0) {
            playerPosition.x -= 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && playerPosition.x < 720) {
            playerPosition.x += 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP) && playerPosition.y < 480) {
            playerPosition.y += 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && playerPosition.y > 0) {
            playerPosition.y -= 200 * Gdx.graphics.getDeltaTime();
        }

    }

}
