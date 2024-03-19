package com.mygdx.game.systems;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.GameScreen;
import com.mygdx.game.components.ComponentTime;
import com.mygdx.game.components.ComponentValue;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.serviceProviders.ChangeDay;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * SystemTime class manages the in-game time simulation.
 */
public class SystemTime {
    // Value representing the real time equivalent of one in-game hour
    private static final float realSecondsPerInGameMinute = 0.25f;

    // Tracks the elapsed real time
    private static final int wakeUpHour = 8;


    /**
     * Constructs a SystemTime object and initializes the starting in-game time.
     * In this implementation, the starting time is set to 8:00 AM.
     */
    public SystemTime() {

    }


    /**
     * Manages all time based updates, including updating the in game time and
     * adjusting the trackers.
     */
    public void update(HashMap<String, Entity> entities, GameScreen gameScreen) {

        // Acquire all entities with the tracker component
        ArrayList<Entity> timeObjects = new ArrayList<>();

        for (Entity entity : entities.values()) {
            if (entity.hasComponent(ComponentTime.class)) {
                ComponentTime time = (ComponentTime) entity.getComponent(ComponentTime.class);
                time.setLastUpdated(time.getLastUpdated()+Gdx.graphics.getDeltaTime());
                if(time.getLastUpdated()>realSecondsPerInGameMinute){
                    time.setLastUpdated(0);
                    time.setMinute(time.getMinute()+1);
                    if(time.getMinute()>=60){
                        time.setHour(time.getHour()+1);
                        time.setMinute(0);
                        if(time.getHour()>=24){
                            Entity energyTracker = entities.get("EnergyTracker");
                            ComponentValue energy = (ComponentValue) energyTracker.getComponent(ComponentValue.class);
                            energy.setValue(60);
                            ChangeDay.changeDay(entities, gameScreen);
                        }
                    }
                }
            }
        }

//        // Increment the elapsed real time
//        // Delta time is the time elapsed since the last frame
//        float delta = Gdx.graphics.getDeltaTime();
//        elapsedRealTime += delta;
//
//        // Check if an "hour" has passed
//        if (elapsedRealTime >= realSecondsPerInGameHour) {
//            // Reset elapsed time for the next "hour"
//            elapsedRealTime -= realSecondsPerInGameHour;
//
//            hour++; // Increment hour
//
//            // Check if a day has passed and increment day
//            if (hour == 24) {
//                hour = 0;
//                day++;
//            }
//        }
    }

    /**
     * Calculates the current in-game minute.
     * @return The current in-game minute
     */
//    public int getCurrentMinute() {
//        // Calculate the current minute based on elapsed real time
//        float remainder = elapsedRealTime % realSecondsPerInGameHour;
//        float minute = remainder / realSecondsPerInGameHour * 60;
//        return (int) minute;
//    }
//
//    public String getTimeString() {
////        // Calculate current minute
////        int minute = getCurrentMinute();
//
//        // Write and return the digital clock string
//        return String.format("Day %2d - %02d:%02d", day, hour, minute);
//    }
}
