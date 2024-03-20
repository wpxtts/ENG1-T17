package com.mygdx.game.serviceProviders;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextEffectProvider {

    SpriteBatch spriteBatch;
    BitmapFont font;

    // Constructs the effect provider, defining a batch
    public TextEffectProvider(SpriteBatch batch,BitmapFont font){
        this.spriteBatch = batch;
        this.font = font;
    }

    // Function called to write text
    public void writeText(String text, float x, float y, float scale){

        // Sets the colour and scale of the font
        font.setColor(Color.BLACK);
        font.getData().setScale(scale);

        // Draws the specified text
        font.draw(spriteBatch, text, x, y);

    }
}
