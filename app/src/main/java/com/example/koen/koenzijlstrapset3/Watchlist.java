package com.example.koen.koenzijlstrapset3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Watchlist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watchlist);

        // handmade string of the movies in watchlist. to do: create function to add and remove
        String[] Movies = {"Batman", "Lone survivor", "Gladiator", "Fury", "Black hawk down", "Breaking bad", "Tarzan", "Suits", "Iron man"};

        // set adapter to simple list item 1, content of the list becomes the string movies
        ListAdapter theadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Movies);
        ListView thelistview = (ListView) findViewById(R.id.listview);
        thelistview.setAdapter(theadapter);

        // when an item of the list is clicked, determine what item is clicked, and execute
        // watchlistasynctask with that item as input (the string "clickedtitle")
        thelistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String clickedtitle = String.valueOf(adapterView.getItemAtPosition(position));


                clickedtitle = clickedtitle.replace(" ", "+");

                new WatchlistAsynctasks(Watchlist.this, clickedtitle).execute();
                finish();
            }
        });
    }
}
