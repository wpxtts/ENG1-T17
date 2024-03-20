package com.mygdx.game.serviceProviders;

public class ScoreCalculator {
    // studyWeighting + wellbeingWeighting = 1
    static float studyWeighting = 0.6f;
    static float wellbeingWeighting = 0.4f;

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
