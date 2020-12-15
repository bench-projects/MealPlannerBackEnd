package com.mealplanner.service;

import com.mealplanner.entity.IngredientEntity;
import com.mealplanner.repository.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientsService {

    private final IngredientsRepository ingredientsRepository;

    private IngredientsService(@Autowired IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    public List<IngredientEntity> getAllIngredients() {
        return ingredientsRepository.findAll();
    }

    public Optional<IngredientEntity> getIngredient(Integer id) {
        return ingredientsRepository.findById(id);
    }

    public IngredientEntity addIngredient(IngredientEntity ingredientEntity) {
        ingredientsRepository.save(ingredientEntity);
        return ingredientEntity;
    }

    public Optional<IngredientEntity> updateIngredientEntity(int id, IngredientEntity ingredientEntity)  {
        return ingredientsRepository.findById(id).map(updatedIngredientEntity -> {
            updatedIngredientEntity.setIngredient_name(ingredientEntity.getIngredient_name());
            updatedIngredientEntity.setQuantity_count(ingredientEntity.getQuantity_count());
            return ingredientsRepository.save(updatedIngredientEntity);
        });
    }

}
