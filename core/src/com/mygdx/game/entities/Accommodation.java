package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.components.ComponentCollisionEffect;
import com.mygdx.game.components.ComponentSprite;
import com.mygdx.game.serviceProviders.AccommodationEffectProvider;

/**
 * Accommodation represents an accommodation entity in the game.
 */
public class Accommodation extends POI {

    /**
     * Constructs an Accommodation entity with the specified position and dimensions.
     * @param x The x-coordinate of the position
     * @param y The y-coordinate of the position
     * @param height The height of the accommodation
     * @param width The width of the accommodation
     */
    public Accommodation(double x, double y, double height, double width) {
        super(x, y, height, width);
        this.addComponent(new ComponentCollisionEffect(new AccommodationEffectProvider()));
        this.addComponent(new ComponentSprite(new Texture(Gdx.files.internal("accommodation.png"))));
    }
}
