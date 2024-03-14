package com.mygdx.game.entities;

import com.mygdx.game.components.ComponentCollision;
import com.mygdx.game.components.ComponentPosition;
import com.mygdx.game.components.ComponentSprite;

import java.util.HashMap;

public class Block extends Entity{
    public Block(int x, int y, int height, int width, boolean interactable) {
        this.components = new HashMap<>();
        this.addComponent(new ComponentPosition(x, y, height, width));
        this.addComponent(new ComponentCollision(interactable));
        this.addComponent(new ComponentSprite());
    }
}