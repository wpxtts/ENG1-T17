package com.mygdx.game.components;

public class ComponentSpecialEntityFlag extends Component{
    String name;
    // This component can be added to make an entity the player.
    public ComponentSpecialEntityFlag(String name) {
        this.name = name;
    }

    public String getFlag(){
        return name;
    }
}
