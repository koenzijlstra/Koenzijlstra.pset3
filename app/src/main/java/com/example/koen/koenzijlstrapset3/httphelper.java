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

/**
 * Created by Koen on 15-11-2016.
 */

public class httphelper {
    final static String url1=  "http://www.omdbapi.com/?t=";
    final static String url2 = "&y=&plot=short&r=json";

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
//    public JSONObject getjsondata (String query) {
//        try {
//            URL fullurl = new URL(url1 + query + url2);
//            HttpURLConnection conn = (HttpURLConnection) fullurl.openConnection();
//            conn.setRequestMethod("GET");
//
//            InputStream in = new BufferedInputStream(conn.getInputStream());
//            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }




//        connection = (HttpURLConnection) url.openconnection
//        connection.setRequestMethod("GET");
//
//        // get response code
//        Integer responsecode = connection.getResponseCode();
//
//        // if else gebeuren, code hoger of lager dan 200 300
//    }
//
//    public class ApiHandler {
//
//        private String parameter = "";
//
//        public String querySet(String searchparameter){
//            parameter = searchparameter;
//            return parameter;
//        }
//
//        protected JSONObject Searchquery(){
//            String querystring = "http://omdbapi.com/?&s=";
//            String movietype = "&type=movie";
//
//            parameter = parameter.replace(" ","+");
//
//            // Create the final adress
//            String finalquery;
//            finalquery = querystring + parameter + movietype;
//
//            // Convert to URL.
//            URL url;
//            try {
//                url = new URL(finalquery);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//
//            // Get JSON object from adress
//            return new JSONObject(IOUtils.toString(url, Charset.forName("UTF-8")));
//        }
//    }




}
