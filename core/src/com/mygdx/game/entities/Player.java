package com.mygdx.game.entities;

import com.mygdx.game.components.*;
import com.mygdx.game.entities.Entity;

import java.util.HashMap;

public class Player extends Entity {
    public Player() {
        this.components = new HashMap<>();
        this.addComponent(new ComponentPosition(100, 100, 100, 100));
        this.addComponent(new ComponentPlayerFlag());
        this.addComponent(new ComponentSprite());
        this.addComponent(new ComponentInput());
        this.addComponent(new ComponentVelocity());
    }
}