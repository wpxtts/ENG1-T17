package com.mygdx.game.components;


/**
 * ComponentCollision represents a collision component that can be added to make an object collidable with the player.
 */
public class ComponentCollision extends Component {

    // Indicates whether the object is interactable with the player
    boolean interactable;

    /**
     * Constructs a ComponentCollision with the specified interactable status.
     * @param interactable true if the object is interactable with the player, false otherwise
     */
    public ComponentCollision(boolean interactable) {

        this.interactable = interactable;
    }

    /**
     * Retrieves the interactable status of the object.
     * @return true if the object is interactable with the player, false otherwise
     */
    public boolean getInteractable(){
        return interactable;
    }

    /**
     * Sets the interactable status of the object.
     * @param interactable true if the object is interactable with the player, false otherwise
     */
    public void setInteractable(boolean interactable){
        this.interactable=interactable;
    }
}
