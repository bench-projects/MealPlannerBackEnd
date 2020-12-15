package com.mealplanner.repository;

import com.mealplanner.entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsRepository extends JpaRepository<IngredientEntity, Integer> {

}
