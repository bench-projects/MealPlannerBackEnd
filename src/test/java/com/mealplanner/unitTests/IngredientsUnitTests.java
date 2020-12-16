package com.mealplanner.unitTests;

import com.mealplanner.controller.IngredientsController;
import com.mealplanner.entity.IngredientEntity;
import com.mealplanner.service.IngredientsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IngredientsUnitTests {

    @InjectMocks
    IngredientsController ingredientsController;

    @Mock
    IngredientsService ingredientsService;

    @Test
    public void getAllIngredientsTest() {
        IngredientEntity ingredientEntity = new IngredientEntity();
        List<IngredientEntity> ingredientEntities = new ArrayList<IngredientEntity>();
        ingredientEntities.add(ingredientEntity);

        Mockito.when(this.ingredientsService.getAllIngredients()).thenReturn(ingredientEntities);

        assertThat(this.ingredientsController.getAllIngredients().getBody()).isEqualTo((ingredientEntities));
        assertThat(this.ingredientsController.getAllIngredients().getStatusCodeValue()).isEqualTo((200));
    }

    @Test
    public void getIngredientTest() {
        IngredientEntity ingredientEntity = new IngredientEntity("test", 5);

        Mockito.when(this.ingredientsService.getIngredient(0)).thenReturn(java.util.Optional.of(ingredientEntity));

        assertThat(this.ingredientsController.getIngredient(0).getBody()).isEqualTo((Optional.of(ingredientEntity)));
        assertThat(this.ingredientsController.getIngredient(0).getStatusCodeValue()).isEqualTo((200));
    }

    @Test
    public void addIngredientTest() {
        IngredientEntity ingredientEntity = new IngredientEntity("test", 5);

        Mockito.when(this.ingredientsService.addIngredient(ingredientEntity)).thenReturn(ingredientEntity);

        assertThat(this.ingredientsController.addIngredient(ingredientEntity).getBody()).isEqualTo((ingredientEntity));
        assertThat(this.ingredientsController.addIngredient(ingredientEntity).getStatusCodeValue()).isEqualTo((201));
    }

    @Test
    public void updateIngredientEntityTest() {
        IngredientEntity ingredientEntity = new IngredientEntity();

        Mockito.when(this.ingredientsService.updateIngredientEntity(0, ingredientEntity)).thenReturn(Optional.of(ingredientEntity));

        assertThat(this.ingredientsController.updateIngredientEntity(0, ingredientEntity).getBody()).isEqualTo((Optional.of(ingredientEntity)));
        assertThat(this.ingredientsController.updateIngredientEntity(0, ingredientEntity).getStatusCodeValue()).isEqualTo((200));
    }

}
