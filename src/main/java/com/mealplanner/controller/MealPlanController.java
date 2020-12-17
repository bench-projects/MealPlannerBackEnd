package com.mealplanner.controller;

import com.mealplanner.entity.MealPlanDTO;
import com.mealplanner.mapper.MealPlannerMapper;
import com.mealplanner.service.MealPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/mealplan")
public class MealPlanController {

    @Autowired
    private MealPlannerMapper mealPlannerMapper;

    private final MealPlanService mealPlanService;

    public MealPlanController(@Autowired MealPlanService mealPlanService){
        this.mealPlanService = mealPlanService;
    }

    @GetMapping(path = "/get/All")
    public ResponseEntity<List<MealPlanDTO>> getMealPlans(){
        return mealPlannerMapper.mapMealPlan(mealPlanService.getAllMealPlans());
    }
}
