package com.mealplanner.smokeTests;

import com.mealplanner.controller.RecipeController;
import com.mealplanner.repository.RecipeRepository;
import com.mealplanner.service.RecipeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeSmokeTest {


    @Autowired
    public RecipeController recipeController;

    @Autowired
    public RecipeService recipeService;

    @Autowired
    public RecipeRepository recipeRepository;

    @Test
    public void controllerSmokeTest() {
        assertThat(this.recipeController).isNotNull();
    }

    @Test
    public void serviceSmokeTest() {
        assertThat(this.recipeService).isNotNull();
    }

    @Test
    public void repositorySmokeTest() {
        assertThat(this.recipeRepository).isNotNull();
    }

}
