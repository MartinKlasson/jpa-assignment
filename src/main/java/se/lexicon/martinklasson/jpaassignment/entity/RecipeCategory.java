package se.lexicon.martinklasson.jpaassignment.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class RecipeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String recipeCategory;

    @ManyToMany(fetch = FetchType.LAZY,
                cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable()//(name = "recipe_category_category_recipes",
            //joinColumns = @JoinColumn(name = "recipe_category_category_id"),
            //inverseJoinColumns = @JoinColumn(name="category_recipes_recipe_id"))
    private List<Recipe> categoryRecipes;

    public RecipeCategory() {
    }

    public RecipeCategory(String recipeCategory) {
        this.recipeCategory = recipeCategory;
    }

    public RecipeCategory(String recipeCategory, List<Recipe> categoryRecipes) {
        this.recipeCategory = recipeCategory;
        this.categoryRecipes = categoryRecipes;
    }

    //!!!!Convenience methods Add Remove!!!!



    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getRecipeCategory() {
        return recipeCategory;
    }

    public void setRecipeCategory(String recipeCategory) {
        this.recipeCategory = recipeCategory;
    }

    public List<Recipe> getCategoryRecipes() {
        return categoryRecipes;
    }

    public void setCategoryRecipes(List<Recipe> categoryRecipes) {
        this.categoryRecipes = categoryRecipes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeCategory that = (RecipeCategory) o;
        return categoryId == that.categoryId &&
                Objects.equals(recipeCategory, that.recipeCategory) &&
                Objects.equals(categoryRecipes, that.categoryRecipes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, recipeCategory, categoryRecipes);
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "categoryId=" + categoryId +
                ", recipeCategory='" + recipeCategory + '\'' +
                ", categoryRecipes=" + categoryRecipes +
                '}';
    }
}
