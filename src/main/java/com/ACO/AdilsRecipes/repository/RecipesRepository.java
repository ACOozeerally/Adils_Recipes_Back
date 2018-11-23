package com.ACO.AdilsRecipes.repository;

import java.util.List;

public interface RecipesRepository {
	
	String getAllRecipes();

	String createRecipe(String classroom);

	String deleteRecipe(Long classroomID);

	String getRecipe(Long classroomID);

	String updateRecipe(Long id, String classroom);
	
	String getRating(Long ratingID);
	
	String createRating(String rating);
	
	String deleteRating(Long id);
	
	

}
