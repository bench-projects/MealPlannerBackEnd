package com.mealplanner.controller;

import com.mealplanner.entity.IngredientEntity;
import com.mealplanner.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/ingredients")
public class IngredientsController {

    private final IngredientsService ingredientsService;

    private IngredientsController(@Autowired IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @GetMapping(path = "/get/All")
    public ResponseEntity<List<IngredientEntity>> getIngredients() {
        return new ResponseEntity<>(ingredientsService.getAllIngredients(), HttpStatus.OK);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<Optional<IngredientEntity>> getIngredient(@PathVariable("id") Integer id) {
        Optional<IngredientEntity> existingIngredient = this.ingredientsService.getIngredient(id);
        if (existingIngredient.isPresent()) {
            return ResponseEntity.ok(existingIngredient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path = "/add")
    public ResponseEntity<IngredientEntity> addIngredient(@RequestBody IngredientEntity ingredientEntity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ingredientsService.addIngredient(ingredientEntity));
    }
}
