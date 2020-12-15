package com.mealplanner.service;

import com.mealplanner.entity.RecipeEntity;
import com.mealplanner.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(@Autowired RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<RecipeEntity> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Optional<RecipeEntity> getRecipe(int id) {
        return recipeRepository.findById(id);
    }

    public RecipeEntity addRecipe(RecipeEntity recipeEntity) {
        recipeRepository.save(recipeEntity);
        return recipeEntity;
    }
}
