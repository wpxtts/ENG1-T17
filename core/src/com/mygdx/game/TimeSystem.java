package com.mygdx.game;

public class TimeSystem {
    private static final float realSecondsPerInGameHour = 8.57f; //value based on 2-minute days, 10 minutes total game play
    private float elapsedRealTime; // Tracks the elapsed real time

    private int hour;

    public TimeSystem() {
        // Set elapsedRealTime to 8am at the start of the game
        int startHour = 8;
        elapsedRealTime = startHour * realSecondsPerInGameHour;
    }

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

    public int getCurrentHour() {
        // Return the updated hour
        return hour;
    }

    public int getCurrentMinute() {
        // Calculate the current minute based on elapsed real time
        float remainder = elapsedRealTime % realSecondsPerInGameHour;
        float minute = remainder / realSecondsPerInGameHour * 60;
        return (int) minute;
    }
}
