package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

import com.mygdx.game.components.ComponentTime;
import com.mygdx.game.entities.*;
import com.mygdx.game.systems.*;

import java.util.ArrayList;
import java.util.HashMap;

public class GameScreen implements Screen {
    final MyGdxGame game;
    SpriteBatch batch;
    BitmapFont font;
    Texture img;
    Stage stage;
    HashMap<String, Entity> entities;
    SystemUpdateInput updateInputSystem;
    SystemUpdateVelocityByInput updateVelocityByInputSystem;
    SystemUpdatePositionByVelocity updatePositionByVelocitySystem;
    SystemCollision collisionSystem;
    SystemRender renderSystem;
    SystemTime timeSystem;
    SystemText textSystem;

    public GameScreen(final MyGdxGame game) {
        this.game = game;
        entities = new HashMap<>();



        entities.put("Player",new Player());

        entities.put("Library",new Library(1.35, 1.4,0.4, 0.4));
        entities.put("DuckPond",new DuckPond(0.75,0.4, 0.35,0.25));
        entities.put("Piazza",new Piazza(1.3,0.6, 0.2,0.4));
        entities.put("Accommodation",new Accommodation(0.5,1.2, 0.2,0.2));

        entities.put("Map",new Map(0,0, 2, 2)); //currently the map's sprite size is 3000 x 1896

        entities.put("TimeTracker",new TimeTracker());

        updateInputSystem = new SystemUpdateInput();
        updateVelocityByInputSystem = new SystemUpdateVelocityByInput();
        updatePositionByVelocitySystem = new SystemUpdatePositionByVelocity();
        collisionSystem = new SystemCollision();
        renderSystem = new SystemRender();
        timeSystem = new SystemTime();
        textSystem = new SystemText();

    }
    @Override
    public void render(float delta) {
        // Turn the screen black.
        ScreenUtils.clear(0, 0, 0, 1);

        // Check for escape key input to open the pause menu
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            // Switch to PauseMenu screen
            game.setScreen(new PauseMenu(game));
        }

        game.batch.begin();

        // Update all the systems every frame
        UpdateFrame();

        game.batch.end();

        // Update clock in corner to display after updating, so that it appears on top.
        game.batch.begin();

        // Set font color to black
        game.font.setColor(Color.BLACK);

        // Set font scale
        game.font.getData().setScale(2);

        // Get time
        ComponentTime time = (ComponentTime)entities.get("TimeTracker").getComponent(ComponentTime.class);

        // Draw the clock
        game.font.draw(game.batch, time.getTimeString(), 20, 30);
        game.batch.end();

    }



    @Override
    public void resize(int width, int height) {
        System.out.println(width);
        System.out.println(height);
    }
    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        System.out.println("GameScreen dispose called");
        game.batch.dispose();
        game.font.dispose();
//        img.dispose();
        renderSystem.dispose(entities);
        game.shapeRenderer.dispose();
    }

    /**
     * Update each system.
     */
    void UpdateFrame() {
        updateInputSystem.update(entities);
        updateVelocityByInputSystem.update(entities);
        updatePositionByVelocitySystem.update(entities);
        collisionSystem.update(entities);
        renderSystem.update(entities,game.shapeRenderer,game.batch);
        textSystem.update(entities);
        timeSystem.update(entities);
    }
}