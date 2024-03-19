package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.components.ComponentCollisionEffect;
import com.mygdx.game.components.ComponentSprite;
import com.mygdx.game.serviceProviders.DuckPondEffectProvider;

/**
 * DuckPond represents a duck pond entity in the game.
 */
public class DuckPond extends POI {

    /**
     * Constructs a DuckPond entity with the specified position and dimensions.
     * @param x The x-coordinate of the position
     * @param y The y-coordinate of the position
     * @param height The height of the duck pond
     * @param width The width of the duck pond
     */
    public DuckPond(double x, double y, double height, double width) {
        super(x, y, height, width);
        this.addComponent(new ComponentCollisionEffect(new DuckPondEffectProvider()));
        this.addComponent(new ComponentSprite(new Texture(Gdx.files.internal("duck_pond.png"))));
    }
}
