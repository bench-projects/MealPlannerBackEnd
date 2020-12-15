package com.mealplanner.entity;

import com.mealplanner.repository.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IngredientDataLoader {
    private IngredientsRepository ingredientsRepository;

    @Autowired
    public IngredientDataLoader(IngredientsRepository ingredientsRepository){
        this.ingredientsRepository = ingredientsRepository;
                LoadIngredients();
    }
    private void LoadIngredients() {
        ingredientsRepository.save(new IngredientEntity("Potatoes",5));
        ingredientsRepository.save(new IngredientEntity("Tomatoes",3));
        ingredientsRepository.save(new IngredientEntity("Pasta",87));
        ingredientsRepository.save(new IngredientEntity("Leak",7));
        ingredientsRepository.save(new IngredientEntity("Gravy",12));
        ingredientsRepository.save(new IngredientEntity("Onion",4));
    }
}
