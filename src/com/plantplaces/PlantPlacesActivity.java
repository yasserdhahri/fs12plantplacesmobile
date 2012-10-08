package com.plantplaces;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class PlantPlacesActivity extends Activity {

	static final int SEARCH_PLANTS_MENU = 1;

	public PlantPlacesActivity() {
		super();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    getMenuInflater().inflate(R.menu.activity_location, menu);
	    
	    menu.add(Menu.NONE, SEARCH_PLANTS_MENU, Menu.NONE, getString(R.string.mnuSearchPlants) );
	    
	    return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		super.onOptionsItemSelected(item);
		
		int itemId = item.getItemId();
		
		if (itemId == SEARCH_PLANTS_MENU) {
			// bring up the Search Plants Screen.
			Intent searchPlantsIntent = new Intent(this, PlantSearchActivity.class);
			startActivity(searchPlantsIntent);
		}
		
		return true;
		
		
	}

}