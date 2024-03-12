package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class SystemRender {

    SystemRender() {}

    public void Update(Entity[] entities) {

        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        for (int i = 0; i < entities.length; i++) {

            ComponentCollision collision = entities[i].GetCollisionComponent();
            ComponentPlayerController playerController = entities[i].GetPlayerControllerComponent();

            if (collision != null) {
                DrawCollisionObject(collision, shapeRenderer);
            }

            else if (playerController != null) {
                DrawPlayer(playerController, shapeRenderer);
            }

        }

        shapeRenderer.end();

    }

    void DrawPlayer(ComponentPlayerController player, ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rect(player.x, player.y, player.width, player.height);
    }

    void DrawCollisionObject(ComponentCollision collision, ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rect(collision.x, collision.y, collision.width, collision.height);
    }

}
