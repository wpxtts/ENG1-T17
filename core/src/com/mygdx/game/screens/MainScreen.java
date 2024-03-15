package com.mygdx.game.screens;

import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.entities.*;
import com.mygdx.game.systems.SystemCheckClicks;
import com.mygdx.game.systems.SystemRender;

import java.util.ArrayList;

/**
 * Main class of the game which manages the creation
 * of entities and systems, and then the execution of
 * the systems on those entities.
 */
public class MainScreen extends Screen {
    ArrayList<Entity> entities;
    SystemRender renderSystem;
    SystemCheckClicks clickedSystem;
    /**
     * Creates entities and systems.
     */
    public void create() {
        entities = new ArrayList<>();
        entities.add(new Block(100,100,100,100,false));
        renderSystem = new SystemRender();
        clickedSystem = new SystemCheckClicks();
    }

    /**
     * Clear screen and then update all systems.
     * This is called every frame.
     */
    public void render() {

        // Turn the screen black.
        ScreenUtils.clear(0, 0, 0, 1);
        renderSystem.update(entities);
//        // updates all the systems every frame
//        Screen newScreen = UpdateFrame();
//        return newScreen;

    }

    /**
     * Update each system.
     */
    public Screen updateFrame() {
        Screen newScreen = clickedSystem.update(entities);
        return newScreen;
    }

    void toGame(){

    }
}
