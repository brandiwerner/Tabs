package com.brandi.tabs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Brandi Werner on 11/5/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // When updating the structure on the database you will need to change the version
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "events.db";
    public static final String TABLE_NAME = "events_table";

    public static final String COL_1 = "Event_ID";
    public static final String COL_2 = "Event_Name";
    public static final String COL_3 = "Event_Description";
    public static final String COL_4 = "CS_Tag";
    public static final String COL_5 = "CE_Tag";


    /**
     * Constructor
     */
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    /**
     * Creates the Database
     * Runs the very first time we run this
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        /** Takes the querey inside this method as an argument */
        String query = "CREATE TABLE " + TABLE_NAME + "(" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_2 + " TEXT, " + COL_3 + " TEXT, " + COL_4 + " INTEGER, " + COL_5 + " INTEGER" + ");" ;
        db.execSQL(query);
    }

    /**
     * Upgrades the Database when the version is called. Pretty much says drop the old table and create a new one.
     * @param db
     * @param oldVersion
     * @param newVersion
     */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    /**
     * Insert data into the database
     * @param Event_Name is Column 2
     * @param Event_Desc is Column 3
     * @return true or false depending on if the insert succeeded or not
     */
    public boolean addData(String Event_Name, String Event_Desc, int CS_Tag, int CE_Tag) {
        SQLiteDatabase db = this.getReadableDatabase(); //DataBase instance
        // Allows to set different values for different columns and insert in one statement
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, Event_Name); // Arg1: Column name that want to input data, Arg2: Data to be inputed
        contentValues.put(COL_3, Event_Desc);
        contentValues.put(COL_4, CS_Tag);
        contentValues.put(COL_5, CE_Tag);
        long result = db.insert(TABLE_NAME, null, contentValues); // Arg1: Table name, Arg2: null , Arg3: Content variables
        db.close();
        if(result == -1)
            return false;
        else
            return true;
    }

    // Delete a product from the database
    public void deleteColumn(String Event_Name){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("Delete FROM " + TABLE_NAME + " WHERE " + COL_2 + "=\"" + Event_Name + "\";");
    }

    // Print out the database as a string
    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE 1";

        // Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        // Move to first row in your results
        c.moveToFirst();

        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("Event_Name"))!=null){
                dbString += c.getString(c.getColumnIndex("Event_Name"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }


}