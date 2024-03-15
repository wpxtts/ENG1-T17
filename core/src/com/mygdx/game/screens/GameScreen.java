package com.mygdx.game.screens;

import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.entities.*;
import com.mygdx.game.systems.*;

import java.util.ArrayList;

/**
 * Main class of the game which manages the creation
 * of entities and systems, and then the execution of
 * the systems on those entities.
 */
public class GameScreen extends Screen {
    ArrayList<Entity> entities;
    SystemUpdateInput updateInputSystem;
    SystemUpdateVelocityByInput updateVelocityByInputSystem;
    SystemUpdatePositionByVelocity updatePositionByVelocitySystem;
    SystemCollision collisionSystem;
    SystemRender renderSystem;

    /**
     * Creates entities and systems.
     */

    public void create() {
        entities = new ArrayList<>();
        entities.add(new Player());

        entities.add(new Library(90, 300,50, 100));
        entities.add(new DuckPond(300,300, 100,100));

        updateInputSystem = new SystemUpdateInput();
        updateVelocityByInputSystem = new SystemUpdateVelocityByInput();
        updatePositionByVelocitySystem = new SystemUpdatePositionByVelocity();
        collisionSystem = new SystemCollision();
        renderSystem = new SystemRender();
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
        updateInputSystem.update(entities);
        updateVelocityByInputSystem.update(entities);
        updatePositionByVelocitySystem.update(entities);
        collisionSystem.update(entities);
        renderSystem.update(entities);

    }
}