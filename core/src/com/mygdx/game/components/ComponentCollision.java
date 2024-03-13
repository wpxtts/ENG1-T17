package com.mygdx.game.components;

public class ComponentCollision extends Component {

    // Can be added to make an object collidable with the player

    boolean interactable;

    public ComponentCollision(boolean interactable) {

        this.interactable = interactable;
    }

    public boolean getInteractable(){
        return interactable;
    }
    public void setInteractable(boolean interactable){
        this.interactable=interactable;
    }
}
