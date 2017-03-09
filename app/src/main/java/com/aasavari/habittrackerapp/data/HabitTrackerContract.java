package com.aasavari.habittrackerapp.data;

import android.provider.BaseColumns;

/**
 * Created by Aasavari on 3/3/2017.
 */

public final class HabitTrackerContract {

    public static abstract class HabitsEntry implements BaseColumns {
        public static final String TABLE_NAME = "habits";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_HABIT_NAME = "Habit";
        public static final String COLUMN_HABIT_ACCOMPLISHED = "Accomplished";
        public static final int ACCOMPLISHED_SUCCESS = 1;
        public static final int ACCOMPLISHED_FAILURE = 0;
    }
}
