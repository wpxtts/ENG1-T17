package com.mygdx.game.serviceProviders;

import java.util.Random;

public class ClickEffectProvider {
    public ClickEffectProvider(){}
    public void clickEffect(){
        Random rand = new Random();
        System.out.println(rand.nextInt(100));
    }
}
