package com.mealplanner.mapper;

import com.mealplanner.entity.IngredientDTO;
import com.mealplanner.entity.IngredientEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class IngredientsMapper {
    public List<IngredientDTO> mapIngredients(Set<IngredientEntity> ingredients) {
        List<IngredientDTO> ingredientDTOList = new ArrayList<>();
        ingredients.forEach(ingredientEntity -> ingredientDTOList.add(new IngredientDTO(ingredientEntity.getIngredient_name(), ingredientEntity.getQuantity_count())));
        return ingredientDTOList;
    }

    public Optional<IngredientDTO> mapIngredient(Optional<IngredientEntity> ingredient) {
        return Optional.of(new IngredientDTO(ingredient.get().getIngredient_name(), ingredient.get().getQuantity_count()));
    }
}
