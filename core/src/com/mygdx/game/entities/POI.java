package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.components.*;
import com.mygdx.game.serviceProviders.CollisionEffectProvider;

import java.util.HashMap;

public class POI extends Entity{
    public POI(double x, double y, double height, double width) {
        this.components = new HashMap<>();
        this.addComponent(new ComponentPosition(x, y, height, width));
        this.addComponent(new ComponentCollision(true));
        this.addComponent(new ComponentSprite(new Texture(Gdx.files.internal("poi.jpg"))));
//        this.addComponent(new ComponentCollisionEffect(new CollisionEffectProvider()));
        this.addComponent(new ComponentInput());
    }
}