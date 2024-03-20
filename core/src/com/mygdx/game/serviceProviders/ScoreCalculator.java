package com.mygdx.game.serviceProviders;

/**
 * Service provider to calculate score
 */
public class ScoreCalculator {
    // studyWeighting + wellbeingWeighting = 1
    // studyWeight represents how much studying is weighted in the overall score
    static float studyWeighting = 0.6f;
    // wellbeingWeighting represents how much wellbeing activities are rated in the final overall score
    static float wellbeingWeighting = 0.4f;

    /**
     * Calculates a score between 0% and 100% for what the player gets on their exam
     * @param study the number of times the player studied
     * @param fun the number of times the player had fun
     * @param eat the number of times the player ate
     * @return the overall score
     */
    public static int calculateScore(int study, int fun, int eat){
        float overallScore;
        if(study>=7){
            int wellbeingScore = fun +eat;
            float combinedScore =  ((study*studyWeighting)*(wellbeingScore*wellbeingWeighting));
            overallScore = Math.max((1/(-(combinedScore+1)/2000)+100),40);
        }else{
            overallScore = (int) Math.floor(Math.random()*(39));
        }
        return (int) overallScore;
    }

}
