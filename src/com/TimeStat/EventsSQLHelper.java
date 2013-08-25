package com.TimeStat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EventsSQLHelper extends SQLiteOpenHelper{
    public static final String TABLE_EVENTS = "events";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_EVENT = "event";
    public static final String COLUMN_TIME = "time";

    private static final String DATABASE_NAME = "events.db";
    private static final int DATABASE_VERSION = 1;
    private static final String INSERT_COLUMN_ID = COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT";
    private static final String INSERT_COLUMN_EVENT = COLUMN_EVENT + " TEXT NOT NULL";
    private static final String INSERT_COLUMN_TIME = COLUMN_TIME + " INTEGER";

    private static final String DATABASE_CREATE =
            "CREATE TABLE " + TABLE_EVENTS + "(" +
                    INSERT_COLUMN_ID + ", " +
                    INSERT_COLUMN_EVENT + ", " +
                    INSERT_COLUMN_TIME + ");";

    private static final String DATABASE_DELETE =
            "DROP TABLE IF EXISTS " + TABLE_EVENTS;


    public EventsSQLHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DATABASE_DELETE);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }




}
