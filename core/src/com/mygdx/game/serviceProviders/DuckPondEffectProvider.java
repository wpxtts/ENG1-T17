package com.mygdx.game.serviceProviders;

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
    public void collisionEffect() {
        System.out.println("Interacted with duck pond!");
    }
}
