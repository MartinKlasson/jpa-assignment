package se.lexicon.martinklasson.jpaassignment.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class RecipeInstruction {
    //Generate as UUID from Hibernate
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private  String instructionId;

    private String recipeInstructions;

    public RecipeInstruction() {
    }

    public RecipeInstruction(String recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }

    public String getInstructionId() {
        return instructionId;
    }

    public String getRecipeInstructions() {
        return recipeInstructions;
    }

    public void setRecipeInstructions(String recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeInstruction that = (RecipeInstruction) o;
        return Objects.equals(instructionId, that.instructionId) &&
                Objects.equals(recipeInstructions, that.recipeInstructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instructionId, recipeInstructions);
    }

    @Override
    public String toString() {
        return "RecipeInstruction{" +
                "instructionId='" + instructionId + '\'' +
                ", recipeInstructions='" + recipeInstructions + '\'' +
                '}';
    }
}
