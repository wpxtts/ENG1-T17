package com.mygdx.game.serviceProviders;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextEffectProvider {

    SpriteBatch spriteBatch;
    BitmapFont font;

    public TextEffectProvider(){
        spriteBatch = new SpriteBatch();
        font = new BitmapFont();
    }
    public void writeText(String text, float x, float y, float scale){
        font.setColor(Color.BLACK);
        font.getData().setScale(scale);

        spriteBatch.begin();
        font.draw(spriteBatch, text, x, y);
        spriteBatch.end();
    }
}
