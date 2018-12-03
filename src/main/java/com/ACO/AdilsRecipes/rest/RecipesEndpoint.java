package com.ACO.AdilsRecipes.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.ACO.AdilsRecipes.repository.RecipesRepository;


@Path("/recipes")
public class RecipesEndpoint {

	@Inject
	private RecipesRepository recipesRepo;

	@Path("/getAllRecipes")
	@GET
	@Produces({ "application/json" })
	public String getAllRecipes() {
		return recipesRepo.getAllRecipes();
	}

	@Path("/getRecipe/{id}")
	@GET
	@Produces({ "application/json" })
	public String getRecipe(@PathParam("id") Long recipeID) {
		return recipesRepo.getRecipe(recipeID);
	}

	@Path("/createRecipe")
	@POST
	@Produces({ "application/json" })
	public String createRecipe(String recipe) {
		return recipesRepo.createRecipe(recipe);
	}

	@Path("/updateRecipe/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateRecipe(@PathParam("id") Long recipeID, String recipe){
		{
			return recipesRepo.updateRecipe(recipeID, recipe);
		}
	}

	@Path("/deleteRecipe/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteClassroom(@PathParam("id") Long recipeID) {
		return recipesRepo.deleteRecipe(recipeID);
	}

	public void setService(RecipesRepository recipesRepo) {
		this.recipesRepo = recipesRepo;
	}
	
	@Path("/getRating/{id}")
	@GET
	@Produces({ "application/json" })
	public String getRating(@PathParam("id") Long ratingID) {
		return recipesRepo.getRating(ratingID);
	}
	
	@Path("/getRecipeRatings/{id}")
	@GET
	@Produces({ "application/json" })
	public String getRecipeRating(@PathParam("id") Long recipeID) {
		return recipesRepo.getRecipeRating(recipeID);
	}
	
	@Path("/createRating")
	@POST
	@Produces({ "application/json" })
	public String createaRating(String ratingID) {
		return recipesRepo.createRating(ratingID);
	}
	
	@Path("/deleteRating/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteRating(@PathParam("id") Long ratingID) {
		return recipesRepo.deleteRating(ratingID);
	}

}