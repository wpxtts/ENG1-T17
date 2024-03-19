package com.mygdx.game.components;

import com.badlogic.gdx.graphics.Texture;

/**
 * ComponentSprite represents a component that indicates the presence of a sprite to be rendered.
 */
public class ComponentSprite extends Component {

    // The texture representing the sprite
    private Texture sprite;

    /**
     * Constructs a ComponentSprite without initializing the sprite.
     */
    public ComponentSprite() {}

    /**
     * Constructs a ComponentSprite with the specified sprite texture.
     * @param sprite The texture representing the sprite
     */
    public ComponentSprite(Texture sprite) {
        this.sprite = sprite;
    }

    /**
     * Retrieves the sprite texture.
     * @return The sprite texture
     */
    public Texture getSprite() {
        return sprite;
    }

    /**
     * Sets the sprite texture.
     * @param sprite The sprite texture to set
     */
    public void setSprite(Texture sprite) {
        this.sprite = sprite;
    }
}
