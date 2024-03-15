package com.mygdx.game.entities;

import com.mygdx.game.components.*;
import com.mygdx.game.serviceProviders.CollisionEffectProvider;
import com.mygdx.game.serviceProviders.DuckPondEffectProvider;
import com.mygdx.game.serviceProviders.LibraryEffectProvider;

import java.util.HashMap;

public class DuckPond extends POI{
    public DuckPond(int x, int y, int height, int width) {
        super(x,y,height,width);
        this.addComponent(new ComponentCollisionEffect(new DuckPondEffectProvider()));
    }
}