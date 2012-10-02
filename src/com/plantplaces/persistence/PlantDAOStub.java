package com.plantplaces.persistence;

import java.util.ArrayList;
import java.util.List;

public class PlantDAOStub implements IPlantDAO {

	public List<String> getPlantNames() throws Exception {
		ArrayList<String> allPlantNames = new ArrayList<String>();
		
		allPlantNames.add("Abelia mosanensis Fragrant Abelia");	
		allPlantNames.add("Abelia x grandiflora Glossy Abelia");
		allPlantNames.add("Abies concolor White Fir");
		allPlantNames.add("Abies cilicica Cilician Fir");

		return allPlantNames;
	}

}
