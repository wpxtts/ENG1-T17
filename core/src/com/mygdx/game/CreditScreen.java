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
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class CreditScreen implements Screen{

    private Stage stage;
    MyGdxGame parent;

    public CreditScreen(MyGdxGame gameLoop){

        this.parent = gameLoop;
        /// create stage and set it as input processor
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
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

        //create buttons
        TextButton newGame = new TextButton("WE on the credit screen", skin);
        TextButton tutorial = new TextButton("Tutorial", skin);
        TextButton credits = new TextButton("Credits", skin);

        //add buttons to table
        table.add(newGame).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(tutorial).fillX().uniformX();
        table.row();
        table.add(credits).fillX().uniformX();

        // create button listeners
        credits.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Credits");
                parent.toCreditScreen();
            }
        });

        newGame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("New Game");
            }
        });

        tutorial.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Tutorial");
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
        // change the stage's viewport when teh screen size is changed
        stage.getViewport().update(width, height, true);
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