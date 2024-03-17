package com.mygdx.game.systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
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

    public static void update(ArrayList<Entity> entities) {
        //Initialises Spritebatch for drawing in sprites
        SpriteBatch batch = new SpriteBatch();

        // Initialises a camera and viewport for this frame.
        OrthographicCamera camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

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
//                    camera.update();
                    float targetX = player.getX();
                    float targetY = player.getY();

                    // Check if player is past the center of the window
                    if (player.getX() < (Gdx.graphics.getWidth() / 2f)) {
                        // If the camera can follow without leaving the bounds of the game world, set the player as center
                        targetX = Gdx.graphics.getWidth() / 2f;
                    }
                    if (player.getX() > (4500 - (Gdx.graphics.getWidth()/ 2f))){
                        targetX = 4500 - (Gdx.graphics.getWidth() / 2f);
                    }
                    if (player.getY() < (Gdx.graphics.getHeight() / 2f)) {
                        targetY = Gdx.graphics.getHeight() / 2f;
                    }
                    if (player.getY() > (2845 - (Gdx.graphics.getHeight() / 2f))) {
                        targetY = 2845 - (Gdx.graphics.getHeight() / 2f);
                    }

                    // Interpolate camera position for smooth movement
//                    camera.position.lerp(new Vector3(targetX, targetY, 0), 0.5f);
                    camera.position.set(targetX, targetY, 0);
                    camera.update();
                }
            }


        }
        
        // Defines the shape renderer to draw shapes.
        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        for (Entity entity : visibleObjects) {
            //DrawCuboid((ComponentPosition) entity.getComponent(ComponentPosition.class), shapeRenderer);
            boolean isPlayer = false;
            if(entity.hasComponent(ComponentPlayerFlag.class)){
                isPlayer = true;
            }
            DrawSprite((ComponentPosition) entity.getComponent(ComponentPosition.class), (ComponentVelocity) entity.getComponent(ComponentVelocity.class), (ComponentSprite) entity.getComponent(ComponentSprite.class), batch, camera, isPlayer);
        }

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
        batch.begin();
        batch.draw(sprite.getSprite(), object.getX(), object.getY());
        batch.end();

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
