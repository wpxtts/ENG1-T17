package com.mygdx.game.serviceProviders;

import com.badlogic.gdx.Screen;
import com.mygdx.game.GameScreen;
import com.mygdx.game.components.ComponentBoolean;
import com.mygdx.game.components.ComponentTime;
import com.mygdx.game.components.ComponentValue;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.entities.TimeTracker;

import java.util.HashMap;

/**
 * Class in charge of changing to the next day
 */
public class ChangeDay{
    ChangeDay() {};

    /**
     * Changes game to next day
     * @param entities all entities
     * @param gameScreen the game screen that is running the game.
     */
    public static void changeDay(HashMap<String, Entity>entities, GameScreen gameScreen){
        // Set to next day
        TimeTracker timeTracker = (TimeTracker) entities.get("TimeTracker");
        ComponentTime time = (ComponentTime) timeTracker.getComponent(ComponentTime.class);
        time.setDay(time.getDay()+1);
        time.setHour(8);
        time.setMinute(0);

        // Check if they player has already crammed and so how many times they are allowed
        // to study the next day.
        Entity studyLeftTracker = entities.get("StudyLeftTracker");
        ComponentValue studyLeftValue = (ComponentValue) studyLeftTracker.getComponent(ComponentValue.class);
        ComponentBoolean crammed = (ComponentBoolean) studyLeftTracker.getComponent(ComponentBoolean.class);
        if(studyLeftValue.getValue()==0){
            crammed.setTruth(true);
        }
        // If the player has crammed, then they can study at most 1 time the next day
        // Otherwise they can study at most 2 times.
        if(crammed.getTruth()){
            studyLeftValue.setValue(1);
        }else{
            studyLeftValue.setValue(2);
        }

        if(time.getDay()==8){
            //End game
            gameScreen.endGame();

        }
    }

}
