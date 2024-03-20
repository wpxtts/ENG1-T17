package com.mygdx.game.systems;

import com.mygdx.game.components.ComponentText;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.serviceProviders.TextEffectProvider;

import java.util.ArrayList;
import java.util.HashMap;

public class SystemText extends UpdateSystem{

    // Constructs the text system
    public SystemText() {}

    // Update called every frame
    public void update(HashMap<String,Entity> entities) {

        // Fetches all entities with the text component
        ArrayList<Entity> textObjects = new ArrayList<Entity>();

        for (Entity entity : entities.values()) {
            if (entity.hasComponent(ComponentText.class)) {
                textObjects.add(entity);
            }
        }

        // Calls a function to write the text
        for (Entity textObject : textObjects) {
            WriteText(textObject);
        }

    }

    void WriteText(Entity textObject) {

        // Acquires the text component and the service provider within it
        ComponentText textInfo = (ComponentText) textObject.getComponent(ComponentText.class);
        TextEffectProvider textEffect = textInfo.getTextEffectProvider();

        // Acquires the text to be written and its size and location
        String text = textInfo.getText();
        float x = textInfo.getTextX();
        float y = textInfo.getTextY();
        float scale = textInfo.getTextScale();

        // Runs the service provider function to write the text
        textEffect.writeText(text, x, y, scale);

    }
}