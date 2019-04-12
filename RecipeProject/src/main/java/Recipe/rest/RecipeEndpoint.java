package Recipe.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;


import RecipeCRUD.RecipeCRUD;

@Path("/movie")
public class RecipeEndpoint {
	
	
	@Inject
	private RecipeCRUD crud;
	
	@Path("/getAllRecipes")
	@GET
	@Produces({"application/json"})
	public String getAllRecipes() {
		return crud.getAllRecipes();
	}
	
	
	@Path("/getRecipe/{id}")
	@GET
	@Produces({"application/json"})
	public String getRecipe(@PathParam("id") Long id) {
		return crud.getRecipe(id);
	}
	
	@Path("/createRecipe")
	@POST
	@Produces({"application/json"})
	public String addRecipe(String name, String owner, String description) {
		return crud.addRecipe(name, owner, description);
	}
	
	
	@Path("/deleteRecipes/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteRecipe(@PathParam("id") Long id) {
		return crud.deleteRecipe(id);
	}
	
	public void setService(RecipeCRUD crud) {
		this.crud = crud;
	}

	
}
