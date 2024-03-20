package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

import com.mygdx.game.components.Component;
import com.mygdx.game.components.ComponentTime;
import com.mygdx.game.components.ComponentValue;
import com.mygdx.game.entities.*;
import com.mygdx.game.systems.*;

import java.util.ArrayList;
import java.util.HashMap;

public class GameScreen implements Screen {
    final MyGdxGame game;
    HashMap<String, Entity> entities;
    SystemUpdateInput updateInputSystem;
    SystemUpdateVelocityByInput updateVelocityByInputSystem;
    SystemUpdatePositionByVelocity updatePositionByVelocitySystem;
    SystemCollision collisionSystem;
    SystemRender renderSystem;
    SystemTime timeSystem;
    SystemText textSystem;

    SystemUpdateTrackerText updateTrackerTextSystem;


    public GameScreen(final MyGdxGame game) {
        this.game = game;
        entities = new HashMap<>();



        entities.put("Player",new Player());

        entities.put("Library",new Library(1.35, 1.4,0.4, 0.4));
        entities.put("DuckPond",new DuckPond(0.75,0.4, 0.35,0.25));
        entities.put("Accommodation",new Accommodation(0.5,1.2, 0.2,0.2,this));
        entities.put("Piazza",new Piazza(1.3,0.6, 0.2,0.4));


        entities.put("Map",new Map(0,0, 2, 2)); //currently the map's sprite size is 3000 x 1896

        entities.put("TimeTracker",new TimeTracker());

        entities.put("EnergyTracker",new ValueTracker(100,"Energy"));
        entities.put("StudyTracker", new ValueTracker(0,"Study"));
        entities.put("EatTracker", new ValueTracker(0,"Eat"));
        entities.put("FunTracker", new ValueTracker(0,"Fun"));
        entities.put("StudyLeftTracker", new StudyLeft(2,false));

        entities.put("EnergyText",new TrackerText("EnergyTracker",game.hudBatch,game.font,210,30,2));
        entities.put("StudyText",new TrackerText("StudyTracker",game.hudBatch,game.font,370,30,2));
        entities.put("EatText",new TrackerText("EatTracker",game.hudBatch,game.font,490,30,2));
        entities.put("FunText",new TrackerText("FunTracker",game.hudBatch,game.font,570,30,2));
        entities.put("TimeText",new TrackerText("TimeTracker",game.hudBatch,game.font,10,30,2));

        updateInputSystem = new SystemUpdateInput();
        updateVelocityByInputSystem = new SystemUpdateVelocityByInput();
        updatePositionByVelocitySystem = new SystemUpdatePositionByVelocity();
        collisionSystem = new SystemCollision();
        renderSystem = new SystemRender();
        timeSystem = new SystemTime();
        updateTrackerTextSystem = new SystemUpdateTrackerText();
        textSystem = new SystemText();

    }
    public void endGame(){
        System.out.println("End Game");
        Entity studyTracker = entities.get("StudyTracker");
        Entity eatTracker = entities.get("EatTracker");
        Entity funTracker = entities.get("FunTracker");
        ComponentValue study = (ComponentValue) studyTracker.getComponent(ComponentValue.class);
        ComponentValue eat = (ComponentValue) eatTracker.getComponent(ComponentValue.class);
        ComponentValue fun = (ComponentValue) funTracker.getComponent(ComponentValue.class);

        game.toScoreScreen(study.getValue(),fun.getValue(),eat.getValue());
    }

    @Override
    public void render(float delta) {
        // Turn the screen black.
        ScreenUtils.clear(0, 0, 0, 1);


        // Update all the systems every frame
        updateFrame();

    }



    @Override
    public void resize(int width, int height) {
        System.out.println(width);
        System.out.println(height);
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
        System.out.println("GameScreen dispose called");
        game.batch.dispose();
        game.font.dispose();
//        img.dispose();
        renderSystem.dispose(entities);
        game.shapeRenderer.dispose();
    }

    /**
     * Update each system.
     */
    void updateFrame() {
        updateInputSystem.update(entities);
        updateVelocityByInputSystem.update(entities);
        updatePositionByVelocitySystem.update(entities);
        collisionSystem.update(entities);
        game.batch.begin();
        renderSystem.update(entities, game.batch);
        game.batch.end();
        updateTrackerTextSystem.update(entities);
        game.hudBatch.begin();
        textSystem.update(entities);
        game.hudBatch.end();
        timeSystem.update(entities,this);
    }

}