package com.mealplanner.service;

import com.mealplanner.entity.IngredientEntity;
import com.mealplanner.repository.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientsService {

    private IngredientsRepository ingredientsRepository;

    private IngredientsService(@Autowired IngredientsRepository ingredientsRepository){
        this.ingredientsRepository = ingredientsRepository;
    }

    public List<IngredientEntity> getAllIngredients() {
        return (List<IngredientEntity>) ingredientsRepository.findAll();
    }

    public Optional<IngredientEntity> getIngredient(Integer id){
        return ingredientsRepository.findById(id);
    }

    public  IngredientEntity addIngredient(IngredientEntity ingredientEntity){
        ingredientsRepository.save(ingredientEntity);
        return ingredientEntity;
    }

}
