package com.mygdx.game.entities;

import com.mygdx.game.components.*;
import com.mygdx.game.serviceProviders.TextEffectProvider;

import java.util.HashMap;

public class Tracker extends Entity {
    public Tracker(int value) {
        this.components = new HashMap<>();
        this.addComponent(new ComponentValue(value));
    }
}
