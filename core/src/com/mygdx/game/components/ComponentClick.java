package com.mygdx.game.components;

import com.mygdx.game.serviceProviders.ClickEffectProvider;

public class ComponentClick extends Component{

    // Can be added to make an object collidable with the player

    boolean clicked;

    ClickEffectProvider clickEffect;

    public ComponentClick(ClickEffectProvider clickEffect) {
        this.clicked = false;
        this.clickEffect = clickEffect;
    }

    public boolean getClicked(){
        return clicked;
    }
    public void setClicked(boolean clicked){
        this.clicked=clicked;
    }

    public ClickEffectProvider getClickEffect(){
        return clickEffect;
    }
}
