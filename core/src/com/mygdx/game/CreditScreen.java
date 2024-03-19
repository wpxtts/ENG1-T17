package com.mygdx.game;//package com.mygdx.game;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.utils.ScreenUtils;
//
//public class MenuScreen implements Screen {
//
//    final MyGdxGame game;
//
//    OrthographicCamera camera;
//    Texture CreditsImg;
//    Texture SettingsImg;
//
//    public MenuScreen(final MyGdxGame game) {
//        this.game = game;
//        CreditsImg = new Texture("button1.png");
//        SettingsImg = new Texture("button1.png");
//        camera = new OrthographicCamera();
//        camera.setToOrtho(false, 800, 480);
//    }
//
//    //Screen interface does not provide any sort of create() method, so a constructor is used
//    @Override
//    public void render(float delta) {
//        ScreenUtils.clear(0, 0, 0, 1);
//
//        camera.update();
//        game.batch.setProjectionMatrix(camera.combined);
//
//        game.batch.begin();
//
//        //Writes text to screen using game.font.draw(SpriteBatch, String, float, float)
//        game.font.draw(game.batch, "Welcome to Heslington Hustle! ", 100, 150);
//        game.font.draw(game.batch, "Tap anywhere to begin!", 100, 100);
//
//        //Draws in Menu buttons
//        game.batch.setProjectionMatrix(camera.combined);
//        game.batch.draw(CreditsImg, 160, 100, 100, 55); //Uses bottom left as (0,0)
//        game.batch.draw(SettingsImg, 560, 100, 100, 55);
//        game.batch.end();
//
//        int mouseX = Gdx.input.getX(); //Uses top left as (0,0)
//        int mouseY = Gdx.input.getY();
//
//        // System.out.println("Mouse X: " + mouseX + ", Mouse Y: " + mouseY);
//        if (mouseX >= 140 && mouseX < 232) {
//            if (mouseY >= 325 && mouseY < 380) { //mouseY <= (480 - 160) && mouseY > (460 - 160 - 55) is just above the button?
//                if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
//                    System.out.println("Button pressed on the left");
//                    game.setScreen(new GameScreen(game));
//                    dispose();
//                }
//            }
//        }
//        if (mouseX >= 505 && mouseX < 595) {
//            if (mouseY >= 325 && mouseY < 380) {
//                if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
//                    System.out.println("Button pressed on the right");
//                    game.setScreen(new SettingsScreen(game));
//                    dispose();
//                }
//            }
//        }
//    }
//
//    @Override
//    public void resize(int width, int height) {
//    }
//    @Override
//    public void show() {
//    }
//
//    @Override
//    public void hide() {
//    }
//
//    @Override
//    public void pause() {
//    }
//
//    @Override
//    public void resume() {
//    }
//
//    @Override
//    public void dispose() {
//    }
//
//}
// import blog.gamedevelopment.box2dtutorial.Box2DTutorial;

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
        backgroundImage = new Texture(Gdx.files.internal("bg.png")); // Replace "bg.png" with the path to your background image

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


        Label titleLabel = new Label( "Credits", skin ,"black");
        table.add(titleLabel);
        table.row();

        // Names
        String[] names = {"William", "Seyi", "George", "Alex", "Ben", "Meg", "James","Raymond \"Raeleus\" Buckley for the Buttons"};
        for (String name : names) {
            Label nameLabel = new Label(name, skin, "default");
            table.add(nameLabel).colspan(2).center().padBottom(10);
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
                parent.toMainMenu();
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