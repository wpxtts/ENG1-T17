package com.mygdx.game;

public class ComponentCollision {

    // Contains all the variables which determine the size and position of an object
    // that the player can collide with.

    float x;
    float y;
    float height;
    float width;

    ComponentCollision(float x, float y, float height, float width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

}
