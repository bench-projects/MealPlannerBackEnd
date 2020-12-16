package com.mealplanner.mapper;

import com.mealplanner.entity.IngredientEntity;
import com.mealplanner.entity.RecipeDTO;
import com.mealplanner.entity.RecipeEntity;
import com.mealplanner.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.hibernate.internal.util.collections.ArrayHelper.toList;

@Component
public class RecipeMapper {

    @Autowired
    private IngredientsService ingredientsService;

    public ResponseEntity<List<RecipeDTO>> mapRecipe(List<RecipeEntity> recipes){
        List<RecipeDTO> recipeDTOList = new ArrayList<>();

        recipes.forEach(recipeEntity -> {
            List<String> ingredientStringIdList = toList(recipeEntity.getIngredients().split(","));
            List<Integer> ingredientIdList = new ArrayList<>();
            ingredientStringIdList.forEach(stringId -> ingredientIdList.add(Integer.valueOf(stringId)));
            RecipeDTO recipeDTO = new RecipeDTO(recipeEntity.getRecipe_name(), ingredientsService.getAllIngredientsById(ingredientIdList));
            recipeDTOList.add(recipeDTO);
        });

        return new ResponseEntity<>(recipeDTOList, HttpStatus.OK);
    }
}
