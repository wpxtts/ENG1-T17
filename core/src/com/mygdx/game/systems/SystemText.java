package com.mygdx.game.systems;

import com.mygdx.game.components.ComponentText;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.serviceProviders.TextEffectProvider;

import java.util.ArrayList;

public class SystemText {

    public SystemText() {}

    public void update(ArrayList<Entity> entities) {

        ArrayList<Entity> textObjects = new ArrayList<Entity>();

        for (Entity entity : entities) {
            if (entity.hasComponent(ComponentText.class)) {
                textObjects.add(entity);
            }
        }

        for (Entity textObject : textObjects) {
            WriteText(textObject);
        }

    }

    void WriteText(Entity textObject) {

        ComponentText textInfo = (ComponentText) textObject.getComponent(ComponentText.class);

        TextEffectProvider textEffect = textInfo.getTextEffectProvider();

        String text = textInfo.getText();

        float x = textInfo.getTextX();
        float y = textInfo.getTextY();
        float scale = textInfo.getTextScale();

        textEffect.writeText(text, x, y, scale);

    }
}
