package com.mygdx.game.entities;

import com.mygdx.game.components.*;
import com.mygdx.game.serviceProviders.TextEffectProvider;

import java.util.HashMap;

/**
 * ValueTracker is an entity representing values being tracked.
 */

public class ValueTracker extends Tracker {

    /**
     * Constructs a StudyLeft entity with the specified name and value.
     * @param value The value being tracked by this entity.
     * @param name The name of the value.
     */
    public ValueTracker(int value,String name) {
        this.components = new HashMap<>();
        this.addComponent(new ComponentValue(value,name));
    }
}
