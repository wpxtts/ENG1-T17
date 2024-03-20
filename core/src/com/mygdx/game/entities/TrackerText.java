package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.components.Component;
import com.mygdx.game.components.ComponentText;
import com.mygdx.game.components.ComponentTrackerPointer;
import com.mygdx.game.components.ComponentValue;
import com.mygdx.game.serviceProviders.TextEffectProvider;

import java.util.HashMap;

/**
 * TrackerText is an entity representing the text displaying a tracker
 */

public class TrackerText extends Entity {

    /**
     * Constructs a TrackerText entity which hvrusdihbxhvbsFUEHWDVBFEJCBDUFBRJ.
     * @param targetTracker The name of the value being displayed by this entity.
     * @param batch The sprite batch which will draw the text.
     * @param font The font used to write the text.
     * @param x The x coordinate where the text will be written.
     * @param y The y coordinate where the text will be written.
     * @param scale Variable determining the size of the text.
     */
    public TrackerText(String targetTracker, SpriteBatch batch, BitmapFont font, float x, float y, float scale) {
        this.components = new HashMap<>();
        this.addComponent(new ComponentTrackerPointer(targetTracker));
        this.addComponent(new ComponentText(new TextEffectProvider(batch,font),"",x,y,scale));
    }
}
