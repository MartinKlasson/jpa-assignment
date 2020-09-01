package se.lexicon.martinklasson.jpaassignment.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.martinklasson.jpaassignment.entity.Ingredient;

import java.util.List;

public interface

IngredientRepository extends CrudRepository<Ingredient, Integer> {

    List<Ingredient> findByIngredientNameContainingIgnoreCase(String ingredientName);

    Ingredient findByIngredientName(String ingredientName);

}
