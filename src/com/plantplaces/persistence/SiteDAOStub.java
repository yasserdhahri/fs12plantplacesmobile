package com.plantplaces.persistence;

import java.util.ArrayList;

/**
 * A stub that simulates persistence for sites
 * @author jonesbr
 *
 */
public class SiteDAOStub implements ISiteDAO {

	@Override
	public ArrayList<String> fetchAllSites() {
		// declare the return collection.
		ArrayList<String> allSites = new ArrayList<String>();
		
		// populate the return collection.
		allSites.add("Moscow, Ohio");
		allSites.add("CUBG");
		allSites.add("Cincinnati Zoo and Botanic Garden");
		allSites.add("Spring Grove Cemetery");
		
		// return the return collection.
		return allSites;
	
	}

}
