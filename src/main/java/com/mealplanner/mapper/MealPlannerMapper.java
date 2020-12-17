package com.mealplanner.mapper;

import com.mealplanner.entity.MealPlanDTO;
import com.mealplanner.entity.MealPlanEntity;
import com.mealplanner.entity.RecipeDTO;
import com.mealplanner.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.hibernate.internal.util.collections.ArrayHelper.toList;

@Component
public class MealPlannerMapper {

    @Autowired
    private RecipeMapper recipeMapper;

    @Autowired
    private RecipeService recipeService;

    public ResponseEntity<List<MealPlanDTO>> mapMealPlan(List<MealPlanEntity> mealPlanEntityList) {
        List<MealPlanDTO> mealPlanDTOS = new ArrayList<>();
        mealPlanEntityList.forEach(mealPlanEntity -> {
            MealPlanDTO mealPlanDTO = new MealPlanDTO();
            mealPlanDTO.setId(mealPlanEntity.getId());
            if (!mealPlanEntity.getMonday().isEmpty())
                mealPlanDTO.setMonday(mapDay(mealPlanEntity.getMonday()));

            if (!mealPlanEntity.getTuesday().isEmpty())
                mealPlanDTO.setTuesday(mapDay(mealPlanEntity.getTuesday()));

            if (!mealPlanEntity.getWednesday().isEmpty())
                mealPlanDTO.setWednesday(mapDay(mealPlanEntity.getWednesday()));

            if (!mealPlanEntity.getThursday().isEmpty())
                mealPlanDTO.setThursday(mapDay(mealPlanEntity.getThursday()));

            if (!mealPlanEntity.getFriday().isEmpty())
                mealPlanDTO.setFriday(mapDay(mealPlanEntity.getFriday()));

            if (!mealPlanEntity.getSaturday().isEmpty())
                mealPlanDTO.setSaturday(mapDay(mealPlanEntity.getSaturday()));

            if (!mealPlanEntity.getSunday().isEmpty())
                mealPlanDTO.setSunday(mapDay(mealPlanEntity.getSunday()));

            mealPlanDTOS.add(mealPlanDTO);
        });

        return new ResponseEntity<>(mealPlanDTOS, HttpStatus.OK);
    }

    public List<RecipeDTO> mapDay(String mealIds) {
        List<String> recipeStringIdList = toList(mealIds.split(","));
        List<Integer> recipeIdList = new ArrayList<>();
        recipeStringIdList.forEach(stringId -> recipeIdList.add(Integer.valueOf(stringId)));

        return recipeMapper.mapRecipe(recipeService.getAllRecipesById(recipeIdList)).getBody();
    }

}
