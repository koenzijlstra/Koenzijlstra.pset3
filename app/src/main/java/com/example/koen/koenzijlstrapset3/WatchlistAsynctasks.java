package com.example.koen.koenzijlstrapset3;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Koen on 16-11-2016.
 */



public class WatchlistAsynctasks extends AsyncTask {

    // make context
    private static Context context;

    private String query;

    private String title, year, plot, actors, rating;

    public WatchlistAsynctasks(Context c, String input) {
         query = input;
         context = c;
    }

    @Override
    protected void onPreExecute () {
        super.onPreExecute();
        Toast.makeText(context, "Searching", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Void doInBackground(Object[] params) {
        try {
            JSONObject moviejson = httphelper.readJsonFromUrl(query);
            title = moviejson.getString("Title");
            year = moviejson.getString("Year");
            plot = moviejson.getString("Plot");
            actors = moviejson.getString("Actors");
            rating = moviejson.getString("imdbRating");

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return null;
        // to do: json object verwerken
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

        Intent gotofullinfo = new Intent(context, fullinfo.class);
        gotofullinfo.putExtra("titleid", title);
        gotofullinfo.putExtra("yearid", year);
        gotofullinfo.putExtra("plotid", plot);
        gotofullinfo.putExtra("actorsid", actors);
        gotofullinfo.putExtra("ratingid", rating);

        context.startActivity(gotofullinfo);

    }
}
