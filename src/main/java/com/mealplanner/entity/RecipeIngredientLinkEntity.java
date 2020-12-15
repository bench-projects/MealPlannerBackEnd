package com.mealplanner.entity;

import javax.persistence.*;

@Entity
@Table(name = "recipeLink")
public class RecipeIngredientLinkEntity {

    public RecipeIngredientLinkEntity(){}

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "recipe_id", nullable = false)
    private String recipe_id;

    @Column(name = "ingredient_id", nullable = false)
    private String ingredient_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(String recipe_id) {
        this.recipe_id = recipe_id;
    }

    public String getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(String ingredient_id) {
        this.ingredient_id = ingredient_id;
    }
}
