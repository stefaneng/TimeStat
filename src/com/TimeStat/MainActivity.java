package com.TimeStat;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private EventsAccess eventData;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        List<String> test = new ArrayList<String>();
        test.add("Hello");
        test.add("world");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, test);
        ListView listview = (ListView) findViewById(R.id.listview);

        listview.setAdapter(adapter);

        eventData = new EventsAccess(this);

        eventData.open();
        eventData.close();
    }
}
