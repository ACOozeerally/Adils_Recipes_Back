package com.ACO.AdilsRecipes;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ACO.AdilsRecipes.Util.JSONUtil;
import com.ACO.AdilsRecipes.domain.Ratings;
import com.ACO.AdilsRecipes.domain.Recipes;
import com.ACO.AdilsRecipes.repository.RecipesDBRepository;
import com.ACO.AdilsRecipes.rest.RecipesEndpoint;

public class MockitoTests {

	private Ratings ratings;
	private Recipes recipes;
	private RecipesDBRepository recipeDBrepo;
	private RecipesEndpoint recipeEP;
	private JSONUtil json;

	@Before
	public void init() {
		ratings = Mockito.mock(Ratings.class);
		recipes = Mockito.mock(Recipes.class);
		recipeDBrepo = Mockito.mock(RecipesDBRepository.class);
		recipeEP = Mockito.mock(RecipesEndpoint.class);
		json = Mockito.mock(JSONUtil.class);

	}

	@Test
	public void ratingsClassCommentTest() {

		ratings.setComment("Test Comment");

		when(ratings.getComment()).thenReturn("Test Comment");

		assertEquals("Test Comment", ratings.getComment());

	}

	@Test
	public void createRecipe() {
		Recipes aRecipe = new Recipes();
		aRecipe.setAuthor("Test");
		aRecipe.setCuisine("Test");
		aRecipe.setIngredients("Test");
		aRecipe.setRecipeName("Test");
		aRecipe.setRatings(null);

		String recipe = json.getJSONForObject(aRecipe);

		recipeDBrepo.createRecipe(recipe);

		assertEquals("Test", aRecipe.getAuthor());
		assertEquals("Test", aRecipe.getCuisine());
		assertEquals("Test", aRecipe.getIngredients());
		assertEquals("Test", aRecipe.getRecipeName());
		assertEquals(null, aRecipe.getRatings());

	}

}