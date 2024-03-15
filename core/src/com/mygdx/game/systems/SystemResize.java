package com.mygdx.game.systems;

import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.entities.Entity;

import java.util.ArrayList;

public class SystemResize {

    public SystemResize(){}

    /**
     * Resize entities when window is changes.
     * @param entities all entities
     */
    public void refit(int width, int height, SystemRender extendViewport) {
        extendViewport.update(width, height);
    }
}
