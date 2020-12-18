package com.mealplanner.unitTests;

import com.mealplanner.repository.MealPlanRepository;
import com.mealplanner.service.MealPlanService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceMealPlannerUnitTests {

    @InjectMocks
    MealPlanService mealPlanService;

    @Mock
    MealPlanRepository mealPlanRepository;



}
