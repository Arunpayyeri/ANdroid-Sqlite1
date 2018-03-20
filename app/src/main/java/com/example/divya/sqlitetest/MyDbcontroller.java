package com.example.divya.sqlitetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by divya on 19/01/2018.
 */

public class MyDbcontroller {

    private MyDbHandler dbHandler;

    private Context context;

    private SQLiteDatabase database;

    public MyDbcontroller(Context c) {
        context = c;
    }

    public MyDbcontroller open() throws SQLException {
        dbHandler = new MyDbHandler(context);
        database = dbHandler.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHandler.close();
    }

    public void insert(String name, String place) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(MyDbHandler.COMPANY, name);
        contentValue.put(MyDbHandler.PLACE, place);
        database.insert(MyDbHandler.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] { MyDbHandler._ID, MyDbHandler.COMPANY, MyDbHandler.PLACE };
        Cursor cursor = database.query(MyDbHandler.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String name, String place) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDbHandler.COMPANY, name);
        contentValues.put(MyDbHandler.PLACE, place);
        int i = database.update(MyDbHandler.TABLE_NAME, contentValues, MyDbHandler._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(MyDbHandler.TABLE_NAME, MyDbHandler._ID + "=" + _id, null);
    }

}