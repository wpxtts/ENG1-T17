package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.components.*;
import com.mygdx.game.entities.Entity;

import java.util.HashMap;

public class Player extends Entity {
    public Player() {
        this.components = new HashMap<>();
        this.addComponent(new ComponentPosition(0, 0, 0.1, 0.06));
        this.addComponent(new ComponentSpecialEntityFlag("Player"));
        this.addComponent(new ComponentSprite(new Texture(Gdx.files.internal("player_sprite_still.png"))));
        this.addComponent(new ComponentInput());
        this.addComponent(new ComponentVelocity());
    }
}
