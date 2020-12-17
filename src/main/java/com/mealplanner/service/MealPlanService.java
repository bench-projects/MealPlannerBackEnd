package com.mealplanner.service;

import com.mealplanner.entity.MealPlanEntity;
import com.mealplanner.entity.RecipeEntity;
import com.mealplanner.repository.MealPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class MealPlanService {
    private final MealPlanRepository mealPlanRepository;

    public MealPlanService(@Autowired MealPlanRepository mealPlanRepository){
        this.mealPlanRepository = mealPlanRepository;
    }

    public List<MealPlanEntity> getAllMealPlans(){
        return mealPlanRepository.findAll();
    }

    public Optional<MealPlanEntity> getMealPlanById(int id){
        return mealPlanRepository.findById(id);
    }

    public MealPlanEntity addMealPlan(MealPlanEntity mealPlanEntity) {
        mealPlanRepository.save(mealPlanEntity);
        return mealPlanEntity;
    }

    public Optional<MealPlanEntity> updateRecipeEntity(int id, MealPlanEntity mealPlanEntity)  {
        return mealPlanRepository.findById(id).map(updatedMealPlanEntity -> {
            updatedMealPlanEntity.setMonday(mealPlanEntity.getMonday());
            updatedMealPlanEntity.setTuesday(mealPlanEntity.getTuesday());
            updatedMealPlanEntity.setWednesday(mealPlanEntity.getWednesday());
            updatedMealPlanEntity.setThursday(mealPlanEntity.getThursday());
            updatedMealPlanEntity.setFriday(mealPlanEntity.getFriday());
            updatedMealPlanEntity.setSaturday(mealPlanEntity.getSaturday());
            updatedMealPlanEntity.setSunday(mealPlanEntity.getSunday());
            return mealPlanRepository.save(updatedMealPlanEntity);
        });
    }
}
