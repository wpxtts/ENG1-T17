package com.mygdx.game.entities;

import com.mygdx.game.components.*;
import com.mygdx.game.serviceProviders.CollisionEffectProvider;

import java.util.HashMap;


/**
 * Block represents a block entity in the game.
 */
public class Block extends Entity{
    /**
     * Constructs a Block entity with the specified parameters.
     * @param x The x-coordinate of the position
     * @param y The y-coordinate of the position
     * @param height The height of the block
     * @param width The width of the block
     * @param interactable Indicates whether the block is interactable
     */
    public Block(int x, int y, int height, int width, boolean interactable) {
        this.components = new HashMap<>();
        this.addComponent(new ComponentPosition(x, y, height, width));
        this.addComponent(new ComponentCollision(interactable));
        this.addComponent(new ComponentSprite());
        this.addComponent(new ComponentCollisionEffect(new CollisionEffectProvider()));
        this.addComponent(new ComponentInput());
    }
}