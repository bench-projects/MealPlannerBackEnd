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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerRecipeUnitTests {

    @InjectMocks
    RecipeController recipeController;

    @Mock
    RecipeService recipeService;

    @Mock
    IngredientsService ingredientsService;

    @Mock
    @Autowired
    RecipeMapper recipeMapper;

    @Test
    public void testGetAllRecipes() {
        IngredientEntity ingredientEntity = new IngredientEntity("Chicken", 3);
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        when(this.ingredientsService.getAllIngredientsById(ids)).thenReturn(Collections.singletonList(ingredientEntity));
        ReflectionTestUtils.setField(recipeMapper, "ingredientsService", ingredientsService);

        List<RecipeEntity> recipeEntities = new ArrayList<>();
        recipeEntities.add(new RecipeEntity("Pie", "1"));

        when(this.recipeService.getAllRecipes()).thenReturn(recipeEntities);
        ReflectionTestUtils.setField(recipeController, "recipeMapper", recipeMapper);

        RecipeDTO actualRecipeDTO = Objects.requireNonNull(this.recipeController.getRecipes().getBody()).get(0);
        assertEquals(actualRecipeDTO.getRecipe_name(), "Pie");
        IngredientEntity actualIngredientEntity = actualRecipeDTO.getIngredientList().get(0);
        assertEquals(actualIngredientEntity.getIngredient_name(), "Chicken");
        assertEquals(actualIngredientEntity.getQuantity_count(), 3);
        assertThat(this.recipeController.getRecipes().getStatusCodeValue()).isEqualTo((200));
    }

    @Test
    public void testGetSingularRecipeById() {
        IngredientEntity ingredientEntity = new IngredientEntity("Lamb", 2);
        List<Integer> ids = new ArrayList<>();
        ids.add(2);
        when(this.ingredientsService.getAllIngredientsById(ids)).thenReturn(Collections.singletonList(ingredientEntity));
        ReflectionTestUtils.setField(recipeMapper, "ingredientsService", ingredientsService);

        RecipeEntity recipeEntity = new RecipeEntity("Curry", "2");

        when(this.recipeService.getRecipe(1)).thenReturn(Optional.of(recipeEntity));
        ReflectionTestUtils.setField(recipeController, "recipeMapper", recipeMapper);

        RecipeDTO actualRecipeDTO = Objects.requireNonNull(this.recipeController.getRecipe(1).getBody()).get(0);
        assertEquals(actualRecipeDTO.getRecipe_name(), "Curry");
        IngredientEntity actualIngredientEntity = actualRecipeDTO.getIngredientList().get(0);
        assertEquals(actualIngredientEntity.getIngredient_name(), "Lamb");
        assertEquals(actualIngredientEntity.getQuantity_count(), 2);
        assertThat(this.recipeController.getRecipes().getStatusCodeValue()).isEqualTo((200));
    }

    @Test
    public void addRecipeTest() {
        RecipeEntity recipeEntity = new RecipeEntity("test", "1");

        Mockito.when(this.recipeService.addRecipe(recipeEntity)).thenReturn(recipeEntity);

        assertThat(this.recipeController.addRecipe(recipeEntity).getBody()).isEqualTo((recipeEntity));
        assertThat(this.recipeController.addRecipe(recipeEntity).getStatusCodeValue()).isEqualTo((201));
    }

    @Test
    public void addRecipeFailTest() {
        RecipeEntity recipeEntity = new RecipeEntity("", "1");

        assertThat(this.recipeController.addRecipe(recipeEntity).getStatusCodeValue()).isEqualTo((400));
    }

    @Test
    public void updateRecipeEntityTest() {
        RecipeEntity recipeEntity = new RecipeEntity();

        Mockito.when(this.recipeService.updateRecipeEntity(0, recipeEntity)).thenReturn(Optional.of(recipeEntity));

        assertThat(this.recipeController.updateRecipe(0, recipeEntity).getBody()).isEqualTo((Optional.of(recipeEntity)));
        assertThat(this.recipeController.updateRecipe(0, recipeEntity).getStatusCodeValue()).isEqualTo((200));
    }
}
