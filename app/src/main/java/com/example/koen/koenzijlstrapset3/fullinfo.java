package com.example.koen.koenzijlstrapset3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class fullinfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullinfo);

        // retrieve extras given with the intent, create strings for every piece of data
        Bundle extras = getIntent().getExtras();
        String title = extras.getString("titleid");
        String year = extras.getString("yearid");
        String plot = extras.getString("plotid");
        String actors = extras.getString("actorsid");
        String ratings = extras.getString("ratingid");

        // set text of title
        TextView titleview =  (TextView) findViewById(R.id.title);
        titleview.setText(title);

        // set text of view that displays year
        TextView yearview =  (TextView) findViewById(R.id.year);
        yearview.setText(year);

        // set text of view that displays the plot
        TextView plotview = (TextView) findViewById(R.id.plot);
        plotview.setText(plot);

        // set text of view that displays the actors
        TextView actorsview = (TextView) findViewById(R.id.actors);
        String ac = "Actors: ";
        String fullac = ac + actors;
        actorsview.setText(fullac);

        // set text of view that displays imdb rating
        TextView ratingview = (TextView) findViewById(R.id.rating);
        String rt = "IMDB Rating: ";
        String fullrt = rt + ratings;
        ratingview.setText(fullrt);
    }

    // when the button that says "see watchlist" is clicked -> go to watchlist
    public void startActivity(View view) {
        Intent gotowatchlist = new Intent(this, Watchlist.class);
        startActivity(gotowatchlist);
        finish();
    }
}
