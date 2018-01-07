package com.example.kevin.project8habittrackerapp;

import android.provider.BaseColumns;

/**
 * Created by Kevin on 11/1/2017.
 */

public final class HabitContract {

    public static abstract class HabitEntry implements BaseColumns {

        // Name the table and columns
        public static final String TABLE_NAME = "habits";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_HABIT_TITLE = "title";
        public static final String COLUMN_HABIT_DAYS = "days";

    }
}
