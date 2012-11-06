package com.plantplaces;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.plantplaces.dto.Plant;
import com.plantplaces.persistence.IPlantDAO;
import com.plantplaces.persistence.PlantDAOStub;

public class PlantSearchActivity extends PlantPlacesActivity {
	
	IPlantDAO plantDAO;
	private AutoCompleteTextView actPlantName;
	private Button btnPlantSearch;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// associated the plant search layout with this activity.
		setContentView(R.layout.activity_plantsearch);
		
		initializeComponents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		plantDAO = new PlantDAOStub();
		
		try {
			List<String> plantNames = plantDAO.getPlantNames();
			ArrayAdapter<String> plantNamesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, plantNames);
			
			actPlantName = (AutoCompleteTextView) findViewById(R.id.actPlantName);
			
			actPlantName.setAdapter(plantNamesAdapter);
			
			btnPlantSearch = (Button) findViewById(R.id.btnSearchPlants);
			
			btnPlantSearch.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					invokeResults();
				}
			});
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * Invoke the Plant Results screen.
	 */
	protected void invokeResults() {
		// Create the intent.
		Intent plantResultsIntent = new Intent(this, PlantResultsActivity.class);
		
		// create a bundle to pass data to the results screen.
		Bundle data = new Bundle();
		data.putString(PLANT_SEARCH_TERM, actPlantName.getText().toString());
		// add the bundle to the intent
		plantResultsIntent.putExtras(data);
		// start the intent, and tell it we want results.
		startActivityForResult(plantResultsIntent, 	1);
	}
	
	/**
	 * Invoked when the PlantResultScreen is complete, and returns a result to us.
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		// get the plant that was selected.
		Bundle bundle = data.getExtras();
		
		Plant selectedPlant = (Plant) bundle.getSerializable(PlantResultsActivity.PLANT_RESULT);
		
		Toast.makeText(this, "Plant: " + selectedPlant, Toast.LENGTH_LONG).show();
		
	}
}
