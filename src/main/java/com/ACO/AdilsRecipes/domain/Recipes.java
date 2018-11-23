package com.ACO.AdilsRecipes.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.ACO.AdilsRecipes.domain.Ratings;

@Entity
public class Recipes {
	public Recipes() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recipe_ID")
	private Long recipeID;
	private String recipeName;
	private String ingredients;
	private String cuisine;
	private String author;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "recipe_ID")
	private List<Ratings> ratingsList;


	public Recipes(Long recipeID, String recipeName, String ingredients, String cuisine, String author,
			List<Ratings> ratingsList) {
		this.recipeID = recipeID;
		this.recipeName = recipeName;
		this.ingredients = ingredients;
		this.cuisine = cuisine;
		this.author = author;
		this.ratingsList = ratingsList;
	}

	public Long getRecipeID() {
		return recipeID;
	}

	public void setRecipeID(Long recipeID) {
		this.recipeID = recipeID;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<Ratings> getRatings() {
		return ratingsList;
	}

	public void setRatings(List<Ratings> ratingsList) {
		this.ratingsList = ratingsList;
	}

}
