package com.mygdx.game.entities;

import com.mygdx.game.components.ComponentBoolean;
import com.mygdx.game.components.ComponentValue;

public class StudyLeft extends Tracker{

    public StudyLeft(int value,boolean crammed) {
        super(value);
        this.addComponent(new ComponentBoolean(crammed));
    }
}
