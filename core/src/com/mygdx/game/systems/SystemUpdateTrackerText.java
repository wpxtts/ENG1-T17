package com.mygdx.game.systems;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.components.*;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.entities.Tracker;

import java.util.HashMap;

public class SystemUpdateTrackerText extends UpdateSystem{

    public SystemUpdateTrackerText(){}

    public void update(HashMap<String, Entity> entities){
        // Anything with text component and ComponentTrackerPointer
        for(Entity entity : entities.values()){
            if(entity.hasComponent(ComponentText.class)&&entity.hasComponent(ComponentTrackerPointer.class)){
                String trackerPointer = ((ComponentTrackerPointer) entity.getComponent(ComponentTrackerPointer.class)).getTrackerPointer();
                Tracker tracker = (Tracker) entities.get(trackerPointer);
                ComponentText text = (ComponentText) entity.getComponent(ComponentText.class);
                String outputText = "";
                if(tracker.hasComponent(ComponentValue.class)){
                    // It is a value tracker
                    outputText = ((ComponentValue) tracker.getComponent(ComponentValue.class)).getString();
                }
                if(tracker.hasComponent(ComponentTime.class)){
                    // It is a time tracker
                    outputText = ((ComponentTime) tracker.getComponent(ComponentTime.class)).getString();
                }
                text.setText(outputText);
            }
        }
    }
}
