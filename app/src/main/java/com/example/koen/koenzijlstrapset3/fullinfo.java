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

        Bundle extras = getIntent().getExtras();
        String title = extras.getString("titleid");
        String year = extras.getString("yearid");
        String plot = extras.getString("plotid");


        TextView titleview =  (TextView) findViewById(R.id.title);
        titleview.setText(title);

        TextView yearview =  (TextView) findViewById(R.id.year);
        yearview.setText(year);

        TextView plotview = (TextView) findViewById(R.id.plot);
        plotview.setText(plot);

    }

    public void startActivity(View view) {
        Intent gotowatchlist = new Intent(this, Watchlist.class);
        startActivity(gotowatchlist);
    }

}
