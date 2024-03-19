package com.mygdx.game.serviceProviders;

import com.mygdx.game.components.ComponentTime;
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
    }

}
