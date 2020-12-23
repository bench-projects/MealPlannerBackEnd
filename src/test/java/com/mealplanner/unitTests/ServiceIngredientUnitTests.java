package com.mealplanner.unitTests;

import com.mealplanner.entity.IngredientEntity;
import com.mealplanner.repository.IngredientsRepository;
import com.mealplanner.service.IngredientsService;
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

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceIngredientUnitTests {

    @InjectMocks
    IngredientsService ingredientsService;

    @Mock
    IngredientsRepository ingredientsRepository;

    @Test
    public void getAllIngredientsTest() {
        IngredientEntity ingredientEntity = new IngredientEntity();
        List<IngredientEntity> ingredientEntities = new ArrayList<IngredientEntity>();
        ingredientEntities.add(ingredientEntity);

        Mockito.when(this.ingredientsRepository.findAll()).thenReturn(ingredientEntities);

        assertThat(this.ingredientsService.getAllIngredients()).isEqualTo(ingredientEntities);
    }

    @Test
    public void getIngredientTest() {
        IngredientEntity ingredientEntity = new IngredientEntity("test", 1);

        Mockito.when(this.ingredientsRepository.findById(0)).thenReturn(Optional.of(ingredientEntity));

        assertThat(this.ingredientsService.getIngredient(0)).isEqualTo((Optional.of(ingredientEntity)));
    }

    @Test
    public void addIngredientTest() {
        IngredientEntity ingredientEntity = new IngredientEntity("testAdd", 0);

        Mockito.when(this.ingredientsRepository.save(ingredientEntity)).thenReturn(Optional.of(ingredientEntity));

        assertThat(this.ingredientsService.addIngredient(ingredientEntity)).isEqualTo(ingredientEntity);
    }

    @Test
    public void updateIngredientEntityTest() {
        IngredientEntity ingredientEntity = new IngredientEntity("TestUpdate", 2);

        Mockito.when(this.ingredientsRepository.findById(1)).thenReturn(Optional.of(ingredientEntity));
        Mockito.when(this.ingredientsRepository.save(ingredientEntity)).thenReturn(Optional.of(ingredientEntity));

        assertThat(this.ingredientsService.updateIngredientEntity(1, ingredientEntity)).isEqualTo(Optional.of(ingredientEntity));
    }

    @Test
    public void getAllIngredientsByIdTest() {
        IngredientEntity ingredientEntity = new IngredientEntity();
        List ingredientIdList = new ArrayList<>();
        ingredientIdList.add(1);
        List ingredientList = new ArrayList<>();
        ingredientList.add(ingredientEntity);

        Mockito.when(this.ingredientsRepository.findAllById(ingredientIdList)).thenReturn(ingredientList);

        assertThat(this.ingredientsService.getAllIngredientsById(ingredientIdList)).isEqualTo(ingredientList);
    }


}
