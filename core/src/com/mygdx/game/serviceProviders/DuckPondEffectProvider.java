package com.mygdx.game.serviceProviders;

import com.mygdx.game.components.ComponentTime;
import com.mygdx.game.components.ComponentValue;
import com.mygdx.game.entities.Tracker;
import com.mygdx.game.entities.*;

import java.util.HashMap;

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
    public void collisionEffect(HashMap<String,Entity> entities) {
        // Feeding the ducks takes 20 energy and 1 hour
        Entity energyTracker = entities.get("EnergyTracker");
        Entity funTracker = entities.get("FunTracker");
        Entity timeTracker = entities.get("TimeTracker");
        ComponentValue energy = (ComponentValue) energyTracker.getComponent(ComponentValue.class);
        ComponentValue fun = (ComponentValue) funTracker.getComponent(ComponentValue.class);
        ComponentTime time = (ComponentTime) timeTracker.getComponent(ComponentTime.class);

        if(energy.getValue()>=20 && time.getHour()<23){
            energy.setValue(energy.getValue()-20);
            time.setHour(time.getHour()+1);
            fun.setValue(fun.getValue()+1);
            System.out.println("Interacted with duck pond!");
        }
    }
}
