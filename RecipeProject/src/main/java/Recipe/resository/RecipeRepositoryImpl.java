package Recipe.resository;

import static javax.transaction.Transactional.TxType.REQUIRED;


import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

// import com.qa.business.service.MovieService;
import Recipe.RecipeProject.Recipe;
import Recipe.util.JSONUtil.JSONUtil;  

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;


@Transactional(SUPPORTS)
@Default
public class RecipeRepositoryImpl implements RecipeRepository{
	
	@PersistenceContext(unitName= "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	
	@Transactional(REQUIRED)
	public String createRecipe(String name, String owner, String description) {
		Recipe recipe = util.getObjectForJSON(name, Recipe.class  );
		manager.persist(recipe);
		return "{\"message\": \"recipe has been added\"}";
	}

	public String getAllRecipes() {
		Query query = manager.createQuery("Select r FROM Recipe r");
		Collection<Recipe> recipes = (Collection<Recipe>) query.getResultList();
		return util.getJSONForObject(recipes);
	}

	public String getRecipe(long id) {
		
		return util.getJSONForObject(manager.find(Recipe.class, id));
	}
	
	
	@Transactional(REQUIRED)
	public String deleteRecipe(long id) {
		Recipe recipe = util.getObjectForJSON(getRecipe(id), Recipe.class);
		if (manager.contains(manager.find(Recipe.class, id))) {
			manager.remove(manager.find(Recipe.class, id));
		}
		return "{\"message\": \"Recipe deleted\"}";
	}
	
	
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
