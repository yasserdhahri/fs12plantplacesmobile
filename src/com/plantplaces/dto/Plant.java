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
	// The PlantPlaces.com UID
	int plantId;
	// The SQLite primary key
	long sqlId;
	
	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}

	public long getSqlId() {
		return sqlId;
	}

	public void setSqlId(long sqlId) {
		this.sqlId = sqlId;
	}

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
