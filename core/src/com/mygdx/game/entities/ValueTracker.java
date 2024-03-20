package com.mygdx.game.entities;

import com.mygdx.game.components.*;
import com.mygdx.game.serviceProviders.TextEffectProvider;

import java.util.HashMap;

public class ValueTracker extends Tracker {
    public ValueTracker(int value,String name) {
        this.components = new HashMap<>();
        this.addComponent(new ComponentValue(value,name));
    }
}
