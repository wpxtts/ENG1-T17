package com.mygdx.game.serviceProviders;

import com.mygdx.game.components.ComponentTime;
import com.mygdx.game.components.ComponentValue;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.entities.Tracker;

import java.util.HashMap;

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
    public void collisionEffect(HashMap<String, Entity> entities) {
        // Feeding the ducks takes 20 energy and 1 hour
        Entity energyTracker = entities.get("EnergyTracker");
        Entity studyTracker = entities.get("StudyTracker");
        Entity timeTracker = entities.get("TimeTracker");
        ComponentValue energy = (ComponentValue) energyTracker.getComponent(ComponentValue.class);
        ComponentValue study = (ComponentValue) studyTracker.getComponent(ComponentValue.class);
        ComponentTime time = (ComponentTime) timeTracker.getComponent(ComponentTime.class);

        if(energy.getValue()>=40 && time.getHour()<20){
            energy.setValue(energy.getValue()-40);
            time.setHour(time.getHour()+4);
            study.setValue(study.getValue()+1);
            System.out.println("Interacted with duck pond!");
        }
    }
}
