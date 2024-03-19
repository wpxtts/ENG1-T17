package com.mygdx.game.components;

/**
 * ComponentSpecialEntityFlag represents a component that flags an entity as special.
 * This component can be added to make an entity the player.
 */
public class ComponentSpecialEntityFlag extends Component {

    // The name associated with the flag
    private String name;

    /**
     * Constructs a ComponentSpecialEntityFlag with the specified name.
     * @param name The name associated with the flag
     */
    public ComponentSpecialEntityFlag(String name) {
        this.name = name;
    }

    /**
     * Retrieves the name associated with the flag.
     * @return The flag's name
     */
    public String getFlag() {
        return name;
    }
}
