package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class GameScreen implements Screen {
    final MyGdxGame game;
    SpriteBatch batch;
    BitmapFont font;
    Texture img;
    Stage stage;
    private ShapeRenderer shapeRenderer;
    private OrthographicCamera camera;
    private float x = 100;
    private float y = 100;
    private float width = 100;
    private float height = 100;

    public GameScreen(final MyGdxGame game) {
        this.game = game;

        //creates a shape to represent Player
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        shapeRenderer = new ShapeRenderer();

        //adds a font and screen
        font = new BitmapFont(); // use libGDX's default Arial font
        //this.setScreen(new GameScreen(this)); commented out to check screens

        // Create OrthographicCamera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        //initialises a cover for the entire screen to enable event capture
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
    }
    @Override
    public void render(float delta) {
        //super.render(); //[Note used as create() does not apply to Screen] important! Renders Screen set in create() method if you override the render method in your Game class

        // Clear the screen with a white color
        ScreenUtils.clear(1, 1, 1, 1);

        // Update camera to follow the asset
        camera.position.set(x + width / 2, y + height / 2, 0);
        camera.update();

        // Set the batch projection matrix to the camera's combined matrix
        batch.setProjectionMatrix(camera.combined);
        shapeRenderer.setProjectionMatrix(camera.combined);

        // Start sprite batch rendering
        batch.begin();
        batch.draw(img, 0, 0);
        //test text on screen once collision is implemented
        //game.font.draw(game.batch, "Test text" + 1, 0, 480);
        batch.end();

        // Start rendering shapes
        shapeRenderer.begin(ShapeType.Filled);

        // Set the color to red
        shapeRenderer.setColor(Color.RED);

        // Draw a small red block at position (x, y) with width and height of 10 pixels
        shapeRenderer.rect(x, y, width, height);



        // End rendering shapes
        shapeRenderer.end();

        handleInput();
    }

    private void handleInput() {
        // Move the block with arrow keys
        // Perhaps need a check to reduce speed when two keys are pressed at once?
        // Moves quite fast diagonally.
        if (Gdx.input.isKeyPressed(Keys.LEFT) && x > 0) {
            x -= 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT) && x < 720) {
            x += 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Keys.UP) && y < 480) {
            y += 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Keys.DOWN) && y > 0) {
            y -= 200 * Gdx.graphics.getDeltaTime();
        }
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
        shapeRenderer.dispose();
    }
}
