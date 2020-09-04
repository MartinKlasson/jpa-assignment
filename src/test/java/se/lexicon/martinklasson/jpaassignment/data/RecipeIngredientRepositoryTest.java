package se.lexicon.martinklasson.jpaassignment.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.martinklasson.jpaassignment.entity.Ingredient;
import se.lexicon.martinklasson.jpaassignment.entity.Measurement;
import se.lexicon.martinklasson.jpaassignment.entity.Recipe;
import se.lexicon.martinklasson.jpaassignment.entity.RecipeIngredient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//TESTED AND SUCCEDED 2 Sept 2020-------------------------------------------------------
@DataJpaTest
class RecipeIngredientRepositoryTest {

    RecipeIngredient recipeIngredientEggToddySugar;
    RecipeIngredient recipeIngredientEggToddyEgg;
    RecipeIngredient recipeIngredientOmeletteEgg;
    RecipeIngredient recipeIngredientOilGambasPilPil;
    RecipeIngredient recipeIngredientOmeletteSalt;

    @Autowired
    RecipeIngredientRepository recipeIngredientRepository;

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

        eggToddy = new Recipe("Egg Toddy", recipeIngredientsEggToddy, null, null);
        omelette = new Recipe("Omelette", recipeIngredientsOmelette , null, null);
        gambasPilPil = new Recipe("Gambas Pil Pil", recipeIngredientsGambasPilPil, null, null);

        recipeIngredientRepository.save(recipeIngredientEggToddySugar);
        recipeIngredientRepository.save(recipeIngredientEggToddyEgg);
        recipeIngredientRepository.save(recipeIngredientOmeletteEgg);
        recipeIngredientRepository.save(recipeIngredientOmeletteSalt);
        recipeIngredientRepository.save(recipeIngredientOilGambasPilPil);

    }
    @Test
    void successfullyCreated(){
        assertEquals(5, recipeIngredientRepository.findAll().size());
    }

    @Test
    void findAllByIngredient_IngredientName() {
        //Arrange
        String search = "Egg";

        //Act
        List<RecipeIngredient> foundRecipeIngredientsMatchingSearch =
                recipeIngredientRepository.findAllByIngredient_IngredientName(search);

        //Assert
        assertNotNull(foundRecipeIngredientsMatchingSearch);
        assertEquals(2, foundRecipeIngredientsMatchingSearch.size());
        assertTrue(foundRecipeIngredientsMatchingSearch.contains(recipeIngredientOmeletteEgg));

    }
}