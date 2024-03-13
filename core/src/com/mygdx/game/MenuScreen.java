package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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

        // System.out.println("Mouse X: " + mouseX + ", Mouse Y: " + mouseY);
        if (mouseX >= 140 && mouseX < 232) {
            if (mouseY >= 325 && mouseY < 380) {
                if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                    System.out.println("Button pressed on the left");
                    game.setScreen(new GameScreen(game));
                    dispose();
                }
            }
        }
        if (mouseX >= 505 && mouseX < 595) {
            if (mouseY >= 325 && mouseY < 380) {
                if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                    System.out.println("Button pressed on the right");
                    game.setScreen(new SettingsScreen(game));
                    dispose();
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