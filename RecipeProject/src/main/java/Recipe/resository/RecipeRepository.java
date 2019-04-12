package Recipe.resository;

public interface RecipeRepository {
	
	String createRecipe(String name, String owner, String description);
	
	String getAllRecipes();
	String getRecipe(long id);
	
	String deleteRecipe(long id);
	

}
