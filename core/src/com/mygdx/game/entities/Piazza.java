package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.components.ComponentCollisionEffect;
import com.mygdx.game.components.ComponentSprite;
import com.mygdx.game.serviceProviders.PiazzaEffectProvider;

/**
 * Piazza represents a piazza entity in the game.
 */
public class Piazza extends POI {

    /**
     * Constructs a Piazza entity with the specified position and dimensions.
     * @param x The x-coordinate of the position
     * @param y The y-coordinate of the position
     * @param height The height of the piazza
     * @param width The width of the piazza
     */
    public Piazza(double x, double y, double height, double width) {
        super(x, y, height, width);
        this.addComponent(new ComponentCollisionEffect(new PiazzaEffectProvider()));
        this.addComponent(new ComponentSprite(new Texture(Gdx.files.internal("piazza.png"))));
    }
}
