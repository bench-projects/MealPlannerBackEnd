package com.mealplanner.entity;

import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;

@Entity
@Table(name = "ingredients")
public class IngredientEntity {
    
    public IngredientEntity() {}
    
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "ing_name", nullable = false, length = 100)
    private String ing_name;

    @Column(name = "quantity_count", nullable = false, length = 3)
    private int quantity_count;

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

    public int getQuantity_count() {
        return quantity_count;
    }

    public void setQuantity_count(int quantity_count) {
        this.quantity_count = quantity_count;
    }
}
