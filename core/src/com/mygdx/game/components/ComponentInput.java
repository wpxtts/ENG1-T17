package com.mygdx.game.components;

import java.util.ArrayList;

/**
 * ComponentInput represents a component that handles input for an object.
 */
public class ComponentInput extends Component {

    // List of keys pressed
    private ArrayList<String> keysPressed;

    /**
     * Constructs a ComponentInput with an empty list of keys pressed.
     */
    public ComponentInput() {
        this.keysPressed = new ArrayList<>();
    }

    /**
     * Retrieves the list of keys pressed.
     * @return The list of keys pressed
     */
    public ArrayList<String> getKeysPressed() {
        return keysPressed;
    }

    /**
     * Sets the list of keys pressed.
     * @param keysPressed The list of keys pressed
     */
    public void setKeysPressed(ArrayList<String> keysPressed) {
        this.keysPressed = keysPressed;
    }
}
