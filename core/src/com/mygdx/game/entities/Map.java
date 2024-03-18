package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.components.*;

import java.util.HashMap;

public class Map extends Entity{
    public Map(int x, int y, int height, int width) {
        this.addComponent(new ComponentPosition(x,y,height,width));
        this.addComponent(new ComponentSpecialEntityFlag("Map"));
        this.addComponent(new ComponentSprite(new Texture(Gdx.files.internal("map.png"))));
    }
}