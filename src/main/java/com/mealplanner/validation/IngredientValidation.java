package com.mealplanner.validation;

import com.mealplanner.entity.IngredientEntity;
import org.springframework.stereotype.Component;

@Component
public class IngredientValidation {

    public boolean checkName(IngredientEntity ingredientEntity){
        boolean output;
        if (ingredientEntity.getIngredient_name() == ""){
            return output = false;
        } else {
            return output = true;
        }
    }

}
