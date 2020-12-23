package com.mealplanner.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "recipe")
public class RecipeEntity {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "recipe_name", nullable = false, length = 200)
    private String recipe_name;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "recipe_link",
            joinColumns = {@JoinColumn(name = "recipe_id")},
            inverseJoinColumns = {@JoinColumn(name = "ingredient_id")})
    private Set<IngredientEntity> ingredients = new HashSet<>();

    public RecipeEntity() {
    }

    public RecipeEntity(String recipe_name, Set<IngredientEntity> ingredients) {
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

    public Set<IngredientEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
    }
}
