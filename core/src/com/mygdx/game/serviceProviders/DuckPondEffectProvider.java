package com.mygdx.game.serviceProviders;

import com.mygdx.game.components.ComponentValue;
import com.mygdx.game.entities.Tracker;

/**
 * DuckPondEffectProvider provides collision effects specific to duck pond entities.
 */
public class DuckPondEffectProvider extends CollisionEffectProvider {

    /**
     * Constructs a DuckPondEffectProvider.
     */
    public DuckPondEffectProvider() {}

    /**
     * Provides the collision effect for duck pond entities.
     */
    public void collisionEffect(Tracker energyTracker) {
        ComponentValue energy = (ComponentValue) energyTracker.getComponent(ComponentValue.class);
        if(energy.getValue()>20){
            energy.setValue(energy.getValue()-20);
            System.out.println("Interacted with duck pond!");
        }
    }
}
