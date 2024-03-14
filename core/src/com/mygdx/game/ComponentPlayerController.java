package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class ComponentPlayerController {

    // Contains all the variables determining the size and shape of the player.
    // This is kept distinct from the collision component so the player can be
    // easily differentiated.

    float x;
    float y;
    float height;
    float width;

    Texture sprite;

    ComponentPlayerController(float x, float y, float height, float width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    ComponentPlayerController(float x, float y, float height, float width, Texture sprite) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.sprite = sprite;
    }

}
