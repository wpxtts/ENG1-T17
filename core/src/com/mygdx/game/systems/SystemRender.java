package com.mygdx.game.systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.components.ComponentPlayerFlag;
import com.mygdx.game.components.ComponentPosition;
import com.mygdx.game.components.ComponentSprite;
import com.mygdx.game.Entity;

import java.util.ArrayList;

public class SystemRender {

    public SystemRender() {}

    public void Update(Entity[] entities) {

        // Initialises a camera for this frame.
        OrthographicCamera camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // Note the player controller is initialised as null, meaning the code will break if there
        // is no player entity.
        ArrayList<Entity> visibleObjects = new ArrayList<Entity>();

        // Finds all objects to be rendered.
        for (Entity entity : entities) {
            if(entity.hasComponent(ComponentSprite.class)){
                visibleObjects.add(entity);
                if(entity.hasComponent(ComponentPlayerFlag.class)){
                    // Updates the camera's position to be over the centre of the player
                    ComponentPosition player = (ComponentPosition) entity.getComponent(ComponentPosition.class);
                    camera.position.set(player.getX() + player.getWidth() / 2, player.getY() + player.getHeight() / 2, 0);
                    camera.update();
                }
            }

//            ComponentSprite sprite = entity.GetSpriteComponent();
//
//            if (sprite != null) {
//                visibleObjects.add(entity);
//
//                if (entity.GetPlayerControllerComponent() != null) {
//
//                    // Updates the camera's position to be over the centre of the player
//                    ComponentPosition player = entity.GetPositionComponent();
//                    camera.position.set(player.x + player.width / 2, player.y + player.height / 2, 0);
//                    camera.update();
//
//                }
//            }

        }
        
        // Defines the shape renderer to draw shapes.
        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        for (Entity entity : visibleObjects) {
            DrawCuboid((ComponentPosition) entity.getComponent(ComponentPosition.class), shapeRenderer);
        }

        // Ends the shape renderer
        shapeRenderer.end();
    }

    void DrawCuboid(ComponentPosition object, ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(Color.BLUE); // Set the color to the player's color
        shapeRenderer.rect(object.getX(), object.getY(), object.getWidth(), object.getHeight());
    }

}
