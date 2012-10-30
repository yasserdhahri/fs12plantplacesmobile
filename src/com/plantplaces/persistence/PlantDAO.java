package com.plantplaces.persistence;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.plantplaces.dto.Plant;

public class PlantDAO extends SQLiteOpenHelper implements IPlantDAO {

	
	private static final String SQL_ID = "_id";
	private static final String PLANTS = "plants";
	private static final String MAX_HEIGHT = "maxHeight";
	private static final String COMMON = "common";
	private static final String CULTIVAR = "cultivar";
	private static final String SPECIES = "species";
	private static final String GENUS = "genus";
	private static final String PLANT_ID = "plantId";
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "plantplaces";
	private final String CLASS_NAME = getClass().getName();
	
	public PlantDAO(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// CREATE TABLE statement.
		String createPlantsStatement = "CREATE TABLE "+PLANTS+" ("+SQL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + PLANT_ID + " INTEGER DEFAULT 0, " + GENUS + " TEXT NOT NULL, "+SPECIES+" TEXT, "+CULTIVAR+" TEXT, "+COMMON+" TEXT, "+MAX_HEIGHT+" INTEGER DEFAULT 0);";
		
		Log.d(CLASS_NAME, createPlantsStatement);
		
		db.execSQL(createPlantsStatement);
	}
	
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	public List<String> getPlantNames() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Plant> fetchPlantsByGenus(String genus) throws Exception {
		// create a return value.
		List<Plant> allPlants = new ArrayList<Plant>();
		
		// the SQL to retrieve plants from our database.
		String selectSQL = "SELECT * FROM " + PLANTS + " WHERE " + GENUS + " LIKE '%" + genus  + "%'";
		
		Log.d(CLASS_NAME, selectSQL);
		
		// get a cursor, which is like a ResultSet.  It allows us to iterate over results.
		Cursor cursor = getReadableDatabase().rawQuery(selectSQL, null);
		
		// iterate over results.
		if (cursor.getCount() > 0) {
			Log.i(CLASS_NAME, cursor.getCount() + " results returned");
			// move the cursor to the very first result.
			cursor.moveToFirst();
			
			// iterate over our results.  Keep iterating as long as we're not after the last row.
			while(!cursor.isAfterLast()) {
				// make a new plant.
				Plant thisPlant = new Plant();
				
				// populate
				thisPlant.setSqlId(cursor.getLong(0));
				thisPlant.setGenus(cursor.getString(1));
				thisPlant.setSpecies(cursor.getString(2));
				thisPlant.setCultivar(cursor.getString(3));
				thisPlant.setCommon(cursor.getString(4));
				thisPlant.setMaxHeight(cursor.getInt(5));
				
				// add to the collection.
				allPlants.add(thisPlant);
				
				// move the cursor to the next location.
				cursor.moveToNext();
				
			}
			// close the cursor.
			cursor.close();
			
		} else {
			Log.i(CLASS_NAME, "No results returned");			
		}
		
		return allPlants;
	}

	public void save(Plant plant) throws Exception {
		// Create a ContentValues, which is like a HashMap for data that we want to store in the database.
		ContentValues values = new ContentValues();
		values.put(PLANT_ID, plant.getPlantId());
		values.put(GENUS, plant.getGenus());
		values.put(SPECIES, plant.getSpecies());
		values.put(CULTIVAR, plant.getCultivar());
		values.put(COMMON, plant.getCommon());
		values.put(MAX_HEIGHT, plant.getMaxHeight());
		
		// store it in the database
		long sqlId = getWritableDatabase().insert(PLANTS, GENUS, values);
		
		// now, update the plant with the SQL ID.
		plant.setSqlId(sqlId);
		
	}
	
	public void update(Plant plant) throws Exception {
		// Create a ContentValues, which is like a HashMap for data that we want to store in the database.
		ContentValues values = new ContentValues();
		values.put(PLANT_ID, plant.getPlantId());
		values.put(GENUS, plant.getGenus());
		values.put(SPECIES, plant.getSpecies());
		values.put(CULTIVAR, plant.getCultivar());
		values.put(COMMON, plant.getCommon());
		values.put(MAX_HEIGHT, plant.getMaxHeight());
		
		// store it in the database
		long sqlId = getWritableDatabase().update(PLANTS, values, SQL_ID + "=" + plant.getSqlId(), null);
		
	}

}
