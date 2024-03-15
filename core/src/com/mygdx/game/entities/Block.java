package com.mygdx.game.entities;

import com.mygdx.game.components.*;
import com.mygdx.game.serviceProviders.ClickEffectProvider;
import com.mygdx.game.serviceProviders.CollisionEffectProvider;

import java.util.HashMap;

public class Block extends Entity{
    public Block(int x, int y, int height, int width, boolean interactable) {
        this.components = new HashMap<>();
        this.addComponent(new ComponentPosition(x, y, height, width));
        this.addComponent(new ComponentSprite());
        this.addComponent(new ComponentClick(new ClickEffectProvider()));
    }
}