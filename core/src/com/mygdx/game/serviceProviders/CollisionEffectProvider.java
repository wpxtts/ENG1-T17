package com.mygdx.game.serviceProviders;
import java.util.Random;


public class CollisionEffectProvider {
    public CollisionEffectProvider(){}
    public void collisionEffect(){
        Random rand = new Random();
        System.out.println(rand.nextInt(100));
    }
}
