package com.ACO.AdilsRecipes.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ratings {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long ratingID;
	@Column
	private String comment;
	@Column(length = 100)
	private Long outOfFive;
	@Column(name = "recipe_ID")
	
	private Long recipeID;

	public Long getRecipeID() {
		return recipeID;
	}

	public void setRecipeID(Long recipeID) {
		this.recipeID = recipeID;
	}

	public Ratings() {

	}

	public Long getRatingID() {
		return ratingID;
	}

	public void setTraineeID(Long ratingID) {
		this.ratingID = ratingID;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getOutOfFive() {
		return outOfFive;
	}

	public void setOutOfFive(Long outOfFive) {
		this.outOfFive = outOfFive;
	}

}
