package com.mealplanner.repository;

import com.mealplanner.entity.RecipeEntity;
import com.mealplanner.entity.RecipeIngredientLinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredientLinkEntity, Integer> {
}
