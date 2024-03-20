package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.components.*;

import java.util.HashMap;

public class TimeTracker extends Tracker{
    public TimeTracker() {
        this.components = new HashMap<>();
        this.addComponent(new ComponentTime());
    }
}
