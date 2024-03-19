package com.mygdx.game.serviceProviders;

import com.mygdx.game.components.ComponentValue;
import com.mygdx.game.entities.Tracker;

/**
 * LibraryEffectProvider provides collision effects specific to library entities.
 */
public class LibraryEffectProvider extends CollisionEffectProvider {

    /**
     * Constructs a LibraryEffectProvider.
     */
    public LibraryEffectProvider() {}

    /**
     * Provides the collision effect for library entities.
     */
    public void collisionEffect(Tracker energyTracker) {
        ComponentValue energy = (ComponentValue) energyTracker.getComponent(ComponentValue.class);
        if(energy.getValue()>20){
            energy.setValue(energy.getValue()-20);
            System.out.println("Interacted with Library!");
        }
    }
}
