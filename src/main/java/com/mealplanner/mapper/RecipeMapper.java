package com.mealplanner.mapper;

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

    public ResponseEntity<List<RecipeDTO>> mapRecipe(List<RecipeEntity> recipes) {
        List<RecipeDTO> recipeDTOList = new ArrayList<>();
        recipes.forEach(recipeEntity -> recipeDTOList.add(getIngredients(recipeEntity)));
        return new ResponseEntity<>(recipeDTOList, HttpStatus.OK);
    }

    public ResponseEntity<List<RecipeDTO>> mapRecipe(RecipeEntity recipe) {
        List<RecipeDTO> recipeDTOList = new ArrayList<>();
        recipeDTOList.add(getIngredients(recipe));
        return new ResponseEntity<>(recipeDTOList, HttpStatus.OK);
    }

    public RecipeDTO getIngredients(RecipeEntity recipeEntity) {
        List<String> ingredientStringIdList = toList(recipeEntity.getIngredients().split(","));
        List<Integer> ingredientIdList = new ArrayList<>();
        ingredientStringIdList.forEach(stringId -> ingredientIdList.add(Integer.valueOf(stringId)));
        return new RecipeDTO(recipeEntity.getRecipe_name(), ingredientsService.getAllIngredientsById(ingredientIdList));
    }
}
