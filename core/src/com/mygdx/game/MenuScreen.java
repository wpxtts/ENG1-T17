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

public class MenuScreen implements Screen{

    TextButton newGame;
    TextButton tutorial;
    TextButton credits;
    private Stage stage;
    MyGdxGame parent;
    private Texture backgroundImage;


    public MenuScreen(MyGdxGame gameLoop){

        this.parent = gameLoop;
        /// create stage and set it as input processor
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        // Load the background image
        backgroundImage = new Texture(Gdx.files.internal("bg.png")); // Replace "background.jpg" with the path to your background image

        // Create an Image widget with the background texture
        Image background = new Image(backgroundImage);
        stage.addActor(background); // Add the background image to the stage
    }

    @Override
    public void show() {
        // Create a table that fills the screen. Everything else will go inside this table.
        Table table = new Table();
        table.setFillParent(true);
//        table.setDebug(true);
        stage.addActor(table);

        // temporary until we have asset manager in
        Skin skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        // Add game title as a label
        Label titleLabel = new Label("Heslington Hustle", skin, "black");
        table.add(titleLabel).colspan(3).padBottom(50).center(); // Center the title horizontally
        table.row();

        table.row();

        //create buttons
        newGame = new TextButton("New Game", skin);
        tutorial = new TextButton("Tutorial", skin);
        credits = new TextButton("Credits", skin);

        //add buttons to table
        table.add(newGame).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(tutorial).fillX().uniformX().center();;
        table.row();
        table.add(credits).fillX().uniformX().center();;

        // create button listeners
        credits.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Credits");
                parent.toScoreScreen();
            }
        });

        newGame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("New Game");
                parent.toGameScreen();
            }
        });

        tutorial.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Tutorial");
                parent.toTutorialScreen();
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
        newGame.setVisible(false);
        tutorial.setVisible(false);
        credits.setVisible(false);
    }

    @Override
    public void dispose() {
        // dispose of assets when not needed anymore
        stage.dispose();
    }

}