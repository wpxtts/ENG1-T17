package com.mygdx.game.components;

import com.mygdx.game.serviceProviders.CollisionEffectProvider;

public class ComponentCollisionEffect extends Component{
    CollisionEffectProvider collisionEffectProvider;

    public ComponentCollisionEffect(CollisionEffectProvider collisionEffectProvider){
        this.collisionEffectProvider = collisionEffectProvider;
    }

    public CollisionEffectProvider getCollisionEffectProvider() {
        return collisionEffectProvider;
    }
}
