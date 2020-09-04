package se.lexicon.martinklasson.jpaassignment.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.martinklasson.jpaassignment.entity.Ingredient;
import se.lexicon.martinklasson.jpaassignment.entity.RecipeIngredient;

import java.util.List;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, Integer> {

    List<RecipeIngredient> findAllByIngredient_IngredientName(String ingredientName);

    List<RecipeIngredient> findAll();

}
