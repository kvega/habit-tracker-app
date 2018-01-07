package com.example.kevin.project8habittrackerapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getName();
    private HabitDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create new database helper
        mDbHelper = new HabitDbHelper(this);

        // Insert five items into the database
        for (int i = 0; i < 5; i++) {
            insertHabit();
        }

        // Output database contents to console
        displayDatabaseInfo(createCursor());
    }

    // Inserts new habit into database
    private void insertHabit() {
        // Open/create a writable database
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Instantiate a new value
        ContentValues values = new ContentValues();
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_TITLE, "Meditate");
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_DAYS, 4);

        // Insert new value into database and generate a newRowId
        long newRowId = db.insert(HabitContract.HabitEntry.TABLE_NAME, null, values);

        Log.v(LOG_TAG, "New row ID " + newRowId);
    }

    private Cursor createCursor() {
        // Reads in database
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Create projection
        String[] projection = {
                HabitContract.HabitEntry._ID,
                HabitContract.HabitEntry.COLUMN_HABIT_TITLE,
                HabitContract.HabitEntry.COLUMN_HABIT_DAYS
        };

        // Instantiate new Cursor
        Cursor cursor = db.query(
                HabitContract.HabitEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }

    // Outputs database content to console
    private void displayDatabaseInfo(Cursor cursor) {
         // Try to output database content
         try {
             DatabaseUtils.dumpCursor(cursor);
         } finally {
             // Release resources
             cursor.close();
         }
    }
}