package com.mealplanner.repository;

import com.mealplanner.entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IngredientsRepository extends JpaRepository<IngredientEntity, Integer> {
}
