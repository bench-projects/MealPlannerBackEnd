package com.mealplanner.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Recipe {

    public Recipe(){}

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String recipe_name;

    @Column
    private String ingredient_ids;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecipe_name() {
        return recipe_name;
    }

    public void setRecipe_name(String recipe_name) {
        this.recipe_name = recipe_name;
    }

    public String getIngredient_ids() {
        return ingredient_ids;
    }

    public void setIngredient_ids(String ingredient_ids) {
        this.ingredient_ids = ingredient_ids;
    }
}
