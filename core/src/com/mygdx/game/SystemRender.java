package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

public class SystemRender {

    SystemRender() {}

    public void Update(Entity[] entities) {

        // Initialises a camera for this frame.
        OrthographicCamera camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // Note the player controller is initialised as null, meaning the code will break if there
        // is no player entity.
        ArrayList<Entity> visibleObjects = new ArrayList<Entity>();

        // Finds all objects to be rendered.
        for (int i = 0; i < entities.length; i++) {

            Entity entity = entities[i];
            ComponentSprite sprite = entity.GetSpriteComponent();

            if (sprite != null) {
                visibleObjects.add(entity);

                if (entity.GetPlayerControllerComponent() != null) {

                    // Updates the camera's position to be over the centre of the player
                    ComponentPosition player = entity.GetPositionComponent();
                    camera.position.set(player.x + player.width / 2, player.y + player.height / 2, 0);
                    camera.update();

                }
            }

        }
        
        // Defines the shape renderer to draw shapes.
        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        for (int i = 0; i < visibleObjects.size(); i++) {
            Entity entity = visibleObjects.get(0);
            DrawCuboid(entity.GetPositionComponent(), shapeRenderer);
        }

        // Ends the shape renderer
        shapeRenderer.end();
    }

    void DrawCuboid(ComponentPosition object, ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(Color.BLUE); // Set the color to the player's color
        shapeRenderer.rect(object.x, object.y, object.width, object.height);
    }

}
