package com.mealplanner.entity;

import javax.persistence.*;

@Entity
@Table(name = "mealplan")
public class MealPlanEntity {

    public MealPlanEntity(){}

    public MealPlanEntity(String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday){
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
    }

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "monday", nullable = false, length = 200)
    private String monday;
    @Column(name = "tuesday", nullable = false, length = 200)
    private String tuesday;
    @Column(name = "wednesday", nullable = false, length = 200)
    private String wednesday;
    @Column(name = "thursday", nullable = false, length = 200)
    private String thursday;
    @Column(name = "friday", nullable = false, length = 200)
    private String friday;
    @Column(name = "saturday", nullable = false, length = 200)
    private String saturday;
    @Column(name = "sunday", nullable = false, length = 200)
    private String sunday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }
}
