package com.mygdx.game.components;

public class ComponentSprite extends Component{

    // Shows there is a sprite to be rendered.
    // ADD SPRITE STUFF!!!!!!

    Texture sprite;
    public ComponentSprite() {}

    public ComponentSprite(Texture sprite) {

        this.sprite = sprite;
    }

    public Texture getSprite(){
        return sprite;
    }
    public void setSprite(Texture sprite){
        this.sprite=sprite;
    }
}
