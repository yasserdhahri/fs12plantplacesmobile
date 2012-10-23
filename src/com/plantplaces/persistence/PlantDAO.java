package com.plantplaces.persistence;

import java.util.List;

import com.plantplaces.dto.Plant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PlantDAO extends SQLiteOpenHelper implements IPlantDAO {

	
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "plantplaces";

	public PlantDAO(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Plant plant) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
