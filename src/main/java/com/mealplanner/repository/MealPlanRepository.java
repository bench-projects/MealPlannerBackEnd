package com.mealplanner.repository;

import com.mealplanner.entity.MealPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealPlanRepository extends JpaRepository<MealPlanEntity, Integer> {
}
