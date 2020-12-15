package com.mealplanner.entity;

import javax.persistence.*;

@Entity
@Table(name = "ingredients")
public class IngredientEntity {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "ingredient_name", nullable = false, length = 100)
    private String ingredient_name;
    @Column(name = "quantity_count", nullable = false, length = 3)
    private float quantity_count;

    public IngredientEntity() {
    }

    public IngredientEntity(String ingredient_name, float quantity_count) {
        this.ingredient_name = ingredient_name;
        this.quantity_count = quantity_count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIngredient_name() {
        return ingredient_name;
    }

    public void setIngredient_name(String ingredient_name) {
        this.ingredient_name = ingredient_name;
    }

    public float getQuantity_count() {
        return quantity_count;
    }

    public void setQuantity_count(float quantity_count) {
        this.quantity_count = quantity_count;
    }
}
