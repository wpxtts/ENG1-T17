package com.mygdx.game;//package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class CreditScreen implements Screen{

    private Stage stage;
    private Texture backgroundImage;

    MyGdxGame parent;

    public CreditScreen(MyGdxGame gameLoop){

        this.parent = gameLoop;
        /// create stage and set it as input processor
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        // Load the background image
        backgroundImage = new Texture(Gdx.files.internal("bg.png"));

        // Create an Image widget with the background texture
        Image background = new Image(backgroundImage);
        stage.addActor(background); // Add the background image to the stage
    }

    @Override
    public void show() {
        // Create a table that fills the screen. Everything else will go inside this table.
        Table table = new Table();
        table.setFillParent(true);
        // Set the table's alignment to center
        table.center();
        // Add the table to the stage
        stage.addActor(table);

        // temporary until we have asset manager in
        Skin skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        // Create the title label
        Label titleLabel = new Label("Credits", skin, "black");
        // Add the title label to the table and center it
        table.add(titleLabel).center().padBottom(30).colspan(2);
        table.row();

        // Names
        String[] names = {"William Potts", "Seyi Towolawi", "George Jopson", "Alex Staicu", "Ben Slater", "Meg Tierney", "James Burgess","Raymond \"Raeleus\" Buckley for the Buttons"};
        for (String name : names) {
            Label nameLabel = new Label(name, skin, "default");
            table.add(nameLabel).colspan(2).center().padBottom(10);
            table.row();
        }

        // Create the back button
        TextButton back = new TextButton("Back", skin, "small");
        // Add the back button to the table and center it
        table.add(back).center().fillX().uniformX().padTop(30).colspan(2);
        table.row();

        // Create button listeners
        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.toMainScreen();
            }
        });
    }

    @Override
    public void render(float delta) {
        // clear the screen ready for next set of images to be drawn
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell our stage to do actions and draw itself
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

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

    @Override
    public void dispose() {
        // dispose of assets when not needed anymore to save memory usage
        stage.dispose();
    }

}