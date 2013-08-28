package com.TimeStat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.SQLException;

public class EventsAccess {
    private EventsSQLHelper helper;
    private SQLiteDatabase db;
    private String[] columns = {
            EventsSQLHelper.COLUMN_ID,
            EventsSQLHelper.COLUMN_EVENT,
            EventsSQLHelper.COLUMN_TIME,
            EventsSQLHelper.COLUMN_TIMESTAMP
    };

    public EventsAccess(Context context) {
        helper = new EventsSQLHelper(context);
    }

    public void open() throws SQLException {
        db = helper.getWritableDatabase();
    }

    public void close() {
        helper.close();
        db.close();
    }
}
