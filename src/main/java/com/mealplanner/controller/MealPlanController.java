package com.mealplanner.controller;

import com.mealplanner.entity.MealPlanDTO;
import com.mealplanner.entity.MealPlanEntity;
import com.mealplanner.mapper.MealPlannerMapper;
import com.mealplanner.service.MealPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/mealplan")
public class MealPlanController {

    private final MealPlanService mealPlanService;
    @Autowired
    private MealPlannerMapper mealPlannerMapper;

    public MealPlanController(@Autowired MealPlanService mealPlanService) {
        this.mealPlanService = mealPlanService;
    }

    @GetMapping(path = "/get/All")
    public ResponseEntity<List<MealPlanDTO>> getMealPlans() {
        return mealPlannerMapper.mapMealPlan(mealPlanService.getAllMealPlans());
    }

    @PostMapping(path = "/add")
    public ResponseEntity<MealPlanEntity> addMealPlan(@RequestBody MealPlanEntity mealPlanEntity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mealPlanService.addMealPlan(mealPlanEntity));
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Optional<MealPlanEntity>> updateMealPlan(@RequestBody MealPlanEntity mealPlanEntity, @PathVariable("id") Integer id){
        Optional<MealPlanEntity> updateRecipeEntity = this.mealPlanService.updateMealPlan(id, mealPlanEntity);
        if(updateRecipeEntity.isPresent()){
            return ResponseEntity.ok(updateRecipeEntity);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

}
