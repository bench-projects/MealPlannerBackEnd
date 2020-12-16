package com.mealplanner.unitTests;

import com.mealplanner.controller.RecipeController;
import com.mealplanner.entity.IngredientEntity;
import com.mealplanner.entity.RecipeDTO;
import com.mealplanner.entity.RecipeEntity;
import com.mealplanner.mapper.RecipeMapper;
import com.mealplanner.service.IngredientsService;
import com.mealplanner.service.RecipeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeUnitTests {

    @InjectMocks
    RecipeController recipeController;

    @Mock
    RecipeService recipeService;

    @Mock
    IngredientsService ingredientsService;

    @Autowired
    RecipeMapper recipeMapper;

    @Test
    public void testGetRecipe(){
        RecipeEntity recipeEntity = new RecipeEntity("Soup", "1");
        List<RecipeEntity> recipeEntities = new ArrayList<>();
        recipeEntities.add(recipeEntity);

        RecipeDTO recipeDTO = new RecipeDTO();
        List<RecipeDTO> recipeDTOs = new ArrayList<>();
        recipeDTOs.add(recipeDTO);

        ResponseEntity<List<RecipeDTO>> listResponseEntity = new ResponseEntity<>(recipeDTOs, HttpStatus.OK);
        IngredientEntity ingredientEntity = new IngredientEntity("test", 5);

        List<Integer> ids = new ArrayList<>();
        ids.add(1);

        when(this.recipeService.getAllRecipes()).thenReturn(recipeEntities);
        when(this.recipeMapper.mapRecipe(recipeEntities)).thenReturn(listResponseEntity);
        when(this.ingredientsService.getAllIngredientsById(ids)).thenReturn(Collections.singletonList(ingredientEntity));

        assertEquals(this.recipeController.getRecipes().getBody(), recipeDTOs);
        assertThat(this.recipeController.getRecipes().getStatusCodeValue()).isEqualTo((200));
    }
}
