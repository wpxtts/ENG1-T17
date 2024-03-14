package com.mygdx.game.serviceProviders;

public class LibraryEffectProvider extends CollisionEffectProvider{
    public LibraryEffectProvider(){}
    public void collisionEffect(){
        System.out.println("Interacted with library!");
    }
}