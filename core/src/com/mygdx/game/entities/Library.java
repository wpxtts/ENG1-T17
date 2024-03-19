package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.components.ComponentCollisionEffect;
import com.mygdx.game.components.ComponentSprite;
import com.mygdx.game.serviceProviders.LibraryEffectProvider;

/**
 * Library represents a library entity in the game.
 */
public class Library extends POI {

    /**
     * Constructs a Library entity with the specified position and dimensions.
     * @param x The x-coordinate of the position
     * @param y The y-coordinate of the position
     * @param height The height of the library
     * @param width The width of the library
     */
    public Library(double x, double y, double height, double width) {
        super(x, y, height, width);
        this.addComponent(new ComponentCollisionEffect(new LibraryEffectProvider()));
        this.addComponent(new ComponentSprite(new Texture(Gdx.files.internal("library.png"))));
    }
}
