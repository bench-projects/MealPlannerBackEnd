package com.mealplanner.entity;

public class IngredientDTO {
    private int id;

    private String ingredient_name;
    private float quantity_count;

    public IngredientDTO(String ingredient_name, float quantity_count) {
        this.ingredient_name = ingredient_name;
        this.quantity_count = quantity_count;
    }

    public IngredientDTO(int id, String ingredient_name, float quantity_count) {
        this.id = id;
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

    public IngredientDTO() {

    }
}
