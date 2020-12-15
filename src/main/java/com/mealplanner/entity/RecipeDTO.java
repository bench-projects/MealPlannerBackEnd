package com.mealplanner.entity;

import java.util.ArrayList;
import java.util.List;

public class RecipeDTO {
    private int id;

    private String recipe_name;

    private List<IngredientEntity> ingredientList = new ArrayList<>();

    public String getRecipe_name() {
        return recipe_name;
    }

    public void setRecipe_name(String recipe_name) {
        this.recipe_name = recipe_name;
    }

    public List<IngredientEntity> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<IngredientEntity> ingredientList) {
        this.ingredientList = ingredientList;
    }

}
