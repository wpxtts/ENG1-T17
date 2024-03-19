package com.mygdx.game.systems;

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

    /**
     * Constructs a SystemTime object and initializes the starting in-game time.
     * In this implementation, the starting time is set to 8:00 AM.
     */
    public SystemTime() {
        // Set elapsedRealTime to 8:00 AM at the start of the game
        int startHour = 8;
        elapsedRealTime = startHour * realSecondsPerInGameHour;
    }

    /**
     * Updates the in-game time based on the elapsed real time.
     * @param delta The time passed since the last update in seconds
     */
    public void update(float delta) {
        // Increment the elapsed real time
        elapsedRealTime += delta;

        // Check if an "hour" has passed
        if (elapsedRealTime >= realSecondsPerInGameHour) {
            // Reset elapsed time for the next "hour"
            elapsedRealTime -= realSecondsPerInGameHour;

            hour++; // Increment hour
        }
    }

    /**
     * Retrieves the current in-game hour.
     * @return The current in-game hour
     */
    public int getCurrentHour() {
        // Return the updated hour
        return hour;
    }

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
}
