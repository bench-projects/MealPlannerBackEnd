package com.mealplanner.repository;

import com.mealplanner.entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import java.util.Optional;

public abstract class IngredientsRepository implements JpaRepository<IngredientEntity, Integer> {

    private EntityManager entityManager;

    public IngredientsRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<IngredientEntity> save(IngredientEntity ingredientEntity){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(ingredientEntity);
            entityManager.getTransaction().commit();
            return Optional.of(ingredientEntity);
        } catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

}
