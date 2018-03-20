package com.example.divya.sqlitetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by divya on 19/01/2018.
 */

public class MyDbHandler extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "DETAILS";

    // Table columns
    public static final String _ID = "_id";
    public static final String COMPANY = "company";
    public static final String PLACE = "place";

    // Database Information
    static final String DB_NAME = "DETAILS.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COMPANY + " TEXT NOT NULL, " + PLACE + " TEXT);";

    public MyDbHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
