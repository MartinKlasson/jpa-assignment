package se.lexicon.martinklasson.jpaassignment.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.martinklasson.jpaassignment.entity.Ingredient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//TESTED AND SUCCEDED 2 Sept 2020-------------------------------------------------------
@DataJpaTest
class IngredientRepositoryTest {

    Ingredient testObject;

    @Autowired
    IngredientRepository ingredientRepository;

    @BeforeEach
    void setUp() {
        testObject = ingredientRepository.save(new Ingredient("Olives"));
        Ingredient butter = new Ingredient("Butter");
        Ingredient oliveOil = new Ingredient("Olive Oil");
        Ingredient cream = new Ingredient("Cream");
        ingredientRepository.save(butter);
        ingredientRepository.save(oliveOil);
        ingredientRepository.save(cream);
    }

    @Test
    void successfullyCreated(){
        assertEquals(4, ingredientRepository.findAll().size());
    }

    @Test
    void findByIngredientNameContainingIgnoreCase() {
        //Arrange
        String search = "olive";

        //Act
        List<Ingredient> foundIngredientsMatchingSearch =
                        ingredientRepository.findByIngredientNameContainingIgnoreCase(search);

        //Assert
        assertNotNull(foundIngredientsMatchingSearch);
        assertEquals(2, foundIngredientsMatchingSearch.size());
        assertTrue(foundIngredientsMatchingSearch.contains(testObject));

    }

    @Test
    void findByIngredientName() {

    }
}