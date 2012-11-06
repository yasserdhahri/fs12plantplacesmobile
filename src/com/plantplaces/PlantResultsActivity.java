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
import com.plantplaces.persistence.PlantDAO;

public class PlantResultsActivity extends ListActivity {
	
	public static final String PLANT_RESULT = "plantResult";
	// declare our DAO.
	IPlantDAO plantDAO;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		// initialize our DAO to the stub, for the moment.
		plantDAO = new PlantDAO(this);
		
		List<Plant> allPlants;
		try {
			// get the bundle from this intent.
			Bundle data = getIntent().getExtras();
			// get the search term from the bund.e
			String searchTerm = data.getString(PlantPlacesActivity.PLANT_SEARCH_TERM);
			
			// search for plants that meet criteria.
			allPlants = plantDAO.fetchPlantsByGenus(searchTerm);
		
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
		
		// find out what we clicked.
		Plant selectedPlant = (Plant) getListAdapter().getItem(position);
		
		// call back to the screen that called us.
		// get a reference to the intent that invoked us.
		Intent intent = this.getIntent();
		
		// create a bundle for return data.
		Bundle data = new Bundle();
		// place our result data in this bundle.
		data.putSerializable(PLANT_RESULT, selectedPlant);
		
		// associate the bundle with the intent.
		intent.putExtras(data);
		// set the result, and finish, to go back to the calling screen.
		this.setResult(RESULT_OK, intent);
		finish();
	}

}
