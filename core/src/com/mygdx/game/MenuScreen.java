package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

class MenuScreen implements Screen{

    final MyGdxGame game;

    OrthographicCamera camera;
    Texture CreditsImg;
    Texture SettingsImg;

    public MenuScreen(MyGdxGame game) {
        this.game = game;
        CreditsImg = new Texture("button1.png");
        SettingsImg = new Texture("button1.png");
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getWidth());
    }
    Texture texture1;
    //Screen interface does not provide any sort of create() method, so a constructor is used

    public void update() {
        //Initialises Spritebatch for drawing in sprites
        SpriteBatch batch = new SpriteBatch();

        // Initialises a camera for this frame.
        OrthographicCamera camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        camera.position.set(0,0, 0);
        camera.update();

        // Defines the shape renderer to draw shapes.
        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        DrawSprite(100,100, CreditsImg, batch, camera);

        // Ends the shape renderer
        shapeRenderer.end();
    }


    public void dispose() {
        texture1.dispose();
    }

    void DrawSprite(int x, int y, Texture sprite, SpriteBatch batch, OrthographicCamera camera) {

        //Draws in each entity's Sprite at its coordinates
        batch.setProjectionMatrix(camera.combined); //tells the SpriteBatch to use the coordinate system specified by the camera
        batch.begin();
        // We have to remember that .draw draws the sprite from the bottom left corner,
        // but we store positions as the centre of sprites.
        // Therefor a conversion has to be made before drawing.
        batch.draw(sprite, x, y,100,100);
        batch.end();
    }


    @Override
    public void resize(int width, int height) {
    }
    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {

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

//    @Override
////    public void dispose() {
////    }

}