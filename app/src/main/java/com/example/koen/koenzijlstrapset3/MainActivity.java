package com.example.koen.koenzijlstrapset3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit =  (EditText) findViewById(R.id.editText);
    }

    // when button is clicked -> go to
    public void startActivity(View view) {
        Intent gotowatchlist = new Intent(this, Watchlist.class);
        startActivity(gotowatchlist);
    }

    public void searchmovie(View view) {
        String query = edit.getText().toString();

        // in order to make url working when there is a space between words in title, replace space
        // with plus
        query = query.replace(" ", "+");
        new WatchlistAsynctasks(MainActivity.this, query).execute();

    }
}
