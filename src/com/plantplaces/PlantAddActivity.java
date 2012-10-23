package com.plantplaces;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.plantplaces.dto.Plant;
import com.plantplaces.persistence.IPlantDAO;
import com.plantplaces.persistence.PlantDAO;

/**
 * Activity to faciliate adding a plant.
 * @author jonesbr
 *
 */
public class PlantAddActivity extends PlantPlacesActivity {

	private Button btnSavePlant;
	private EditText edtGenus;
	private EditText edtSpecies;
	private EditText edtCommon;
	private EditText edtCultivar;
	private EditText edtHeight;
	
	private IPlantDAO plantDAO;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addplant);
		
		init();
	}

	private void init() {
		// Get a reference to everything on the screen so that we can persist this information
		edtGenus = (EditText) findViewById(R.id.edtGenus);
		edtSpecies = (EditText) findViewById(R.id.edtSpecies);
		edtCommon = (EditText) findViewById(R.id.edtCommon);
		edtCultivar = (EditText) findViewById(R.id.edtCultivar);
		edtHeight = (EditText)	findViewById(R.id.edtHeight);
		
		
		btnSavePlant = (Button) findViewById(R.id.btnSavePlant);
		
		// add a listener.
		btnSavePlant.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// Save this plant to the persistence layer.
				savePlant();
			}
		});
		
		plantDAO = new PlantDAO(this);
		
	}

	/**
	 * Collect data that the user entered, turn it into a plant, and save it.
	 */
	protected void savePlant() {
		Log.i(getClass().getName(), "Saving plant");
		// make a Plant object that is populated with these values.
		Plant plant = new Plant();
		plant.setGenus(edtGenus.getText().toString());
		plant.setSpecies(edtSpecies.getText().toString());
		plant.setCultivar(edtCultivar.getText().toString());
		plant.setCommon(edtCommon.getText().toString());
		plant.setMaxHeight(Integer.parseInt(edtHeight.getText().toString()));
		
		try {
			plantDAO.save(plant);
		} catch (Exception e) {
			Log.e(getClass().getName(), "Error saving plant: " + e.getMessage());
			Toast.makeText(this, "Error saving plant: " + e.getMessage(), Toast.LENGTH_LONG).show();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Log.i(getClass().getName(), "Saved Plant: " + plant);
		
	}
	
}
