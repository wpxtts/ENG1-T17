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
        Entity studyLeftTracker = entities.get("StudyLeftTracker");
        ComponentValue energy = (ComponentValue) energyTracker.getComponent(ComponentValue.class);
        ComponentValue study = (ComponentValue) studyTracker.getComponent(ComponentValue.class);
        ComponentTime time = (ComponentTime) timeTracker.getComponent(ComponentTime.class);
        ComponentValue studyLeft = (ComponentValue) studyLeftTracker.getComponent(ComponentValue.class);


        if(energy.getValue()>=40 && time.getHour()<20 && studyLeft.getValue()>0){
            energy.setValue(energy.getValue()-40);
            time.setHour(time.getHour()+4);
            study.setValue(study.getValue()+1);
            studyLeft.setValue(studyLeft.getValue()-1);
        }
    }
}
