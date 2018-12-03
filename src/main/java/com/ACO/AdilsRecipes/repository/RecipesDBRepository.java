package com.ACO.AdilsRecipes.repository;

import static javax.transaction.Transactional.TxType.*;

import java.util.Collection;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.ACO.AdilsRecipes.Util.JSONUtil;
import com.ACO.AdilsRecipes.domain.Ratings;
import com.ACO.AdilsRecipes.domain.Recipes;

@Transactional(SUPPORTS)
@Default
public class RecipesDBRepository implements RecipesRepository {

	@Inject
	private JSONUtil util;

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	public String getAllRecipes() {
		Query query = manager.createQuery("Select a FROM Recipes a");
		Collection<Recipes> recipes = (Collection<Recipes>) query.getResultList();
		return util.getJSONForObject(recipes);
	}

	@Transactional(REQUIRED)
	public String createRecipe(String recipe) {
		Recipes aRecipe = util.getObjectForJSON(recipe, Recipes.class);
		manager.merge(aRecipe);
		return "{\"message\": \"classroom sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String updateRecipe(Long id, String classroom) {
		Recipes aRecipe = util.getObjectForJSON(classroom, Recipes.class);
		// Classroom aClassroom = new Classroom(id, trainer, trainees);
		Recipes recipeInDB = findRecipe(id);
		recipeInDB.setAuthor(aRecipe.getAuthor());
		recipeInDB.setCuisine(aRecipe.getCuisine());
		recipeInDB.setIngredients(aRecipe.getIngredients());
		recipeInDB.setRecipeName(aRecipe.getRecipeName());
		return "{\"message\": \"Account has been sucessfully updated\"}";
	}

	@Transactional(REQUIRED)
	public String deleteRecipe(Long id) {
		Recipes recipeInDB = findRecipe(id);
		if (recipeInDB != null) {
			manager.remove(recipeInDB);
		}
		return "{\"message\": \"classroom sucessfully deleted\"}";
	}

	private Recipes findRecipe(Long id) {
		return manager.find(Recipes.class, id);
	}

	public String getRecipe(Long id) {
		Recipes aRecipe = manager.find(Recipes.class, id);
		return util.getJSONForObject(aRecipe);
	}

	public String getRating(Long ratingID) {
		Ratings aRating = manager.find(Ratings.class, ratingID);
		return util.getJSONForObject(aRating);
	}

	@Transactional(REQUIRED)
	public String createRating(String rating) {
		Ratings aRating = util.getObjectForJSON(rating, Ratings.class);
		manager.merge(aRating);
		return rating;
	}

	@Transactional(REQUIRED)
	public String deleteRating(Long id) {
		Ratings ratingInDB = findRating(id);
		if (ratingInDB != null) {
			manager.remove(ratingInDB);
		}
		return "{\"message\": \"classroom sucessfully deleted\"}";
	}

	private Ratings findRating(Long id) {
		return manager.find(Ratings.class, id);
	}

	@Override
	public String getRecipeRating(Long recipeID) {
		Query query = manager.createQuery("Select a FROM Ratings a where a.recipeID = " + recipeID);
		Collection<Ratings> ratings = (Collection<Ratings>) query.getResultList();
		return util.getJSONForObject(ratings);
	}

}