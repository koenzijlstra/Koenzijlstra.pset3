package com.example.koen.koenzijlstrapset3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] Movies = {"Batman", "Lone survivor", "Warrior"};

        ListAdapter theadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Movies); // deze nog aanmaken?

        ListView thelistview = (ListView) findViewById(R.id.list);

        thelistview.setAdapter(theadapter);

        thelistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String moviepicked = "you selected " + String.valueOf(adapterView.getItemAtPosition(position));

                Toast.makeText(MainActivity.this, moviepicked, Toast.LENGTH_SHORT).show();

                Intent gotomovie = new Intent(adapterView.getContext(), fullinfo.class);
                gotomovie.putExtra("retrievalname", String.valueOf(adapterView.getItemAtPosition(position)));
                startActivity(gotomovie);

            }
        });
    }

//
//    public void get_data{
//
//
//    }
//
//    public void set_data{
//
//
//    }
//


    // when button is clicked -> go to
    public void startActivity(View view) {
        Intent gotowatchlist = new Intent(this, Watchlist.class);
        startActivity(gotowatchlist);
    }
}
