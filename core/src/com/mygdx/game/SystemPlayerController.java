package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class SystemPlayerController {

    SystemPlayerController() {}

    public void Update(Entity[] entities) {

        ComponentPlayerController player = null;

        for (int i = 0; i < entities.length; i++) {

            ComponentPlayerController playerController = entities[i].GetPlayerControllerComponent();

            if (playerController != null) {
                player = playerController;
                break;
            }

        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && player.x > 0) {
            player.x -= 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player.x < 720) {
            player.x += 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP) && player.y < 480) {
            player.y += 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && player.y > 0) {
            player.y -= 200 * Gdx.graphics.getDeltaTime();
        }

    }

}
