package com.example.kevin.project8habittrackerapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kevin on 11/1/2017.
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "habits.db";

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create SQL schema
        String SQL_CREATE_HABITS_TABLE =
                "CREATE TABLE " + HabitContract.HabitEntry.TABLE_NAME + " (" +
                        HabitContract.HabitEntry._ID + " INTEGER PRIMARY KEY," +
                        HabitContract.HabitEntry.COLUMN_HABIT_TITLE + " TEXT," +
                        HabitContract.HabitEntry.COLUMN_HABIT_DAYS + " INTEGER);";
        db.execSQL(SQL_CREATE_HABITS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_DELETE_HABITS_TABLE =
                "DROP TABLE IF EXISTS " + HabitContract.HabitEntry.TABLE_NAME;
        db.execSQL(SQL_DELETE_HABITS_TABLE);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
