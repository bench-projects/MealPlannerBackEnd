package com.mealplanner.entity;

import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;

@Entity
@Table(name = "recipe")
public class RecipeEntity {

    public RecipeEntity(){}

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "recipe_name", nullable = false, length = 200)
    private String recipe_name;

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

}
