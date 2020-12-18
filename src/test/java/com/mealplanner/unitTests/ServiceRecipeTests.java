package com.mealplanner.unitTests;

import com.mealplanner.entity.RecipeEntity;
import com.mealplanner.repository.RecipeRepository;
import com.mealplanner.service.RecipeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceRecipeTests {

    @InjectMocks
    RecipeService recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Test
    public void getAllRecipesTest() {
        RecipeEntity recipeEntity = new RecipeEntity();
        List<RecipeEntity> recipeEntities = new ArrayList<>();
        recipeEntities.add(recipeEntity);

        when(this.recipeRepository.findAll()).thenReturn(recipeEntities);

        assertThat(this.recipeService.getAllRecipes()).isEqualTo(recipeEntities);
    }

    @Test
    public void getRecipeTest() {
        RecipeEntity recipeEntity = new RecipeEntity("test", "1");

        when(this.recipeRepository.findById(0)).thenReturn(Optional.of(recipeEntity));

        assertThat(this.recipeService.getRecipe(0)).isEqualTo((Optional.of(recipeEntity)));
    }

    @Test
    public void addRecipeTest() {
        RecipeEntity recipeEntity = new RecipeEntity("testAdd", "0");

        when(this.recipeRepository.save(recipeEntity)).thenReturn(recipeEntity);

        assertThat(this.recipeService.addRecipe(recipeEntity)).isEqualTo(recipeEntity);
    }

    @Test
    public void updateRecipeEntityTest() {
        RecipeEntity recipeEntity = new RecipeEntity("TestUpdate", "0");

        when(this.recipeRepository.findById(1)).thenReturn(Optional.of(recipeEntity));
        when(this.recipeRepository.save(recipeEntity)).thenReturn(recipeEntity);

        assertThat(this.recipeService.updateRecipeEntity(1, recipeEntity)).isEqualTo(Optional.of(recipeEntity));
    }
}
