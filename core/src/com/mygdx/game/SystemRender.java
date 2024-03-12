package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

public class SystemRender {

    SystemRender() {}

    public void Update(Entity[] entities) {

        OrthographicCamera camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        ArrayList<ComponentCollision> collisionObjects = new ArrayList<ComponentCollision>();
        ComponentPlayerController player = null;

        for (int i = 0; i < entities.length; i++) {

            ComponentCollision collision = entities[i].GetCollisionComponent();
            ComponentPlayerController playerController = entities[i].GetPlayerControllerComponent();

            if (collision != null) {
                collisionObjects.add(collision);
            }

            else if (playerController != null) {
                player = playerController;
            }

        }

        camera.position.set(player.x, player.y, 0);
        camera.update();

        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        DrawPlayer(player, shapeRenderer);

        for (int i = 0; i < collisionObjects.size(); i++) {

            ComponentCollision collision = collisionObjects.get(0);
            DrawCollisionObject(collision, shapeRenderer);

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
