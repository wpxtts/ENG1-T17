package com.mygdx.game.entities;

import com.mygdx.game.components.ComponentBoolean;
import com.mygdx.game.components.ComponentValue;
/**
 * StudyLeft is an entity representing the player's capacity to study.
 */
public class StudyLeft extends ValueTracker{

    /**
     * Constructs a StudyLeft entity with the specified values.
     * @param value The amount of times the player has already studied.
     * @param crammed The ability of the player to cram by studying twice in one day
     */
    public StudyLeft(int value,boolean crammed) {
        super(value,"StudyLeft");
        this.addComponent(new ComponentBoolean(crammed));
    }
}
