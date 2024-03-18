package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

import com.mygdx.game.entities.*;
import com.mygdx.game.systems.*;

import java.util.ArrayList;

public class GameScreen implements Screen {
    final MyGdxGame game;
    SpriteBatch batch;
    BitmapFont font;
    Texture img;
    Stage stage;
    ArrayList<Entity> entities;
    SystemUpdateInput updateInputSystem;
    SystemUpdateVelocityByInput updateVelocityByInputSystem;
    SystemUpdatePositionByVelocity updatePositionByVelocitySystem;
    SystemCollision collisionSystem;
    SystemRender renderSystem;
    SystemTime timeSystem;

    public GameScreen(final MyGdxGame game) {
        this.game = game;
        entities = new ArrayList<>();
        entities.add(new Map(0,0, Gdx.graphics.getHeight(), Gdx.graphics.getWidth())); //currently the map's sprite size is 3000 x 1896
        entities.add(new Player());

        entities.add(new Library(1600, 700,50, 100));
        entities.add(new DuckPond(2070,600, 100,100));
        entities.add(new Piazza(3330,1500, 100,100));
        entities.add(new Accommodation(1650,2925, 100,100));

        updateInputSystem = new SystemUpdateInput();
        updateVelocityByInputSystem = new SystemUpdateVelocityByInput();
        updatePositionByVelocitySystem = new SystemUpdatePositionByVelocity();
        collisionSystem = new SystemCollision();
        renderSystem = new SystemRender();

        timeSystem = new SystemTime();

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
        timeSystem.update(delta);

        // Get current hour and minute from the time system
        int hour = timeSystem.getCurrentHour();
        int minute = timeSystem.getCurrentMinute();

        // Draw the digital clock
        String timeString = String.format("%02d:%02d", hour, minute);
        game.batch.begin();
        game.font.draw(game.batch, timeString, 10, Gdx.graphics.getHeight() - 10);
        game.batch.end();

        // Update all the systems every frame
        UpdateFrame();
    }



    @Override
    public void resize(int width, int height) {
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
        batch.dispose();
        font.dispose();
        img.dispose();
        //shapeRenderer.dispose();
    }

    /**
     * Update each system.
     */
    void UpdateFrame() {
        updateInputSystem.update(entities);
        updateVelocityByInputSystem.update(entities);
        updatePositionByVelocitySystem.update(entities);
        collisionSystem.update(entities);
        renderSystem.update(entities);
    }
}
