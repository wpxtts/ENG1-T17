package com.mygdx.game.components;

import com.mygdx.game.serviceProviders.CollisionEffectProvider;

/**
 * ComponentCollisionEffect represents a component that handles collision effects for an object.
 */
public class ComponentCollisionEffect extends Component {

    // Provider for collision effects
    private CollisionEffectProvider collisionEffectProvider;

    /**
     * Constructs a ComponentCollisionEffect with the specified CollisionEffectProvider.
     * @param collisionEffectProvider The provider for collision effects
     */
    public ComponentCollisionEffect(CollisionEffectProvider collisionEffectProvider) {
        this.collisionEffectProvider = collisionEffectProvider;
    }

    /**
     * Retrieves the CollisionEffectProvider associated with this component.
     * @return The CollisionEffectProvider for collision effects
     */
    public CollisionEffectProvider getCollisionEffectProvider() {
        return collisionEffectProvider;
    }
}
