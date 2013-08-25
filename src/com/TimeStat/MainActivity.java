package com.TimeStat;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        EventsSQLHelper helper = new EventsSQLHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
    }
}
