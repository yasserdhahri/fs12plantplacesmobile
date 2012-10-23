package com.plantplaces.persistence;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.plantplaces.dto.Plant;

public class PlantDAOStub implements IPlantDAO {

	public List<String> getPlantNames() throws Exception {
		Log.i(getClass().getName(), "Entering getPlantNames in stub");
		ArrayList<String> allPlantNames = new ArrayList<String>();
		
		allPlantNames.add("Abelia mosanensis Fragrant Abelia");	
		allPlantNames.add("Abelia x grandiflora Glossy Abelia");
		allPlantNames.add("Abies concolor White Fir");
		allPlantNames.add("Abies cilicica Cilician Fir");

		return allPlantNames;
	}

	public List<Plant> fetchPlantsByGenus(String genus) throws Exception {
		// declare our return type.
		ArrayList<Plant> allPlants = new ArrayList<Plant>();
		
		// create some dummy plants.
		Plant pawpaw = new Plant();
		pawpaw.setGenus("Asimina");
		pawpaw.setSpecies("Triloba");
		pawpaw.setCommon("Pawpaw");
		
		allPlants.add(pawpaw);
		
		Plant redbud = new Plant();
		redbud.setGenus("Cercis");
		redbud.setSpecies("canadensis");
		redbud.setCommon("Redbud");
		
		allPlants.add(redbud);
		
		// return results.
		return allPlants;
		
	}

	public void save(Plant plant) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
