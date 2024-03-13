package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class MenuScreen implements Screen {

    final MyGdxGame game;

    OrthographicCamera camera;
    Texture CreditsImg;
    Texture SettingsImg;

    public MenuScreen(final MyGdxGame game) {
        this.game = game;
        CreditsImg = new Texture("button1.png");
        SettingsImg = new Texture("button1.png");
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
        game.font.draw(game.batch, "Welcome to Heslington Hustle! ", 100, 150);
        game.font.draw(game.batch, "Tap anywhere to begin!", 100, 100);

        //Draws in Menu buttons
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.draw(CreditsImg, 160, 100, 100, 55);
        game.batch.draw(SettingsImg, 560, 100, 100, 55);
        game.batch.end();

        int mouseX = Gdx.input.getX();
        int mouseY = Gdx.input.getY();

        if (mouseX >= 160 && mouseX <= 160 + CreditsImg.getWidth()) {
            if (mouseY >= 100 && mouseY <= 100 + CreditsImg.getHeight()) {
                if (Gdx.input.isTouched()) {
                    game.font.draw(game.batch, "CREDITS", 100, 150);
                }
            }
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