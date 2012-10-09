package com.plantplaces;

import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.plantplaces.dto.Plant;
import com.plantplaces.persistence.IPlantDAO;
import com.plantplaces.persistence.PlantDAOStub;

public class PlantResultsActivity extends ListActivity {
	
	// declare our DAO.
	IPlantDAO plantDAO;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		// initialize our DAO to the stub, for the moment.
		plantDAO = new PlantDAOStub();
		
		List<Plant> allPlants;
		try {
			// search for plants that meet criteria.
			allPlants = plantDAO.fetchPlantsByGenus("Foo");
		
			// pass the list of plants that meet the criteria to the ArrayAdapter.
			ArrayAdapter plantAdapter = new ArrayAdapter<Plant>(this, android.R.layout.simple_list_item_1, allPlants);
			
			// tell this screen what we want to show.
			setListAdapter(plantAdapter);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
		}
		
	}
	
	/**
	 * This method is invoked when a list item is clicked.
	 */
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		// call back to the screen that called us.
		// get a reference to the intent that invoked us.
		Intent intent = this.getIntent();
		this.setResult(RESULT_OK, intent);
		finish();
	}

}
