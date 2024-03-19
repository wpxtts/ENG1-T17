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

public class ScoreScreen implements Screen{

    private Stage stage;
    private Texture backgroundImage;

    MyGdxGame parent;

    public ScoreScreen(MyGdxGame gameLoop){

        this.parent = gameLoop;
        /// create stage and set it as input processor
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        // Load the background image
        backgroundImage = new Texture(Gdx.files.internal("certificate.png")); // Replace "bg.png" with the path to your background image

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


        Label titleLabel = new Label( "The End", skin ,"black");
        table.add(titleLabel);
        table.row();

        // Names
        String[] names = {"Study Score", "Wellbeing Score", "Overall Grade", "Thank you for Playing!"};
        int study_score, wellbeing_score;
        double grade;
        study_score = 500;
        wellbeing_score = 350;
        grade = Math.min((Math.log(study_score*wellbeing_score)+40), 100);
        double[] scores = {study_score, wellbeing_score, grade};
        for (int i = 0; i<names.length; i++) {
            String name = names[i];
            if (i<names.length-1){
                double score = scores[i];
                Label nameLabel = new Label(String.format("%s: %.2f", name, score), skin, "default");
                table.add(nameLabel).colspan(2).center().padBottom(10);
            }else{
                Label nameLabel = new Label(name, skin, "default");
                table.add(nameLabel).colspan(2).center().padBottom(10);
            }
            table.row();
        }

        //create buttons
        TextButton back = new TextButton("Back", skin, "small");

        //add buttons to table
        table.add(back).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);

        // create button listeners
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
        // dispose of assets when not needed anymore
        stage.dispose();
    }

}