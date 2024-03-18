package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.components.*;
import com.mygdx.game.serviceProviders.CollisionEffectProvider;
import com.mygdx.game.serviceProviders.AccommodationEffectProvider;

import java.util.HashMap;

public class Accommodation extends POI{
    public Accommodation(double x, double y, double height, double width) {
        super(x,y,height,width);
        this.addComponent(new ComponentCollisionEffect(new AccommodationEffectProvider()));
        this.addComponent(new ComponentSprite(new Texture(Gdx.files.internal("accommodation.png"))));
    }
}