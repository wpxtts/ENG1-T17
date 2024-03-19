package com.mygdx.game.serviceProviders;

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
    public void collisionEffect() {
        System.out.println("Interacted with Piazza!");
    }
}
