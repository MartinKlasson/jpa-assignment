package se.lexicon.martinklasson.jpaassignment.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.martinklasson.jpaassignment.entity.Recipe;
import se.lexicon.martinklasson.jpaassignment.entity.RecipeCategory;

import java.util.ArrayList;
import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    //Recipe findByRecipeName(String recipeName);

    //Searching for recipe containing specific string
    List<Recipe> findAllByRecipeNameContainingIgnoreCase(String recipeNamePart);

    //Searching for recipes containing a specific ingredient
    //List<Recipe> findAllByRecipeIngredients_Ingredient_IngredientNameIgnoreCase(String ingredientName);

    //Searching for recipes of a certain category
    //List<Recipe> findAllByRecipeCategories_RecipeCategoryIgnoreCase(String categoryName);

    //Searching for recipes that match one or more categories
    //List<Recipe> findAllByRecipeCategories(List<RecipeCategory>  recipeCategories);
}
