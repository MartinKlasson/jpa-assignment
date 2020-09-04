package se.lexicon.martinklasson.jpaassignment.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.martinklasson.jpaassignment.entity.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//----------- TESTED and succeded 4 Sept 2020 - only one tested : void findAllByRecipeNameContainingIgnoreCase()
@DataJpaTest
class RecipeRepositoryTest {

    @Autowired
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {

        Ingredient sugar = new Ingredient("Sugar");
        Ingredient egg = new Ingredient("Egg");
        Ingredient oliveOil = new Ingredient("Olive Oil");
        Ingredient milk = new Ingredient("Milk");
        Ingredient salt = new Ingredient("Salt");


        Recipe eggToddy = new Recipe();
        Recipe omelette = new Recipe();
        Recipe gambasPilPil= new Recipe();

        RecipeIngredient recipeIngredientEggToddySugar;
        RecipeIngredient recipeIngredientEggToddyEgg;
        RecipeIngredient recipeIngredientOmeletteEgg;
        RecipeIngredient recipeIngredientOilGambasPilPil;
        RecipeIngredient recipeIngredientOmeletteSalt;

        recipeIngredientEggToddySugar = new RecipeIngredient(sugar, 2, Measurement.PCS, eggToddy);
        recipeIngredientEggToddyEgg = new RecipeIngredient(egg, 4, Measurement.PCS, eggToddy);
        recipeIngredientOmeletteEgg = new RecipeIngredient(egg, 2, Measurement.PCS, omelette);
        recipeIngredientOilGambasPilPil = new RecipeIngredient(oliveOil, 2, Measurement.DL, gambasPilPil);
        recipeIngredientOmeletteSalt = new RecipeIngredient(salt, 1, Measurement.TSP, omelette);

        List<RecipeIngredient> recipeIngredientsOmelette = new ArrayList<>();
        recipeIngredientsOmelette.add(recipeIngredientOmeletteEgg);
        recipeIngredientsOmelette.add(recipeIngredientOmeletteSalt);
        List<RecipeIngredient> recipeIngredientsEggToddy = new ArrayList<>();
        recipeIngredientsEggToddy.add(recipeIngredientEggToddyEgg);
        recipeIngredientsEggToddy.add(recipeIngredientEggToddySugar);
        List<RecipeIngredient> recipeIngredientsGambasPilPil = new ArrayList<>();
        recipeIngredientsGambasPilPil.add(recipeIngredientOilGambasPilPil);

        RecipeInstruction recipeInstruction = new RecipeInstruction("Test");
        RecipeInstruction recipeInstruction1 = new RecipeInstruction("Hop Hop");

        List<Recipe> eggRecipes = new ArrayList<>();
        List<Recipe> sugarRecipes = new ArrayList<>();

        List<RecipeCategory> recipeCategoriesOmelette = new ArrayList<>();
        List<RecipeCategory> recipeCategoriesEggToddy = new ArrayList<>();

        eggRecipes.add(omelette);
        eggRecipes.add(eggToddy);
        sugarRecipes.add(eggToddy);

        RecipeCategory recipeCategoryEgg = new RecipeCategory("Egg", eggRecipes);
        RecipeCategory recipeCategorySugar = new RecipeCategory("Sugar", sugarRecipes);

        recipeCategoriesEggToddy.add(recipeCategoryEgg);
        recipeCategoriesEggToddy.add(recipeCategorySugar);

        eggToddy.setRecipeName("Egg Toddy");
        eggToddy.setRecipeIngredients(recipeIngredientsEggToddy);
        eggToddy.setRecipeInstruction(recipeInstruction);
        eggToddy.setRecipeCategories(recipeCategoriesEggToddy);

        omelette.setRecipeName("Omelette");
        omelette.setRecipeIngredients(recipeIngredientsOmelette);
        omelette.setRecipeInstruction(recipeInstruction1);
        omelette.setRecipeCategories(recipeCategoriesOmelette);

        //gambasPilPil = new Recipe("Gambas Pil Pil", recipeIngredientsGambasPilPil, null, null);
        gambasPilPil.setRecipeName("Gambas Pil Pil");
        gambasPilPil.setRecipeIngredients(recipeIngredientsGambasPilPil);

//        recipeIngredientRepository.save(recipeIngredientEggToddySugar);
//        recipeIngredientRepository.save(recipeIngredientEggToddyEgg);
//        recipeIngredientRepository.save(recipeIngredientOmeletteEgg);
//        recipeIngredientRepository.save(recipeIngredientOmeletteSalt);
//        recipeIngredientRepository.save(recipeIngredientOilGambasPilPil);

        recipeRepository.save(eggToddy);
        recipeRepository.save(omelette);
        recipeRepository.save(gambasPilPil);
    }


    @Test
        void findAllByRecipeNameContainingIgnoreCase() {
        //Arrange
        String search = "omelett";


        //Act
        List<Recipe> foundRecipesMatchingSearch =
                recipeRepository.findAllByRecipeNameContainingIgnoreCase(search);

        //Assert
        assertNotNull(foundRecipesMatchingSearch);
        assertEquals(1, foundRecipesMatchingSearch.size());

    }
//
//    @Test
//    void findAllByRecipeIngredients_Ingredient_IngredientNameIgnoreCase() {
//    }
//
//    @Test
//    void findAllByRecipeCategories_RecipeCategoryIgnoreCase() {
//    }
//
//    @Test
//    void findAllByRecipeCategories() {
//    }
}