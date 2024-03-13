package com.mygdx.game;

public class ComponentCollision extends Component {

    // Can be added to make an object collidable with the player

    boolean interactable;

    ComponentCollision(boolean interactable) {

        this.interactable = interactable;
    }

}
