package com.mealplanner.smokeTests;

import com.mealplanner.controller.MealPlanController;
import com.mealplanner.repository.MealPlanRepository;
import com.mealplanner.service.MealPlanService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MealPlannerSmokeTest {

    @Autowired
    public MealPlanController mealPlanController;

    @Autowired
    public MealPlanService mealPlanService;

    @Autowired
    public MealPlanRepository mealPlanRepository;

    @Test
    public void controllerSmokeTest() {
        assertThat(this.mealPlanController).isNotNull();
    }

    @Test
    public void serviceSmokeTest() {
        assertThat(this.mealPlanService).isNotNull();
    }

    @Test
    public void repositorySmokeTest() {
        assertThat(this.mealPlanRepository).isNotNull();
    }

}
