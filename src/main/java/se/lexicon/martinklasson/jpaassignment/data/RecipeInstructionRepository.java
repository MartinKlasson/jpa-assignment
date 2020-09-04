package se.lexicon.martinklasson.jpaassignment.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.martinklasson.jpaassignment.entity.RecipeInstruction;

import java.util.List;

public interface RecipeInstructionRepository extends CrudRepository<RecipeInstruction, Integer> {

    RecipeInstruction findByInstructionId(String intructionId);

    List<RecipeInstruction> findAll();
}
