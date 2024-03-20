package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.components.ComponentPosition;
import com.mygdx.game.components.ComponentSprite;

/**
 * Map represents a map entity in the game.
 */
public class Map extends Entity {

    /**
     * Constructs a Map entity with the specified position and dimensions.
     * @param x The x-coordinate of the position
     * @param y The y-coordinate of the position
     * @param height The height of the map
     * @param width The width of the map
     */
    public Map(int x, int y, int height, int width) {
        this.addComponent(new ComponentPosition(x, y, height, width));
        this.addComponent(new ComponentSprite(new Texture(Gdx.files.internal("map.png"))));
    }
}
