package com.mygdx.game;

import java.util.HashMap;

public class Block extends Entity{
    Block(int x, int y, int height, int width, boolean interactable) {
        this.components = new HashMap<>();
        this.addComponent(new ComponentPosition(x, y, height, width));
        this.addComponent(new ComponentCollision(interactable));
        this.addComponent(new ComponentSprite());
    }
}