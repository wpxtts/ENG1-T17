package com.mygdx.game.serviceProviders;

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
    public void collisionEffect() {
        System.out.println("Interacted with accommodation!");
    }
}
