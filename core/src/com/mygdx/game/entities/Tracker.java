package com.mygdx.game.entities;

import com.mygdx.game.components.*;
import com.mygdx.game.serviceProviders.TextEffectProvider;

import java.util.HashMap;

public class Tracker extends Entity {
    public Tracker(String text, float x, float y, float scale) {
        this.components = new HashMap<>();
        this.addComponent(new ComponentText(new TextEffectProvider(),text, x, y, scale));
    }
}
