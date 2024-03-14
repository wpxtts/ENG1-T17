package com.mygdx.game.serviceProviders;

public class DuckPondEffectProvider extends CollisionEffectProvider{
    public DuckPondEffectProvider(){}
    public void collisionEffect(){
        System.out.println("Interacted with duck pond!");
    }
}