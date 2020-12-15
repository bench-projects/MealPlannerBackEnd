package com.mealplanner.service;

import com.mealplanner.entity.RecipeIngredientLinkEntity;
import com.mealplanner.repository.RecipeIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeIngredientLinkService {

    private RecipeIngredientRepository recipeIngredientRepository;

    public RecipeIngredientLinkService(@Autowired RecipeIngredientRepository recipeIngredientRepository){
        this.recipeIngredientRepository = recipeIngredientRepository;
    }

    public Optional<RecipeIngredientLinkEntity> getLink(int id) {
        return recipeIngredientRepository.findById(id);
    }
}
