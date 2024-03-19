package com.mygdx.game.systems;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.entities.Entity;

import java.util.ArrayList;

/**
 * SystemTime class manages the in-game time simulation.
 */
public class SystemTime {
    // Value representing the real time equivalent of one in-game hour
    private static final float realSecondsPerInGameHour = 8.57f;

    // Tracks the elapsed real time
    private float elapsedRealTime;

    // Tracks the current in-game hour
    private int hour;
    int day;

    /**
     * Constructs a SystemTime object and initializes the starting in-game time.
     * In this implementation, the starting time is set to 8:00 AM.
     */
    public SystemTime() {

        // Set elapsedRealTime to 8:00 AM at the start of the game
        int startHour = 8;
        elapsedRealTime = startHour * realSecondsPerInGameHour;
        day = 1;
    }


    /**
     * Manages all time based updates, including updating the in game time and
     * adjusting the trackers.
     */
    public void update(ArrayList<Entity> entities) {

        // Acquire all entities with the tracker component
        ArrayList<Entity> trackerObjects = new ArrayList<>();

        /*for (Entity entity : entities) {
            if (entity.hasComponent(ComponentTracker.class)) {
                trackerObjects.add(entity);
            }
        }*/

        // Increment the elapsed real time
        // Delta time is the time elapsed since the last frame
        float delta = Gdx.graphics.getDeltaTime();
        elapsedRealTime += delta;

        // Check if an "hour" has passed
        if (elapsedRealTime >= realSecondsPerInGameHour) {
            // Reset elapsed time for the next "hour"
            elapsedRealTime -= realSecondsPerInGameHour;

            hour++; // Increment hour

            // Check if a day has passed and increment day
            if (hour == 24) {
                hour = 0;
                day++;
            }
        }
    }

    /**
     * Calculates the current in-game minute.
     * @return The current in-game minute
     */
    public int getCurrentMinute() {
        // Calculate the current minute based on elapsed real time
        float remainder = elapsedRealTime % realSecondsPerInGameHour;
        float minute = remainder / realSecondsPerInGameHour * 60;
        return (int) minute;
    }

    public String getTimeString() {
        // Calculate current minute
        int minute = getCurrentMinute();

        // Write and return the digital clock string
        return String.format("Day %2d - %02d:%02d", day, hour, minute);
    }
}
