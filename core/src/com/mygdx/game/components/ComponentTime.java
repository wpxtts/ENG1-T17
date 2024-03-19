package com.mygdx.game.components;

public class ComponentTime extends Component{
    int day;
    int hour;
    int minute;
    float lastUpdated;
    public ComponentTime(){
        day = 1;
        hour = 8;
        minute = 0;
        lastUpdated = 0;
    }

    public int getDay(){
        return day;
    }
    public void setDay(int day){
        this.day = day;
    }

    public int getHour(){
        return hour;
    }
    public void setHour(int hour){
        this.hour=hour;
    }

    public int getMinute(){
        return minute;
    }
    public void setMinute(int minute){
        this.minute = minute;
    }

    public float getLastUpdated(){
        return lastUpdated;
    }
    public void setLastUpdated(float lastUpdated){
        this.lastUpdated = lastUpdated;
    }

    public String getTimeString(){
        return String.format("Day %2d - %02d:%02d", day, hour, minute);
    }
}
