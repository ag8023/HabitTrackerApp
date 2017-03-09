package com.aasavari.habittrackerapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.R.attr.name;
import static android.R.attr.version;
import static com.aasavari.habittrackerapp.data.HabitTrackerContract.HabitsEntry.TABLE_NAME;
import static com.aasavari.habittrackerapp.data.HabitTrackerContract.HabitsEntry._ID;
import static com.aasavari.habittrackerapp.data.HabitTrackerContract.HabitsEntry.COLUMN_HABIT_ACCOMPLISHED;
import static com.aasavari.habittrackerapp.data.HabitTrackerContract.HabitsEntry.COLUMN_HABIT_NAME;

/**
 * Created by Aasavari on 3/3/2017.
 */

public class HabitTrackerDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "habittracker.db";

    public HabitTrackerDbHelper(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //build a string that contains the SQL statement to create the habits table
        String SQL_CREATE_HABITS_TABLE = "CREATE TABLE" + TABLE_NAME + " ("
                + _ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +COLUMN_HABIT_NAME + " TEXT NOT NULL, "
                + COLUMN_HABIT_ACCOMPLISHED + " INTEGER NOT NULL);";
        Log.i("SQL STRING: ", SQL_CREATE_HABITS_TABLE);
        db.execSQL(SQL_CREATE_HABITS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        // The database is still at version 1, so there's nothing to do be done here. The statement below is just in case.
        String SQL_DELETE_HABITS_TABLE = "DROP TABLE" + TABLE_NAME;
        db.execSQL(SQL_DELETE_HABITS_TABLE);
        onCreate(db);
    }
}
