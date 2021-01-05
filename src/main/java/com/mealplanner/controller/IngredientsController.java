package com.mealplanner.controller;

import com.mealplanner.entity.IngredientDTO;
import com.mealplanner.entity.IngredientEntity;
import com.mealplanner.mapper.IngredientsMapper;
import com.mealplanner.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/ingredients")
public class IngredientsController {

    private final IngredientsService ingredientsService;

    @Autowired
    private IngredientsMapper ingredientsMapper;

    private IngredientsController(@Autowired IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @GetMapping(path = "/get/All")
    public ResponseEntity<List<IngredientDTO>> getAllIngredients() {
        return new ResponseEntity<>(ingredientsMapper.mapIngredients(new HashSet<>(ingredientsService.getAllIngredients())), HttpStatus.OK);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<Optional<IngredientDTO>> getIngredient(@PathVariable("id") Integer id) {
        Optional<IngredientDTO> existingIngredient = ingredientsMapper.mapIngredient(this.ingredientsService.getIngredient(id));
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

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Optional<IngredientEntity>> updateIngredientEntity(@PathVariable("id") Integer id, @RequestBody IngredientEntity ingredientEntity) {
        Optional<IngredientEntity> updatedIngredient = this.ingredientsService.updateIngredientEntity(id, ingredientEntity);
        if  (updatedIngredient.isPresent())  {
            return ResponseEntity.ok(updatedIngredient);
        }   else    {
            return ResponseEntity.notFound().build();
        }
    }
}
