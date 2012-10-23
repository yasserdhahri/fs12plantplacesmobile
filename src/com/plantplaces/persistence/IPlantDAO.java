package com.plantplaces.persistence;

import java.util.List;

import com.plantplaces.dto.Plant;

/**
 * Interface for fetching plant information.
 * @author jonesbr
 *
 */
public interface IPlantDAO {
	
	public List<String> getPlantNames() throws Exception;
	
	public List<Plant> fetchPlantsByGenus(String genus) throws Exception;

	/**
	 * Persist the plant.
	 * 
	 * @param plant the plant to save.
	 * @throws Exception
	 */
	public void save(Plant plant) throws Exception;
}
