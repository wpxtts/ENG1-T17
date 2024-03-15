package com.mygdx.game.entities;

import com.mygdx.game.components.*;
import com.mygdx.game.serviceProviders.CollisionEffectProvider;

import java.util.HashMap;

public class POI extends Entity{
    public POI(int x, int y, int height, int width) {
        this.components = new HashMap<>();
        this.addComponent(new ComponentPosition(x, y, height, width));
        this.addComponent(new ComponentCollision(true));
        this.addComponent(new ComponentSprite());
//        this.addComponent(new ComponentCollisionEffect(new CollisionEffectProvider()));
        this.addComponent(new ComponentInput());
    }
}