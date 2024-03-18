package com.mygdx.game.serviceProviders;

public class PiazzaEffectProvider extends CollisionEffectProvider{
    public PiazzaEffectProvider(){}
    public void collisionEffect(){
        System.out.println("Interacted with Piazza!");
    }
}