package com.mygdx.game.serviceProviders;

import com.mygdx.game.entities.Entity;
import com.mygdx.game.entities.Tracker;

import java.util.Random;

/**
 * CollisionEffectProvider provides generic collision effects.
 */
public class CollisionEffectProvider {

    /**
     * Constructs a CollisionEffectProvider.
     */
    public CollisionEffectProvider() {}

    /**
     * Provides a generic collision effect.
     * This implementation generates a random integer between 0 and 99 and prints it.
     */
    public void collisionEffect(Tracker energyTracker) {
        Random rand = new Random();
        System.out.println(rand.nextInt(100));
    }
}
