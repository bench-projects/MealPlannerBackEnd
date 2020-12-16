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

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IngredientsUnitTests {

    @InjectMocks
    IngredientsController ingredientsController;

    @Mock
    IngredientsService ingredientsService;

    @Test
    public void getAllIngredientsTest(){
        IngredientEntity ingredientEntity = new IngredientEntity();
        List<IngredientEntity> ingredientEntities = new ArrayList<IngredientEntity>();

        Mockito.when(this.ingredientsService.getAllIngredients()).thenReturn(ingredientEntities);

        assertThat(this.ingredientsController.getAllIngredients().getBody()).isEqualTo((ingredientEntities));
        assertThat(this.ingredientsController.getAllIngredients().getStatusCodeValue()).isEqualTo((200));
    }

    

}
