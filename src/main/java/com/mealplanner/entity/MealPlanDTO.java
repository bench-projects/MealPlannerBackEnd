package com.mealplanner.entity;

import java.util.List;

public class MealPlanDTO {

    private int id;

    private List<RecipeDTO> monday;
    private List<RecipeDTO> tuesday;
    private List<RecipeDTO> wednesday;
    private List<RecipeDTO> thursday;
    private List<RecipeDTO> friday;
    private List<RecipeDTO> saturday;
    private List<RecipeDTO> sunday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<RecipeDTO> getMonday() {
        return monday;
    }

    public void setMonday(List<RecipeDTO> monday) {
        this.monday = monday;
    }

    public List<RecipeDTO> getTuesday() {
        return tuesday;
    }

    public void setTuesday(List<RecipeDTO> tuesday) {
        this.tuesday = tuesday;
    }

    public List<RecipeDTO> getWednesday() {
        return wednesday;
    }

    public void setWednesday(List<RecipeDTO> wednesday) {
        this.wednesday = wednesday;
    }

    public List<RecipeDTO> getThursday() {
        return thursday;
    }

    public void setThursday(List<RecipeDTO> thursday) {
        this.thursday = thursday;
    }

    public List<RecipeDTO> getFriday() {
        return friday;
    }

    public void setFriday(List<RecipeDTO> friday) {
        this.friday = friday;
    }

    public List<RecipeDTO> getSaturday() {
        return saturday;
    }

    public void setSaturday(List<RecipeDTO> saturday) {
        this.saturday = saturday;
    }

    public List<RecipeDTO> getSunday() {
        return sunday;
    }

    public void setSunday(List<RecipeDTO> sunday) {
        this.sunday = sunday;
    }
}
