package com.plantplaces;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.plantplaces.persistence.ISiteDAO;
import com.plantplaces.persistence.SiteDAOStub;

/**
 * This is the user interface logic for finding plant locations.
 * 
 * @author jonesbr
 *
 */
public class LocationActivity extends Activity {

    private Button btnSaveLocation;
	private EditText edtDescription;
	private Button btnUpload;
	private Spinner spnSite;
	private ISiteDAO siteDAO;
	

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        initComponents();
    }

    private void initComponents() {
    	// initialize the siteDAO
    	siteDAO = new SiteDAOStub();
    	
    	
    	btnSaveLocation = (Button) findViewById(R.id.btnSaveLocation);
    	edtDescription = (EditText) findViewById(R.id.edtDescription);
    	btnUpload = (Button) findViewById(R.id.btnUpload);
    	    	
    	// instantiate our listener.
    	SaveLocationListener saveLocationListener = new SaveLocationListener();
    	
    	// set an inner class listener
    	btnSaveLocation.setOnClickListener(saveLocationListener);
    	
     	
    	btnUpload.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				popup("You clicked Upload");
			}
		});
    	
    	// access the spinner
    	spnSite = (Spinner) findViewById(R.id.spnSite);
    	
    	ArrayList<String> allSites = siteDAO.fetchAllSites();
    
    	ArrayAdapter<String> siteAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, allSites);
    	
    	// wire up an adapter that will provide values to this spinner.
    	spnSite.setAdapter(siteAdapter);
    	
    	
    }
            
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_location, menu);
        return true;
    }	
    

    /**
     * A general method to show a popup message.
     * @param message the text that you want to show.
     */
    protected void popup(String message) {
    	// this is how we make a popup.
    	Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
    
    class SaveLocationListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			popup("You rang?");

		}
    	
    }
}
