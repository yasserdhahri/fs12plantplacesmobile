package com.plantplaces;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.plantplaces.persistence.IPlantDAO;
import com.plantplaces.persistence.PlantDAOStub;

public class PlantSearchActivity extends Activity {
	
	IPlantDAO plantDAO;
	private AutoCompleteTextView actPlantName;
	
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
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
