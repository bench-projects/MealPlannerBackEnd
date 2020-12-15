package com.mealplanner.entity;

import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;

@Entity
@Table(name = "ingredients")
public class IngredientEntity {
    
    public IngredientEntity() {}

    public IngredientEntity(String ing_name, float quantity_count) {
        this.ing_name = ing_name;
        this.quantity_count = quantity_count;
    }

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "ing_name", nullable = false, length = 100)
    private String ing_name;

    @Column(name = "quantity_count", nullable = false, length = 3)
    private float quantity_count;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIng_name() {
        return ing_name;
    }

    public void setIng_name(String ing_name) {
        this.ing_name = ing_name;
    }

    public float getQuantity_count() {
        return quantity_count;
    }

    public void setQuantity_count(float quantity_count) {
        this.quantity_count = quantity_count;
    }
}
