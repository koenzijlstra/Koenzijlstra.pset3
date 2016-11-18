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


        String[] Movies = {"Batman", "Lone survivor", "Gladiator", "Fury", "Southpaw", "Black hawk down"};

        ListAdapter theadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Movies); // deze nog aanmaken?
        ListView thelistview = (ListView) findViewById(R.id.listview);
        thelistview.setAdapter(theadapter);

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
