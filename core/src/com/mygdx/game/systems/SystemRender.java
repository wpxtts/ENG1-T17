package com.mygdx.game.systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.components.*;

import com.mygdx.game.entities.Entity;
import com.mygdx.game.entities.Map;

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
    public void update(ArrayList<Entity> entities) {
        //Initialises Spritebatch for drawing in sprites
        SpriteBatch batch = new SpriteBatch();

        // Initialises a camera for this frame.
        OrthographicCamera camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // Note the player controller is initialised as null, meaning the code will break if there
        // is no player entity.
        ArrayList<Entity> visibleObjects = new ArrayList<>();

        float mapWidth = 1;
        float mapHeight = 1;
        // Finds the map
        for(Entity entity: entities){
            if(entity.hasComponent(ComponentSpecialEntityFlag.class)){
                String flag = ((ComponentSpecialEntityFlag) entity.getComponent(ComponentSpecialEntityFlag.class)).getFlag();
                if(flag.equals("Map")){
                    Map map = (Map) entity;
                    ComponentPosition mapPosition = (ComponentPosition) entity.getComponent(ComponentPosition.class);
                    mapWidth = (float) mapPosition.getRawWidth();
                    mapHeight = (float) mapPosition.getRawHeight();
                }
            }
        }

        // Finds all objects to be rendered.
        for (Entity entity : entities) {
            if(entity.hasComponent(ComponentSprite.class)){
                visibleObjects.add(entity);
                if(entity.hasComponent(ComponentSpecialEntityFlag.class)){
                    String flag = ((ComponentSpecialEntityFlag) entity.getComponent(ComponentSpecialEntityFlag.class)).getFlag();
                    if(flag.equals("Player")){
                        // Updates the camera's position to be over the centre of the player
                        ComponentPosition player = (ComponentPosition) entity.getComponent(ComponentPosition.class);
                        camera.position.set((float) (player.getX()+player.getWidth()/2), (float) (player.getY()+player.getHeight()/2), 0);
                        camera.update();
                        float targetX = (float) (player.getX()+player.getWidth()/2);
                        float targetY = (float) (player.getY()+player.getHeight()/2);

                        // Check if player is past the center of the window
                        if ((float) (player.getX()+player.getWidth()/2) < (Gdx.graphics.getWidth() / 2f)) {
                            // If the camera can follow without leaving the bounds of the game world, set the player as center
                            targetX = Gdx.graphics.getWidth() / 2f;
                        }
                        if ((float) (player.getX()+player.getWidth()/2) > ((mapWidth-0.5)*Gdx.graphics.getWidth())){
                            targetX = (float) (mapWidth-0.5)*Gdx.graphics.getWidth();
                        }
                        if ((float) (player.getY()+player.getHeight()/2) < (Gdx.graphics.getHeight() / 2f)) {
                            targetY = Gdx.graphics.getHeight() / 2f;
                        }
                        if ((float) (player.getY()+player.getHeight()/2) > ((mapHeight-0.5)*Gdx.graphics.getHeight())){
                            targetY = (float) (mapHeight-0.5)*Gdx.graphics.getHeight();
                        }

                        // Interpolate camera position for smooth movement
                        camera.position.lerp(new Vector3(targetX, targetY, 0), 0.5f);
                        camera.position.set(targetX, targetY, 0);
                        camera.update();
                    }

                }
            }


        }

        // Defines the shape renderer to draw shapes.
        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        for (Entity entity : visibleObjects) {
            DrawSprite(entity, batch, camera);
        }

        // Ends the shape renderer
        shapeRenderer.end();
    }

    /**
     * Dispose all assets used in rendering.
     * @param entities all entities
     */
    public void dispose(ArrayList<Entity> entities) {
        for (Entity entity : entities) {
            if (entity.hasComponent(ComponentSprite.class)) {
                ComponentSprite sprite = (ComponentSprite) entity.getComponent(ComponentSprite.class);
                sprite.getSprite().dispose();
            }
        }
    }

    /**
     * Draw a sprite of an entity.
     * @param entity the entity to draw
     * @param batch the sprite batch to use for drawing
     * @param camera the camera used for rendering
     */
    static void DrawSprite(Entity entity, SpriteBatch batch, OrthographicCamera camera) {
//        object.setWidth(sprite.getSprite().getWidth());
//        object.setHeight(sprite.getSprite().getHeight());
        //Draws in each entity's Sprite at its coordinates
        ComponentPosition position = (ComponentPosition) entity.getComponent(ComponentPosition.class);
        ComponentVelocity velocity = (ComponentVelocity)  entity.getComponent(ComponentVelocity.class);
        ComponentSprite sprite = (ComponentSprite) entity.getComponent(ComponentSprite.class);

        batch.setProjectionMatrix(camera.combined); //tells the SpriteBatch to use the coordinate system specified by the camera
        batch.begin();
        batch.draw(sprite.getSprite(), (float) (position.getX()), (float) (position.getY()), (float) (position.getWidth()), (float) (position.getHeight()));
        batch.end();

        if (entity.hasComponent(ComponentSpecialEntityFlag.class)){

            ComponentSpecialEntityFlag flag = (ComponentSpecialEntityFlag)  entity.getComponent(ComponentSpecialEntityFlag.class);
            if(flag.getFlag().equals("Player")){
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

}
