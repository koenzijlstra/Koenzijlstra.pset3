package com.example.koen.koenzijlstrapset3;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

// used ideas from https://www.tutorialspoint.com/android/android_json_parser.htm

public class WatchlistAsynctasks extends AsyncTask {

    // make context
    private static Context context;

    private String search;
    private String title, year, plot, actors, rating;

    public WatchlistAsynctasks(Context c, String input) {
         search = input;
         context = c;
    }

    @Override
    protected void onPreExecute () {
        super.onPreExecute();
        // first thing is a toast "searching", to show user that something will be done.
        Toast.makeText(context, "Searching", Toast.LENGTH_SHORT).show();
    }

    // create json object of movie that user searched for
    @Override
    protected Void doInBackground(Object[] params) {
        try {
            JSONObject moviejson = httphelper.readJsonFromUrl(search);
            title = moviejson.getString("Title");
            year = moviejson.getString("Year");
            plot = moviejson.getString("Plot");
            actors = moviejson.getString("Actors");
            rating = moviejson.getString("imdbRating");

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


    // make intent, give data from doinbackground as extra with intent, start activity
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
