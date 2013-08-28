package com.TimeStat;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private EventsAccess eventData;

    // ArrayList of strings for the events, get it from the database later
    List<String> events = new ArrayList<String>();

    // How we will display the event names on the ListView
    private ArrayAdapter<String> adapter;

    private ListView listview;


    // Counter, delete when we are actually connecting to the database
    private int count = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, events);

        listview = (ListView) findViewById(R.id.listview);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Context context = getApplicationContext();
                CharSequence text = "You pressed list position number: " + position;
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        eventData = new EventsAccess(this);

        eventData.open();
        eventData.close();
    }

    /* There might be a better way to do this but this allows the ListView
     * to stay when we rotate the screen.
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        listview.setAdapter(adapter);
    }

    /* Gets called when the user presses the add more activities button */
    public void onClick(View view) {
        adapter.add("Test Event " + count++);
        listview.setAdapter(adapter);

        // Toast
        Context context = getApplicationContext();
        CharSequence text = "Added Event";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
