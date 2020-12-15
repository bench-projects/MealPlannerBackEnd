package com.mealplanner.controller;

import com.mealplanner.entity.RecipeEntity;
import com.mealplanner.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    private RecipeController(@Autowired RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(path = "/get/All")
    public ResponseEntity<List<RecipeEntity>> getRecipes() {
        return new ResponseEntity<>(recipeService.getAllRecipes(), HttpStatus.OK);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<Optional<RecipeEntity>> getRecipe(@PathVariable("id") Integer id) {
        Optional<RecipeEntity> existingRecipe = this.recipeService.getRecipe(id);
        if (existingRecipe.isPresent()) {
            return ResponseEntity.ok(existingRecipe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path = "/add")
    public ResponseEntity<RecipeEntity> addRecipe(@RequestBody RecipeEntity recipeEntity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(recipeService.addRecipe(recipeEntity));
    }
}
