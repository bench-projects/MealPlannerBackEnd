package com.mealplanner.smokeTests;

import com.mealplanner.controller.IngredientsController;
import com.mealplanner.repository.IngredientsRepository;
import com.mealplanner.service.IngredientsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IngredientsSmokeTest {

    @Autowired
    public IngredientsController ingredientsController;

    @Autowired
    public IngredientsService ingredientsService;

    @Autowired
    public IngredientsRepository ingredientsRepository;

    @Test
    public void controllerSmokeTest() {
        assertThat(this.ingredientsController).isNotNull();
    }

    @Test
    public void serviceSmokeTest() {
        assertThat(this.ingredientsService).isNotNull();
    }

    @Test
    public void repositorySmokeTest() {
        assertThat(this.ingredientsRepository).isNotNull();
    }
}
