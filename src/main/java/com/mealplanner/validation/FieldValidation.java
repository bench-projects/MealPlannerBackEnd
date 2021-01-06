package com.mealplanner.validation;

import com.mealplanner.entity.IngredientEntity;
import com.mealplanner.entity.RecipeEntity;
import org.springframework.stereotype.Component;

@Component
public class FieldValidation {

    public boolean checkName(IngredientEntity ingredientEntity){
        boolean output;
        if (ingredientEntity.getIngredient_name() == ""){
            return output = false;
        } else {
            return output = true;
        }
    }

    public boolean checkName(RecipeEntity recipeEntity){
        boolean output;
        if (recipeEntity.getRecipe_name() == ""){
            return output = false;
        } else {
            return output = true;
        }
    }

}
