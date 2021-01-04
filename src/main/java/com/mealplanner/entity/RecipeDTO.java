package com.mealplanner.entity;

import java.util.ArrayList;
import java.util.List;

public class RecipeDTO {
    private int id;

    private String recipe_name;

    private List<IngredientDTO> ingredientList = new ArrayList<>();

    public RecipeDTO(String recipe_name, List<IngredientDTO> ingredientList) {
        this.recipe_name = recipe_name;
        this.ingredientList = ingredientList;
    }

    public RecipeDTO(int id,String recipe_name, List<IngredientDTO> ingredientList) {
        this.id = id;
        this.recipe_name = recipe_name;
        this.ingredientList = ingredientList;
    }

    public RecipeDTO() {

    }

    public String getRecipe_name() {
        return recipe_name;
    }

    public void setRecipe_name(String recipe_name) {
        this.recipe_name = recipe_name;
    }

    public List<IngredientDTO> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<IngredientDTO> ingredientList) {
        this.ingredientList = ingredientList;
    }

}
