package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.components.Component;
import com.mygdx.game.components.ComponentText;
import com.mygdx.game.components.ComponentTrackerPointer;
import com.mygdx.game.components.ComponentValue;
import com.mygdx.game.serviceProviders.TextEffectProvider;

import java.util.HashMap;

public class TrackerText extends Entity {
    public TrackerText(String targetTracker, SpriteBatch batch, BitmapFont font, float x, float y, float scale) {
        this.components = new HashMap<>();
        this.addComponent(new ComponentTrackerPointer(targetTracker));
        this.addComponent(new ComponentText(new TextEffectProvider(batch,font),"",x,y,scale));
    }
}
