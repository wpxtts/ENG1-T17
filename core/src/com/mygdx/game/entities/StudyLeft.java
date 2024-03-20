package com.mygdx.game.entities;

import com.mygdx.game.components.ComponentBoolean;
import com.mygdx.game.components.ComponentValue;

public class StudyLeft extends ValueTracker{

    public StudyLeft(int value,boolean crammed) {
        super(value,"StudyLeft");
        this.addComponent(new ComponentBoolean(crammed));
    }
}
