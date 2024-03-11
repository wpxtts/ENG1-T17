package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;

public class MenuScreen implements Screen {

    final MyGdxGame game;

    OrthographicCamera camera;

    public MenuScreen(final MyGdxGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

    //Screen interface does not provide any sort of create() method, so a constructor is used
    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();

        //Writes text to screen using game.font.draw(SpriteBatch, String, float, float)
        game.font.draw(game.batch, "Welcome to Heslington Hustle!!! ", 100, 150);
        game.font.draw(game.batch, "Tap anywhere to begin!", 100, 100);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
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
    }

}