package com.mygdx.game.components;

import com.mygdx.game.serviceProviders.TextEffectProvider;

public class ComponentText extends Component {

    TextEffectProvider textEffectProvider;
    String text;
    float textX;
    float textY;
    float textScale;

    public ComponentText(TextEffectProvider textEffectProvider, String text, float x, float y, float scale){
        this.textEffectProvider = textEffectProvider;
        this.text = text;
        this.textX = x;
        this.textY = y;
        this.textScale = scale;
    }

    public TextEffectProvider getTextEffectProvider() {
        return textEffectProvider;
    }

    public String getText() {return text;}
    public void setText(String text) {this.text = text;}

    public float getTextX() {return textX;}
    public void setTextX(int textX) {this.textX = textX;}

    public float getTextY() {return textY;}
    public void setTextY(int textY) {this.textY = textY;}

    public float getTextScale() {return textScale;}
    public void setTextScale(int textScale) {this.textScale = textScale;}
}