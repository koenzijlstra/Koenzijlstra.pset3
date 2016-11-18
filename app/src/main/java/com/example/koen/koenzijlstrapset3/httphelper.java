package com.example.koen.koenzijlstrapset3;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;


public class httphelper {
    // make the first and the last part of the url. these can not and won't need to be changed ever
    final static String url1=  "http://www.omdbapi.com/?t=";
    final static String url2 = "&y=&plot=short&r=json";

    // http://stackoverflow.com/questions/7190208/how-to-read-string-builder-line-by-line
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
    
    public static JSONObject readJsonFromUrl(String query) throws IOException, JSONException {
        InputStream is = new URL(url1 + query + url2).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
}




}
