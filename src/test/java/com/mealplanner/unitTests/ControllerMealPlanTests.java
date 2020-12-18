package com.mealplanner.unitTests;

import com.mealplanner.controller.MealPlanController;
import com.mealplanner.entity.MealPlanEntity;
import com.mealplanner.entity.RecipeEntity;
import com.mealplanner.mapper.MealPlannerMapper;
import com.mealplanner.service.IngredientsService;
import com.mealplanner.service.MealPlanService;
import com.mealplanner.service.RecipeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerMealPlanTests {

    @InjectMocks
    MealPlanController mealPlanController;

    @Mock
    MealPlanService mealPlanService;

    @Mock
    RecipeService recipeService;

    @Mock
    IngredientsService ingredientsService;

    @Mock
    @Autowired
    MealPlannerMapper mealPlannerMapper;

    @Test
    public void addMealPlanTest() {
        MealPlanEntity mealPlanEntity = new MealPlanEntity("1", "1","1","1","1","1","1");

        when(this.mealPlanService.addMealPlan(mealPlanEntity)).thenReturn(mealPlanEntity);

        assertThat(this.mealPlanController.addMealPlan(mealPlanEntity).getBody()).isEqualTo((mealPlanEntity));
        assertThat(this.mealPlanController.addMealPlan(mealPlanEntity).getStatusCodeValue()).isEqualTo((201));
    }

    @Test
    public void updateMealPlanEntityTest() {
        MealPlanEntity mealPlanEntity = new MealPlanEntity();

        when(this.mealPlanService.updateMealPlan(0, mealPlanEntity)).thenReturn(Optional.of(mealPlanEntity));

        assertThat(this.mealPlanController.updateMealPlan(mealPlanEntity, 0).getBody()).isEqualTo((Optional.of(mealPlanEntity)));
        assertThat(this.mealPlanController.updateMealPlan(mealPlanEntity, 0).getStatusCodeValue()).isEqualTo((200));
    }
}
