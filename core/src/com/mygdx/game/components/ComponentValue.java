package com.mygdx.game.components;

public class ComponentValue extends Component {

    int value;

    public ComponentValue(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public void setValue(int value){
        this.value = value;
    }
}
