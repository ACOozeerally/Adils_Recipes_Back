package com.ACO.AdilsRecipes.repository;

import java.util.List;

public interface RecipesRepository {
	
	String getAllRecipes();

	String createRecipe(String recipe);

	String deleteRecipe(Long recipeID);

	String getRecipe(Long recipeID);

	String updateRecipe(Long id, String recipe);
	
	String getRating(Long ratingID);
	
	String createRating(String rating);
	
	String deleteRating(Long ratingID);
	
	String getRecipeRating(Long recipeID);
	
	

}
