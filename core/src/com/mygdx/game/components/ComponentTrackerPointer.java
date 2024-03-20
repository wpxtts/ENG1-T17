package com.mygdx.game.components;

/**
 * Stores a pointer to a tracker
 */
public class ComponentTrackerPointer extends Component{
    String trackerPointer;
    public ComponentTrackerPointer(String trackerPointer){
        this.trackerPointer = trackerPointer;
    }

    public String getTrackerPointer(){
        return trackerPointer;
    }
}
