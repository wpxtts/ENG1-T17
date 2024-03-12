package com.mygdx.game;

public class ComponentPlayerController {

    // Contains all the variables determining the size and shape of the player.
    // This is kept distinct from the collision component so the player can be
    // easily differentiated.

    float x;
    float y;
    float height;
    float width;

    ComponentPlayerController(float x, float y, float height, float width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

}
