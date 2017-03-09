package com.aasavari.habittrackerapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.aasavari.habittrackerapp.data.HabitTrackerContract;
import com.aasavari.habittrackerapp.data.HabitTrackerDbHelper;

public class MainActivity extends AppCompatActivity {

    private HabitTrackerDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        mDbHelper = new HabitTrackerDbHelper(this);
    }

    private void insertHabit(){
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(HabitTrackerContract.HabitsEntry.COLUMN_HABIT_NAME, "Going to the gym");
        contentValues.put(HabitTrackerContract.HabitsEntry.COLUMN_HABIT_ACCOMPLISHED, 1);
        long rowId = db.insert(HabitTrackerContract.HabitsEntry.TABLE_NAME,null, contentValues);
        Log.i("insertHabit", "habittrackerDB:newly inserted row: " + rowId);
    }

    private Cursor readHabit(){
        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        // Define a projection that specifies which columns from the database
                // you will actually use after this query.
        String[] projection = {
                HabitTrackerContract.HabitsEntry._ID,
                HabitTrackerContract.HabitsEntry.COLUMN_HABIT_NAME,
                HabitTrackerContract.HabitsEntry.COLUMN_HABIT_ACCOMPLISHED
        };

        //Use a cursor to collect the data from the query operation on the db
         Cursor cursor = db.query(HabitTrackerContract.HabitsEntry.TABLE_NAME, projection,
                                   null, null, null,
                                   null, null, null);

            return cursor;
            }


}
