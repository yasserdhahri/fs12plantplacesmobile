package com.plantplaces.persistence;

import java.util.List;

/**
 * Interface for fetching plant information.
 * @author jonesbr
 *
 */
public interface IPlantDAO {
	
	public List<String> getPlantNames() throws Exception;

}
