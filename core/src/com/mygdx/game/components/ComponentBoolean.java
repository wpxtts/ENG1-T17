package com.mygdx.game.components;

/**
 * A component which stores a true/false value
 */
public class ComponentBoolean extends Component {

    boolean value;

    public ComponentBoolean(boolean value) {
        this.value = value;
    }

    public boolean getTruth(){
        return this.value;
    }

    public void setTruth(boolean value){
        this.value = value;
    }
}