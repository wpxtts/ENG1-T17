package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.components.*;
import com.mygdx.game.serviceProviders.CollisionEffectProvider;
import com.mygdx.game.serviceProviders.LibraryEffectProvider;

import java.util.HashMap;

public class Library extends POI{
    public Library(int x, int y, int height, int width) {
        super(x,y,height,width);
        this.addComponent(new ComponentCollisionEffect(new LibraryEffectProvider()));
        this.addComponent(new ComponentSprite(new Texture(Gdx.files.internal("library.png"))));
    }
}