package com.mygdx.game.systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.components.ComponentPlayerFlag;
import com.mygdx.game.components.ComponentPosition;
import com.mygdx.game.components.ComponentSprite;
import com.mygdx.game.components.ComponentVelocity;
import com.mygdx.game.entities.Entity;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
//import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;

/**
 * System which renders all sprites.
 */
public class SystemRender {

    public SystemRender() {}

    /**
     * Render all entities with sprites.
     * @param entities all entities
     */
//    private static Viewport viewport;
    private static float screenWidth,screenHeight,cameraWidth,cameraHeight;
    private static float cameraLeftBound, cameraRightBound, cameraTopBound, cameraBottomBound;

    public static void update(ArrayList<Entity> entities) {
        //Initialises Spritebatch for drawing in sprites
        SpriteBatch batch = new SpriteBatch();

        // Initialises a camera and viewport for this frame.
        cameraWidth = Gdx.graphics.getWidth();
        cameraHeight = Gdx.graphics.getHeight();

        // Get screen dimensions
//        screenWidth = Gdx.graphics.getDisplayMode().width;
//        screenHeight = Gdx.graphics.getDisplayMode().height;
        screenWidth = Gdx.graphics.getDisplayMode().width;
        screenHeight = Gdx.graphics.getDisplayMode().height;

//        OrthographicCamera camera = new OrthographicCamera(cameraWidth, cameraHeight);
        OrthographicCamera camera = new OrthographicCamera(screenWidth, screenHeight);
        camera.position.set(cameraWidth / 2f, cameraHeight / 2f, 0);
//        camera.position.set(0, 0, 0);
        camera.update();

//        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        camera.position.set(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f, 0);

//        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);

//        viewport = new ExtendViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);

        // Calculate camera bounds
        cameraLeftBound = cameraWidth / 2f;
        cameraRightBound = (screenWidth - cameraWidth) / 2f;
        cameraBottomBound = cameraHeight / 2f;
        cameraTopBound = (screenHeight - cameraHeight) / 2f;

        // Note the player controller is initialised as null, meaning the code will break if there
        // is no player entity.
        ArrayList<Entity> visibleObjects = new ArrayList<>();

        // Finds all objects to be rendered.
        for (Entity entity : entities) {
            if(entity.hasComponent(ComponentSprite.class)){
                visibleObjects.add(entity);
                if(entity.hasComponent(ComponentPlayerFlag.class)){
                    // Updates the camera's position to be over the centre of the player
                    ComponentPosition player = (ComponentPosition) entity.getComponent(ComponentPosition.class);
//                    camera.position.set(player.getX() + player.getWidth() / 2, player.getY() + player.getHeight() / 2, 0);
                    //camera.position.set(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f, 0);
                    camera.position.set(
                            Math.min(cameraRightBound, Math.max(cameraLeftBound, player.getX())),
                            Math.min(cameraTopBound, Math.max(cameraBottomBound, player.getY())),
                            0
                    );
                    camera.update();
//                    viewport.apply(true);
                }
            }
        }

        
        // Defines the shape renderer to draw shapes.
        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        batch.begin();
        for (Entity entity : visibleObjects) {
            //DrawCuboid((ComponentPosition) entity.getComponent(ComponentPosition.class), shapeRenderer);
            boolean isPlayer = false;
            if(entity.hasComponent(ComponentPlayerFlag.class)){
                isPlayer = true;
            }
            DrawSprite((ComponentPosition) entity.getComponent(ComponentPosition.class), (ComponentVelocity) entity.getComponent(ComponentVelocity.class), (ComponentSprite) entity.getComponent(ComponentSprite.class), batch, camera, isPlayer);
        }
        batch.end();

        // Ends the shape renderer
        shapeRenderer.end();
    }

    /**
     * Temporary method to draw rectangle before we implement sprites.
     * @param object postion component of object to be rendered
     * @param shapeRenderer shapeRendered object which can be used to render
     *                      the rectangle to the screen.
     */

    public void dispose(ArrayList<Entity> entities){
        // Note the player controller is initialised as null, meaning the code will break if there
        // is no player entity.
        ArrayList<Entity> visibleObjects = new ArrayList<>();

        // Finds all assets to be disposed of.
        for (Entity entity : entities) {
            if(entity.hasComponent(ComponentSprite.class)){
                ComponentSprite sprite = (ComponentSprite) entity.getComponent(ComponentSprite.class);
                sprite.getSprite().dispose();
            }
        }
    }

    public void resize(ArrayList<Entity> entities, int width, int height){
        SystemRender.update(entities);
        // Update the viewport when the screen is resized
//        viewport.update(width, height, true);
        // Update screen dimensions and camera bounds on resize
        cameraLeftBound = cameraWidth / 2f;
        cameraRightBound = screenWidth - cameraWidth / 2f;
        cameraBottomBound = cameraHeight / 2f;
        cameraTopBound = screenHeight - cameraHeight / 2f;
    }

    void DrawCuboid(ComponentPosition object, ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(Color.BLUE); // Set the color to the player's color
        shapeRenderer.rect((object.getX()-object.getWidth()/2), (object.getY()-object.getHeight()/2), object.getWidth(), object.getHeight());
    }

    static void DrawSprite(ComponentPosition object, ComponentVelocity velocity, ComponentSprite sprite, SpriteBatch batch, OrthographicCamera camera, boolean isPlayer) {
//        object.setWidth(sprite.getSprite().getWidth());
//        object.setHeight(sprite.getSprite().getHeight());
        //Draws in each entity's Sprite at its coordinates
        batch.setProjectionMatrix(camera.combined); //tells the SpriteBatch to use the coordinate system specified by the camera
        batch.draw(sprite.getSprite(), object.getX(), object.getY());

        if (isPlayer){
            //Changes player's sprite when moving or still (based on velocity)
            if (velocity.getXSpeed() > 0) {
                //playerEntity.ComponentSprite.setSprite(Texture(Gdx.files.internal("player_sprite_still.png")));
                sprite.setSprite(new Texture(Gdx.files.internal("player_sprite_right.png")));

            }
            if (velocity.getXSpeed() < 0) {
                //playerEntity.ComponentSprite.setSprite(Texture(Gdx.files.internal("player_sprite_still.png")));
                sprite.setSprite(new Texture(Gdx.files.internal("player_sprite_left.png")));

            }
            if (velocity.getXSpeed() == 0) {
                //playerEntity.ComponentSprite.setSprite(Texture(Gdx.files.internal("player_sprite_still.png")));
                sprite.setSprite(new Texture(Gdx.files.internal("player_sprite_still.png")));

            }
        }
    }

}
