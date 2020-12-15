package com.mealplanner.entity;

import javax.persistence.*;

@Entity
@Table(name = "recipe")
public class RecipeEntity {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "recipe_name", nullable = false, length = 200)
    private String recipe_name;
    @Column(name = "ingredient_ids")
    private String ingredients;

    public RecipeEntity() {
    }

    public RecipeEntity(String recipe_name, String ingredients) {
        this.recipe_name = recipe_name;
        this.ingredients = ingredients;
    }

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

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
