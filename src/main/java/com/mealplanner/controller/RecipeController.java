package com.mealplanner.controller;

import com.mealplanner.entity.RecipeDTO;
import com.mealplanner.entity.RecipeEntity;
import com.mealplanner.mapper.RecipeMapper;
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

    @Autowired
    private RecipeMapper recipeMapper;

    private final RecipeService recipeService;

    private RecipeController(@Autowired RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(path = "/get/All")
    public ResponseEntity<List<RecipeDTO>> getRecipes() {
        return recipeMapper.mapRecipe(recipeService.getAllRecipes());
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<List<RecipeDTO>> getRecipe(@PathVariable("id") Integer id) {
        Optional<RecipeEntity> existingRecipe = this.recipeService.getRecipe(id);
        if (existingRecipe.isPresent()) {
            return recipeMapper.mapRecipe(existingRecipe.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path = "/add")
    public ResponseEntity<RecipeEntity> addRecipe(@RequestBody RecipeEntity recipeEntity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(recipeService.addRecipe(recipeEntity));
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Optional<RecipeEntity>> updateRecipe(@PathVariable("id") Integer id, @RequestBody RecipeEntity recipeEntity) {
        Optional<RecipeEntity> updatedRecipe = this.recipeService.updateRecipeEntity(id, recipeEntity);
        if(updatedRecipe.isPresent()){
            return ResponseEntity.ok(updatedRecipe);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
