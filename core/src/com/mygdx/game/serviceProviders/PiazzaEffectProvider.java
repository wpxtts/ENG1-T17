package com.mygdx.game.serviceProviders;

import com.mygdx.game.components.ComponentValue;
import com.mygdx.game.entities.Tracker;

/**
 * PiazzaEffectProvider provides collision effects specific to piazza entities.
 */
public class PiazzaEffectProvider extends CollisionEffectProvider {

    /**
     * Constructs a PiazzaEffectProvider.
     */
    public PiazzaEffectProvider() {}

    /**
     * Provides the collision effect for piazza entities.
     */
    public void collisionEffect(Tracker energyTracker) {
        ComponentValue energy = (ComponentValue) energyTracker.getComponent(ComponentValue.class);
        if(energy.getValue()>20){
            energy.setValue(energy.getValue()-20);
            System.out.println("Interacted with piazza!");
        }
    }
}
