package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class SystemRender {
    private Texture player_sprite;
    private Rectangle hit_box;
    private SpriteBatch batch;

    SystemRender() {}

    public void Update(Entity[] entities) {

        // Initialises a camera for this frame.
        OrthographicCamera camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // Note the player controller is initialised as null, meaning the code will break if there
        // is no player entity.
        ArrayList<ComponentCollision> collisionObjects = new ArrayList<ComponentCollision>();
        ComponentPlayerController player = null;

        // Finds all collidable objects and player.
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

        // Updates the camera's position to be over the centre of the player
        camera.position.set(player.x + player.width / 2, player.y + player.height / 2, 0);
        camera.update();

        // Defines the shape renderer to draw shapes.
        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        //Defines Texture which is image used for player's sprite.
        player_sprite = new Texture(Gdx.files.internal("player_sprite_1.png"));


        // Function that draws the player as shape. Commented out.
        //DrawCollisionObject(collision, shapeRenderer);

        //Adds rectangle hit box around character
        hit_box = new Rectangle();
        hit_box.x = player.x;
        hit_box.y = player.y;
        hit_box.width = player_sprite.getWidth();
        hit_box.height = player.height;

        //renders player Sprite each movement
        batch = new SpriteBatch();
        batch.setProjectionMatrix(camera.combined); //tells the SpriteBatch to use the coordinate system specified by the camera
        batch.begin();
        batch.draw(player_sprite, hit_box.x, hit_box.y);
        batch.end();




        // Draws all collidable objects
        for (int i = 0; i < collisionObjects.size(); i++) {

            ComponentCollision collision = collisionObjects.get(0);
            DrawCollisionObject(collision, shapeRenderer);

        }

        // Ends the shape renderer. Commented out.
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
