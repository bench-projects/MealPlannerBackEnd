package com.mealplanner.entity;

import com.mealplanner.repository.IngredientsRepository;
import com.mealplanner.repository.MealPlanRepository;
import com.mealplanner.repository.RecipeIngredientRepository;
import com.mealplanner.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {
    private final IngredientsRepository ingredientsRepository;
    private final RecipeRepository recipeRepository;
    private final MealPlanRepository mealPlanRepository;

    @Autowired
    public DataLoader(IngredientsRepository ingredientsRepository, RecipeRepository recipeRepository, MealPlanRepository mealPlanRepository) {
        this.ingredientsRepository = ingredientsRepository;
        this.recipeRepository = recipeRepository;
        this.mealPlanRepository = mealPlanRepository;
        LoadIngredients();
        LoadRecipes();
        LoadMealPlan();
    }

    private void LoadIngredients() {
        ingredientsRepository.save(new IngredientEntity("Potatoes", 5));
        ingredientsRepository.save(new IngredientEntity("Tomatoes", 3));
        ingredientsRepository.save(new IngredientEntity("Pasta", 87));
        ingredientsRepository.save(new IngredientEntity("Leak", 7));
        ingredientsRepository.save(new IngredientEntity("Gravy", 12));
        ingredientsRepository.save(new IngredientEntity("Onion", 4));
    }

    private void LoadRecipes(){
        recipeRepository.save(new RecipeEntity("Onion Soup", "1,4,6"));
        recipeRepository.save(new RecipeEntity("Tomato Pasta", "6,2,3"));
        recipeRepository.save(new RecipeEntity("Nothing", ""));
    }

    private void LoadMealPlan(){
        mealPlanRepository.save(new MealPlanEntity("7,7,8", "8,8,8", "", "", "7,8", "", "8,7" ));
    }
}
