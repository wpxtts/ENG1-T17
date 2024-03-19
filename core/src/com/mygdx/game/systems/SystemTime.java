package com.mygdx.game.systems;

import com.badlogic.gdx.Gdx;

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
     * Updates the in-game time based on the elapsed real time.
     */
    public void update() {
        // Increment the elapsed real time
        // Delta time is the time elapsed since the last frame
        float delta = Gdx.graphics.getDeltaTime();
        elapsedRealTime += delta;

        // Check if an "hour" has passed
        if (elapsedRealTime >= realSecondsPerInGameHour) {
            // Reset elapsed time for the next "hour"
            elapsedRealTime -= realSecondsPerInGameHour;

            hour++; // Increment hour

            if (hour == 24) {
                hour = 0;
                day++;
            }
        }
    }

    public int getDay() {return day;}

    public int getHour() {return hour;}

    /**
     * Retrieves the current in-game minute.
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

        // Draw the digital clock
        return String.format("Day %2d - %02d:%02d", day, hour, minute);
    }
}
