package com.mygdx.game.serviceProviders;

import com.mygdx.game.components.ComponentValue;
import com.mygdx.game.entities.Tracker;

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
    public void collisionEffect(Tracker energyTracker) {
        ComponentValue energy = (ComponentValue) energyTracker.getComponent(ComponentValue.class);
        System.out.println("Accommodation");
    }
}
