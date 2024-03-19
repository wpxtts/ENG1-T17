package com.mygdx.game.entities;

import com.mygdx.game.components.ComponentTracker;

public class StudyScore extends Tracker {

    StudyScore(String text, float x, float y, float scale) {
        super(text, x, y, scale);
        this.addComponent(new ComponentTracker(100, 30));
    }
}
