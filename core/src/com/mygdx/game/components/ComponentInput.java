package com.mygdx.game.components;

import java.util.ArrayList;

public class ComponentInput extends Component{
    ArrayList<String> keysPressed;

    ComponentInput(){
        this.keysPressed = new ArrayList<>();
    }

    public ArrayList<String> getKeysPressed(){
        return keysPressed;
    }
    public void setKeysPressed(ArrayList<String> keysPressed){
        this.keysPressed = keysPressed;
    }
}
