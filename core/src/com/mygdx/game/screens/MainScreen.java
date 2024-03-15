package com.mygdx.game.screens;

import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.entities.*;

import java.util.ArrayList;

/**
 * Main class of the game which manages the creation
 * of entities and systems, and then the execution of
 * the systems on those entities.
 */
public class MainScreen extends Screen {
    ArrayList<Entity> entities;

    /**
     * Creates entities and systems.
     */
    public void create() {
        entities = new ArrayList<>();
    }

    /**
     * Clear screen and then update all systems.
     * This is called every frame.
     */
    public void render() {

        // Turn the screen black.
        ScreenUtils.clear(0, 0, 0, 1);

        // updates all the systems every frame
        UpdateFrame();

    }

    /**
     * Update each system.
     */
    void UpdateFrame() {

    }
}
