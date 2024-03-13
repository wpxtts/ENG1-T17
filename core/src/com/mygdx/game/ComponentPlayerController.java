package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;

public class ComponentPlayerController {
    float x;
    float y;
    float height;
    float width;
    Color color; // Add color field

    public ComponentPlayerController(float x, float y, float height, float width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.color = Color.RED; // Default color
    }
}
