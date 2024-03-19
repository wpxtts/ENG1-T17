package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.components.ComponentCollision;
import com.mygdx.game.components.ComponentInput;
import com.mygdx.game.components.ComponentPosition;
import com.mygdx.game.components.ComponentSprite;

import java.util.HashMap;

/**
 * POI (Point of Interest) represents a generic point of interest entity in the game.
 */
public class POI extends Entity {

    /**
     * Constructs a POI entity with the specified position and dimensions.
     * @param x The x-coordinate of the position
     * @param y The y-coordinate of the position
     * @param height The height of the POI
     * @param width The width of the POI
     */
    public POI(double x, double y, double height, double width) {
        this.components = new HashMap<>();
        this.addComponent(new ComponentPosition(x, y, height, width));
        this.addComponent(new ComponentCollision(true));
        this.addComponent(new ComponentSprite(new Texture(Gdx.files.internal("poi.jpg"))));
        this.addComponent(new ComponentInput());
    }
}
