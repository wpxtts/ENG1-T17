package com.mygdx.game.components;

public class ComponentSprite extends Component{

    // Shows there is a sprite to be rendered.
    // ADD SPRITE STUFF!!!!!!

    String sprite;
    public ComponentSprite() {}

    public ComponentSprite(String sprite) {

        this.sprite = sprite;
    }

    public String getSprite(){
        return sprite;
    }
    public void setSprite(String sprite){
        this.sprite=sprite;
    }
}
