package se.lexicon.martinklasson.jpaassignment.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.martinklasson.jpaassignment.entity.Ingredient;
import se.lexicon.martinklasson.jpaassignment.entity.RecipeInstruction;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//TESTED AND SUCCEDED 2 Sept 2020-------------------------------------------------------
@DataJpaTest
class RecipeInstructionRepositoryTest {

    @Autowired
    RecipeInstructionRepository recipeInstructionRepository;

    @BeforeEach
    void setUp() {
        //List<RecipeInstruction> recipeInstructions = new ArrayList<>();
        RecipeInstruction recipeInstruction = new RecipeInstruction("Test");
        RecipeInstruction recipeInstruction1 = new RecipeInstruction("Hop Hop");

        recipeInstructionRepository.save(recipeInstruction);
        recipeInstructionRepository.save(recipeInstruction1);
        //String id = recipeInstruction.getInstructionId();
        //String id1 = recipeInstruction1.getInstructionId();
        //recipeInstructions.add(recipeInstruction);
        //recipeInstructions.add(recipeInstruction1);
    }

    @Test
    void successfullyCreated(){
        assertEquals(2, recipeInstructionRepository.findAll().size());
    }

    @Test
    void findByInstructionId() {
//        //Arrange
        //Hard to know which instruction is first in the list. UUID generated passwords
        String search = recipeInstructionRepository.findAll().get(1).getInstructionId();
//        //Act
        RecipeInstruction foundInstructionMatchingSearch =
                recipeInstructionRepository.findByInstructionId(search);

//        //Assert
        assertNotNull(foundInstructionMatchingSearch);
        assertEquals(search, foundInstructionMatchingSearch.getInstructionId());

        assertTrue(foundInstructionMatchingSearch.getRecipeInstructions().contains("Hop"));
   }

}