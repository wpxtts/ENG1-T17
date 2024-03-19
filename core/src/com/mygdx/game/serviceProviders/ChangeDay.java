package com.mygdx.game.serviceProviders;

import com.mygdx.game.components.ComponentBoolean;
import com.mygdx.game.components.ComponentTime;
import com.mygdx.game.components.ComponentValue;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.entities.TimeTracker;

import java.util.HashMap;

public class ChangeDay{
    ChangeDay() {};

    public static void changeDay(HashMap<String, Entity>entities){
        TimeTracker timeTracker = (TimeTracker) entities.get("TimeTracker");
        ComponentTime time = (ComponentTime) timeTracker.getComponent(ComponentTime.class);
        time.setDay(time.getDay()+1);
        time.setHour(8);
        time.setMinute(0);

        Entity studyLeftTracker = entities.get("StudyLeftTracker");
        ComponentValue studyLeftValue = (ComponentValue) studyLeftTracker.getComponent(ComponentValue.class);
        ComponentBoolean crammed = (ComponentBoolean) studyLeftTracker.getComponent(ComponentBoolean.class);
        if(studyLeftValue.getValue()==0){
            crammed.setTruth(true);
        }
        if(crammed.getTruth()){
            studyLeftValue.setValue(1);
        }else{
            studyLeftValue.setValue(2);
        }
    }

}
