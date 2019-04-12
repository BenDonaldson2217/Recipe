package RecipeCRUD;

import javax.inject.Inject;

import org.apache.log4j.Logger;


import Recipe.resository.RecipeRepository;



public class RecipeCRUDImpl implements RecipeCRUD{
	
	@Inject
	private RecipeRepository repo;
	

	public String addRecipe(String name, String owner, String description) {
		if (name.contains("bacon")) {
			return "Can't add this recipe";
		}
		return repo.createRecipe(name, owner, description);
	}

	public String getAllRecipes() {
		return repo.getAllRecipes();
	}

	public String getRecipe(long id) {
		
		return repo.getRecipe(id);
	}

	public String deleteRecipe(long id) {
		
		return repo.deleteRecipe(id);
	}
	
	public void setRepo(RecipeRepository repo) {
		this.repo =repo;
	}

}
