package com.mygdx.game.serviceProviders;

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
    public void collisionEffect() {
        System.out.println("Interacted with library!");
    }
}
