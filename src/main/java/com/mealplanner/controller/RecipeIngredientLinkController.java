package com.mealplanner.controller;

import com.mealplanner.entity.RecipeIngredientLinkEntity;
import com.mealplanner.service.RecipeIngredientLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RecipeIngredientLinkController {

    private RecipeIngredientLinkService recipeIngredientLinkService;

    private RecipeIngredientLinkController(@Autowired RecipeIngredientLinkService recipeIngredientLinkService){
        this.recipeIngredientLinkService = recipeIngredientLinkService;
    }

    @GetMapping(path = "/getLink/{id}")
    public ResponseEntity<Optional<RecipeIngredientLinkEntity>> getLink(@PathVariable("id") Integer id){
        Optional<RecipeIngredientLinkEntity> existingDrink = recipeIngredientLinkService.getLink(id);
        if (existingDrink.isPresent()) {
            return ResponseEntity.ok(existingDrink);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
