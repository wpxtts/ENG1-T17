package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.components.*;

import java.util.HashMap;

/**
 * TimeTracker is an entity representing the current time.
 */

public class TimeTracker extends Tracker{

    // Constructs an entity with a component tracking days, hours and minutes.
    public TimeTracker() {
        this.components = new HashMap<>();
        this.addComponent(new ComponentTime());
    }
}
