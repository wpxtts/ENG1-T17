package com.mygdx.game.serviceProviders;

import com.mygdx.game.components.ComponentValue;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.entities.Tracker;

import java.util.HashMap;

/**
 * AccommodationEffectProvider provides collision effects specific to accommodation entities.
 */
public class AccommodationEffectProvider extends CollisionEffectProvider {

    /**
     * Constructs an AccommodationEffectProvider.
     */
    public AccommodationEffectProvider() {}

    /**
     * Provides the collision effect for accommodation entities.
     */
    public void collisionEffect(HashMap<String, Entity> entities) {
        Entity energyTracker = entities.get("EnergyTracker");
        Entity studyLeftTracker = entities.get("StudyLeftTracker");
        ComponentValue energy = (ComponentValue) energyTracker.getComponent(ComponentValue.class);
        energy.setValue(100);
        ChangeDay.changeDay(entities);
    }
}
