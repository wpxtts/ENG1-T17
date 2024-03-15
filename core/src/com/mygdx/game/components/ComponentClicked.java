package com.mygdx.game.components;

public class ComponentClicked extends Component{

    // Can be added to make an object collidable with the player

    boolean clicked;

    public ComponentClicked() {
        this.clicked = false;
    }

    public boolean getClicked(){
        return clicked;
    }
    public void setClicked(boolean clicked){
        this.clicked=clicked;
    }
}
