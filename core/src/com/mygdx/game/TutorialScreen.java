package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class TutorialScreen implements Screen {

    private Stage stage;
    MyGdxGame parent;
    private Texture backgroundImage;

    /**
     * Creates the new tutorial screen and specifies the background image.
     * @param gameLoop the parent game loop
     */
    public TutorialScreen(MyGdxGame gameLoop) {
        this.parent = gameLoop;
        // create stage and set it as input processor
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        // Load the background image
        backgroundImage = new Texture(Gdx.files.internal("bg.png")); // Replace "bg.png" with the path to your background image

        // Create an Image widget with the background texture
        Image background = new Image(backgroundImage);
        stage.addActor(background); // Add the background image to the stage
    }

    /**
     * Creates the text and buttons that are displayed to make up
     * the tutorial screen.
     */
    @Override
    public void show() {
        // Create a table that fills the screen. Everything else will go inside this table.
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        // temporary until we have asset manager in
        Skin skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        // Tutorial text
        Label tutorialLabel = new Label("Welcome to the tutorial!", skin, "black");
        table.add(tutorialLabel).colspan(2).center().padBottom(50);
        table.row();

        Label instruction1 = new Label("1. Use arrow keys to move.", skin);
        table.add(instruction1).colspan(2).left().padBottom(20);
        table.row();

        Label instruction2 = new Label("2. Press spacebar to interact with activities.", skin);
        table.add(instruction2).colspan(2).left().padBottom(20);
        table.row();

        Label instruction3 = new Label("3. Balance eating, relaxing and studying to do well on your exams!", skin);
        table.add(instruction3).colspan(2).left().padBottom(20);
        table.row();

        // Back button
        TextButton back = new TextButton("Back", skin, "small");
        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.toMainScreen();
            }
        });
        table.add(back).fillX().uniformX().colspan(2);
    }

    /**
     * Render the tutorial screen
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {
        // clear the screen ready for next set of images to be drawn
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell our stage to do actions and draw itself
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    /**
     * Deal with the screen re-sizing
     * @param width the new screen width
     * @param height the new screen height
     */
    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
        // Resize the background image to fill the entire screen
        stage.getActors().first().setSize(width, height);
    }


    @Override
    public void pause() {
        // TODO Auto-generated method stub
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub
    }

    /**
     * Dispose of assets when not needed anymore
     */
    @Override
    public void dispose() {
        // dispose of assets when not needed anymore
        stage.dispose();
    }
}
