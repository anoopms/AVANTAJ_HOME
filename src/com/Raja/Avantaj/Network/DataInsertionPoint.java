package com.Raja.Avantaj.Network;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

public class DataInsertionPoint {
	
	private SQLiteDatabase sqliteDatabase;
	private DataBase1 dataBase1;
	private String[] allcolumns = {DataBase1.COLUMN_TECHNOLOGY, DataBase1.COLUMN_TECHNOLOGYDETAILS};
	
	public DataInsertionPoint(Context context)
	{
		dataBase1 = new DataBase1(context);
	}
	
	public void open() throws SQLiteException
	{
		sqliteDatabase = dataBase1.getWritableDatabase();
	}
	
	public void close()
	{
		sqliteDatabase.close();
	}
	
	protected void DataInsertionMethod(String Technology, String TechnologyDetail)
	{
	
		Log.d("technology", Technology);
		Log.d("technologydetail", TechnologyDetail);
		ContentValues currentinsertion = new ContentValues();
		currentinsertion.put(DataBase1.COLUMN_TECHNOLOGY, Technology);
		currentinsertion.put(DataBase1.COLUMN_TECHNOLOGYDETAILS, TechnologyDetail);
		sqliteDatabase.insert(DataBase1.TABLE_SAFE, null, currentinsertion);
		
		
		//cursor.moveToFirst();
		
		
	}
	
	public Cursor getCursor()
	{
		Cursor cursor = sqliteDatabase.query(DataBase1.TABLE_SAFE, allcolumns, null, null, null, null, null);
		return cursor;
	}
	
	

}
