package com.mygdx.game.components;

public class ComponentValue extends Component {

    int value;
    String name;
    public ComponentValue(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue(){
        return this.value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public String getString(){
        return name+":"+Integer.toString(value);
    }
}
