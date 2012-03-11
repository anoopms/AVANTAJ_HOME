package com.Raja.Avantaj.Network;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase1 extends SQLiteOpenHelper {
	
	public static final String COLUMN_ID = "_id";
	private static final String DATABASE_NAME = "Data";
	private static final int DATABASE_VERSION = 1;
	public static final String COLUMN_TECHNOLOGY = "Technology";
	public static final String COLUMN_TECHNOLOGYDETAILS = "TechnologyDetails";
	public static final String TABLE_SAFE = "Safe";
	private static final String DATABASE_CREATE = "create table "+ TABLE_SAFE + "( "+ COLUMN_ID +" integer primary key autoincrement, "+ COLUMN_TECHNOLOGY +" text not null, " + COLUMN_TECHNOLOGYDETAILS + " text not null );"; 
	
	public DataBase1(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(DATABASE_CREATE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}

