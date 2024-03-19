package com.mygdx.game.components;

public class ComponentTracker extends Component {

    int value;
    // Number of minutes for the value to decrement
    int rate;

    public ComponentTracker(int value, int rate) {
        this.value = value;
        this.rate = rate;
    }

}
