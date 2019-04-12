package RecipeCRUD;

public interface RecipeCRUD {
	
	String addRecipe(String name, String owner, String description);
	
	String getAllRecipes();
	String getRecipe(long id);
	
	String deleteRecipe(long id);

}
