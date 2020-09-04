package se.lexicon.martinklasson.jpaassignment.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int recipeId;
    private String recipeName;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe",
               cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<RecipeIngredient> recipeIngredients;


    @OneToOne(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
            @JoinColumn//(name = "recipe_id")
    private RecipeInstruction recipeInstruction;


    @ManyToMany(fetch = FetchType.LAZY,
                cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
                mappedBy = "categoryRecipes")
    private List<RecipeCategory> recipeCategories;


    public Recipe() {
    }

    public Recipe(String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction recipeInstruction, List<RecipeCategory> recipeCategories) {
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.recipeInstruction = recipeInstruction;
        this.recipeCategories = recipeCategories;
    }

    //Convenience methods


    //Add and remove ingredient from recipe
   public void addIngredient(RecipeIngredient recipeIngredient){
        recipeIngredients.add(recipeIngredient);
        recipeIngredient.setRecipe(this);
   }
//
//    public void removeIngredient(RecipeIngredient recipeIngredient){
//        recipeIngredients.remove(recipeIngredient);
//    }
//
//    //Add and remove instruction from recipe
//    public void addInstruction(RecipeInstruction recipeInstruction){
//        this.recipeInstruction = recipeInstruction;
//    }
//
//    public void removeInstruction(RecipeInstruction recipeInstruction){
//        //this.setRecipeInstruction(recipeInstruction);
//    }
//
//    //Add and remove category from recipe
//    public void addCategory(RecipeCategory recipeCategory){
//        this.recipeCategories.add(recipeCategory);
//        recipeCategories.add(recipeCategory);
//    }
//
//    public void removeCategory(RecipeCategory recipeCategory){
//        recipeCategories.remove(recipeCategory);
//        this.recipeCategories.remove(recipeCategory);
//    }
//



    public int getRecipeId() {
        return recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public RecipeInstruction getRecipeInstruction() {
        return recipeInstruction;
    }

    public void setRecipeInstruction(RecipeInstruction recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }

    public List<RecipeCategory> getRecipeCategories() {
        return recipeCategories;
    }

    public void setRecipeCategories(List<RecipeCategory> recipeCategories) {
        this.recipeCategories = recipeCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return recipeId == recipe.recipeId &&
                Objects.equals(recipeName, recipe.recipeName) &&
                Objects.equals(recipeIngredients, recipe.recipeIngredients) &&
                Objects.equals(recipeInstruction, recipe.recipeInstruction) &&
                Objects.equals(recipeCategories, recipe.recipeCategories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, recipeName, recipeIngredients, recipeInstruction, recipeCategories);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", recipeName='" + recipeName + '\'' +
                ", recipeIngredients=" + recipeIngredients +
                ", recipeInstruction=" + recipeInstruction +
                ", recipeCategories=" + recipeCategories +
                '}';
    }

    @OneToMany(mappedBy = "recipe")
    private Collection<RecipeIngredient> recipeIngredient;

    public Collection<RecipeIngredient> getRecipeIngredient() {
        return recipeIngredient;
    }

    public void setRecipeIngredient(Collection<RecipeIngredient> recipeIngredient) {
        this.recipeIngredient = recipeIngredient;
    }
}

