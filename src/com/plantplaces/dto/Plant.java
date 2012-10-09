package com.plantplaces.dto;

/**
 * DTO for a plant.
 * 
 * @author jonesbr
 *
 */
public class Plant {
	
	String genus;
	String species;
	String cultivar;
	String common;
	int maxHeight;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return genus +  " " + species + " " + common;
	}
	
	public String getGenus() {
		return genus;
	}
	public void setGenus(String genus) {
		this.genus = genus;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getCultivar() {
		return cultivar;
	}
	public void setCultivar(String cultivar) {
		this.cultivar = cultivar;
	}
	public String getCommon() {
		return common;
	}
	public void setCommon(String common) {
		this.common = common;
	}
	public int getMaxHeight() {
		return maxHeight;
	}
	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}
	public int getMinHeight() {
		return minHeight;
	}
	public void setMinHeight(int minHeight) {
		this.minHeight = minHeight;
	}
	public int getRecommended() {
		return recommended;
	}
	public void setRecommended(int recommended) {
		this.recommended = recommended;
	}
	int minHeight;
	int recommended;
	
	

}
