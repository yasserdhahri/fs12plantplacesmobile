package com.plantplaces.persistence;

import java.util.ArrayList;

/**
 * Interactions with sites
 * 
 * @author jonesbr
 *
 */
public interface ISiteDAO {
	
	/**
	 * Fetch all sites that can be associated with specimens of plants.
	 * 
	 * @return an ArrayList of all sites.
	 */
	public ArrayList<String> fetchAllSites();

}
