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
import java.util.HashMap;
import java.util.Objects;

/**
 * System which renders all sprites.
 */
public class SystemRender extends UpdateSystem{
    Texture playerLeft;
    Texture playerRegular;
    Texture playerRight;
    Texture playerUp;
    Texture playerDown;

    // Constructs the render system and defines the textures of the player's movements.
    public SystemRender() {
        playerRight = new Texture(Gdx.files.internal("player_sprite_right.png"));
        playerLeft = new Texture(Gdx.files.internal("player_sprite_left.png"));
        playerRegular = new Texture(Gdx.files.internal("player_sprite_still.png"));
        playerUp = new Texture(Gdx.files.internal("player_sprite_up.png"));
        playerDown = new Texture(Gdx.files.internal("player_sprite_down.png"));

    }

    /**
     * Render all entities with sprites.
     * @param entities all entities
     * @param batch Spritebatch (draws all sprites from each entity in `entities` at same time)
     */
    public void update(HashMap<String, Entity> entities,SpriteBatch batch) {

        // Initialises a camera for this frame.
        OrthographicCamera camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // List of entities considered visible objects on screen
        // Note: the player controller is initialised as null, meaning the code will break if there
        // is no player entity.
        ArrayList<Entity> visibleObjects = new ArrayList<>();

        // Sets proportion of Map relative to other sprites
        float mapWidth = 1;
        float mapHeight = 1;
        // Finds the map
        Map map = (Map) entities.get("Map");
        ComponentPosition mapPosition = (ComponentPosition) map.getComponent(ComponentPosition.class);
        mapWidth = (float) mapPosition.getRawWidth();
        mapHeight = (float) mapPosition.getRawHeight();

        // Finds all objects to be rendered.
        for (String name : entities.keySet()) {
            Entity currentEntity = entities.get(name);
            if(currentEntity.hasComponent(ComponentSprite.class)){
                if(name.equals("Player")) {
                    // Updates the camera's position to be over the centre of the player
                    ComponentPosition player = (ComponentPosition) currentEntity.getComponent(ComponentPosition.class);
                    camera.position.set((float) (player.getX() + player.getWidth() / 2), (float) (player.getY() + player.getHeight() / 2), 0);
                    camera.update();
                    float targetX = (float) (player.getX() + player.getWidth() / 2);
                    float targetY = (float) (player.getY() + player.getHeight() / 2);

                    // Check if player is past the center of the window
                    if ((float) (player.getX() + player.getWidth() / 2) < (Gdx.graphics.getWidth() / 2f)) {
                        // If the camera can follow without leaving the bounds of the game world, set the player as center
                        targetX = Gdx.graphics.getWidth() / 2f;
                    }
                    if ((float) (player.getX() + player.getWidth() / 2) > ((mapWidth - 0.5) * Gdx.graphics.getWidth())) {
                        targetX = (float) (mapWidth - 0.5) * Gdx.graphics.getWidth();
                    }
                    if ((float) (player.getY() + player.getHeight() / 2) < (Gdx.graphics.getHeight() / 2f)) {
                        targetY = Gdx.graphics.getHeight() / 2f;
                    }
                    if ((float) (player.getY() + player.getHeight() / 2) > ((mapHeight - 0.5) * Gdx.graphics.getHeight())) {
                        targetY = (float) (mapHeight - 0.5) * Gdx.graphics.getHeight();
                    }

                    // Interpolate camera position for smooth movement
                    camera.position.lerp(new Vector3(targetX, targetY, 0), 0.5f);
                    camera.position.set(targetX, targetY, 0);
                    camera.update();

                    // Changes player texture to point in correct direction
                    ComponentPosition position = (ComponentPosition) currentEntity.getComponent(ComponentPosition.class);
                    ComponentVelocity velocity = (ComponentVelocity) currentEntity.getComponent(ComponentVelocity.class);
                    ComponentSprite sprite = (ComponentSprite) currentEntity.getComponent(ComponentSprite.class);

                    // Changes the texture of the player depending on their movements in a given direction.
                    if (velocity.getXSpeed() > 0) {
                        sprite.setSprite(playerRight);

                    }
                    if (velocity.getXSpeed() < 0) {
                        sprite.setSprite(playerLeft);

                    }
                    if (velocity.getXSpeed() == 0) {
                        sprite.setSprite(playerRegular);

                    }
                    if (velocity.getYSpeed() > 0) {
                        sprite.setSprite(playerUp);

                    }
                    if (velocity.getYSpeed() < 0) {
                        sprite.setSprite(playerDown);

                    }
                }
                if(!name.equals("Map")){
                    visibleObjects.add(currentEntity);
                }
            }


        }
        visibleObjects.add(0,entities.get("Map"));

        for (Entity entity : visibleObjects) {
            DrawSprite(entity, batch, camera);
        }
    }

    /**
     * Dispose all assets used in rendering.
     * @param entities all entities
     */
    public void dispose(HashMap<String,Entity> entities) {
        for (Entity entity : entities.values()) {
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
    void DrawSprite(Entity entity, SpriteBatch batch, OrthographicCamera camera) {

        //Draws in each entity's Sprite at its coordinates
        ComponentPosition position = (ComponentPosition) entity.getComponent(ComponentPosition.class);
        ComponentVelocity velocity = (ComponentVelocity)  entity.getComponent(ComponentVelocity.class);
        ComponentSprite sprite = (ComponentSprite) entity.getComponent(ComponentSprite.class);

        batch.setProjectionMatrix(camera.combined); //tells the SpriteBatch to use the coordinate system specified by the camera
        batch.draw(sprite.getSprite(), (float) (position.getX()), (float) (position.getY()), (float) (position.getWidth()), (float) (position.getHeight()));

////        // This changes the direction of the player sprite
//        if (entity.hasComponent(ComponentSpecialEntityFlag.class)){
//
//            ComponentSpecialEntityFlag flag = (ComponentSpecialEntityFlag)  entity.getComponent(ComponentSpecialEntityFlag.class);
//            if(flag.getFlag().equals("Player")){
//                //Changes player's sprite when moving or still (based on velocity)
//                if (velocity.getXSpeed() > 0) {
//                    //playerEntity.ComponentSprite.setSprite(Texture(Gdx.files.internal("player_sprite_still.png")));
//                    sprite.setSprite(playerRight);
//
//                }
//                if (velocity.getXSpeed() < 0) {
//                    //playerEntity.ComponentSprite.setSprite(Texture(Gdx.files.internal("player_sprite_still.png")));
//                    sprite.setSprite(playerLeft);
//
//                }
//                if (velocity.getXSpeed() == 0) {
//                    //playerEntity.ComponentSprite.setSprite(Texture(Gdx.files.internal("player_sprite_still.png")));
//                    sprite.setSprite(playerRegular);
//
//                }
//            }
//        }

    }

}

