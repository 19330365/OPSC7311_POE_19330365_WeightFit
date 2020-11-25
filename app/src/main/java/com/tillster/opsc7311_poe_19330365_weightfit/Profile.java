package com.tillster.opsc7311_poe_19330365_weightfit;

import java.text.DecimalFormat;

public class Profile {
    private String CurrentWeight;
    private String CurrentHeight;
    private String GoalWeight;
    private String GoalHeight;

    public String getCurrentWeight() {
        return CurrentWeight;
    }

    public void setCurrentWeight(String currentWeight) {
        CurrentWeight = currentWeight;
    }

    public String getCurrentHeight() {
        return CurrentHeight;
    }

    public void setCurrentHeight(String currentHeight) {
        CurrentHeight = currentHeight;
    }

    public String getGoalWeight() {
        return GoalWeight;
    }

    public void setGoalWeight(String goalWeight) {
        GoalWeight = goalWeight;
    }

    public String getGoalHeight() {
        return GoalHeight;
    }

    public void setGoalHeight(String goalHeight) {
        GoalHeight = goalHeight;
    }

    public Profile(){

    }
    public Profile(String currentWeight, String currentHeight, String goalWeight, String goalHeight) {
        CurrentWeight = currentWeight;
        CurrentHeight = currentHeight;
        GoalWeight = goalWeight;
        GoalHeight = goalHeight;
    }
}
