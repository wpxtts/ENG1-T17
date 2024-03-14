package com.mygdx.game.components;

public class ComponentSprite extends Component{

    // Shows there is a sprite to be rendered.
    // ADD SPRITE STUFF!!!!!!

    String sprite;
    public ComponentSprite() {}

    public ComponentSprite(String sprite) {

        this.sprite = sprite;
    }

    public boolean getInteractable(){
        return sprite;
    }
    public void setInteractable(boolean interactable){
        this.sprite=sprite;
    }
}
