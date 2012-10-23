package com.plantplaces;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class PlantPlacesActivity extends Activity {

	private static final int ADD_PLANT_MENU = 3;
	public static final int LOCATION_MENU = 2;
	public static final int SEARCH_PLANTS_MENU = 1;

	public PlantPlacesActivity() {
		super();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    getMenuInflater().inflate(R.menu.activity_location, menu);
	    
	    menu.add(Menu.NONE, SEARCH_PLANTS_MENU, Menu.NONE, getString(R.string.mnuSearchPlants) );

	    menu.add(Menu.NONE, LOCATION_MENU, Menu.NONE, getString(R.string.mnuLocation));
	    
	    menu.add(Menu.NONE, ADD_PLANT_MENU, Menu.NONE, getString(R.string.lblAddPlant));
	    
	    return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		super.onOptionsItemSelected(item);
		
		switch (item.getItemId()) {
		case LOCATION_MENU:
			location();
			break;
		case SEARCH_PLANTS_MENU:
			searchPlants();
			break;
		case ADD_PLANT_MENU:
			addPlants();
			break;
		default:
			// this is what happens if there is not a case that matches item.getItemId().
		}
		
		return true;
		
		
	}

	private void addPlants() {
		// TODO Auto-generated method stub
		Intent addPlantIntent = new Intent(this, PlantAddActivity.class);
		startActivity(addPlantIntent);
	}

	/**
	 * Bring up the location screen.
	 */
	private void location() {
		// TODO Auto-generated method stub
		Intent locationIntent = new Intent(this, LocationActivity.class);
		startActivity(locationIntent);
	}
	
	/**
	 * Bring up the search plants screen.
	 */
	private void searchPlants() {
		// bring up the Search Plants Screen.
		Intent searchPlantsIntent = new Intent(this, PlantSearchActivity.class);
		startActivity(searchPlantsIntent);
	}

}