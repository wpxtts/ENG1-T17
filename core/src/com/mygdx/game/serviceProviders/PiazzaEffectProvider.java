package com.mygdx.game.serviceProviders;

import com.mygdx.game.components.ComponentTime;
import com.mygdx.game.components.ComponentValue;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.entities.Tracker;

import java.util.HashMap;

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
    public void collisionEffect(HashMap<String, Entity> entities) {
        // Feeding the ducks takes 20 energy and 1 hour
        Entity energyTracker = entities.get("EnergyTracker");
        Entity eatTracker = entities.get("EatTracker");
        Entity timeTracker = entities.get("TimeTracker");
        ComponentValue energy = (ComponentValue) energyTracker.getComponent(ComponentValue.class);
        ComponentValue eat = (ComponentValue) eatTracker.getComponent(ComponentValue.class);
        ComponentTime time = (ComponentTime) timeTracker.getComponent(ComponentTime.class);

        if(energy.getValue()>=10 && time.getHour()<23){
            energy.setValue(energy.getValue()+10);
            time.setHour(time.getHour()+1);
            eat.setValue(eat.getValue()+1);
        }
    }
}
