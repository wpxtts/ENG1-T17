package com.mygdx.game.systems;

import com.badlogic.gdx.Gdx;

public class SystemTime {
    private static final float realSecondsPerInGameHour = 8.57f; //value based on 2-minute days, 10 minutes total game play
    private float elapsedRealTime; // Tracks the elapsed real time

    private int hour;
    int day;

    public SystemTime() {
        // Set elapsedRealTime to 8am at the start of the game
        int startHour = 23;
        elapsedRealTime = startHour * realSecondsPerInGameHour;
        day = 1;
    }

    public void update() {
        // Increment the elapsed real time

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
