package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.components.*;

import java.util.HashMap;

public class Map extends POI{
    public Map(int x, int y, int height, int width) {
        super(x,y,height,width);
        //this.addComponent(new ComponentCollisionEffect(new PiazzaEffectProvider()));
        this.addComponent(new ComponentSprite(new Texture(Gdx.files.internal("map.png"))));
    }
}