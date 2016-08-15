package utils;

import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHttpResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by dasha on 15.08.16.
 */
public class HttpGetJson extends AsyncTask<String, String, JSONObject> {
    @Override
    protected JSONObject doInBackground(String... params) {
        JSONObject json = null;
        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet("http://testapi.us/api/gallery/list");
        httpget.setHeader("user_id", "xYRdG67bDz");
        httpget.setHeader("Content-Type", "application/json");
        httpget.setHeader("User-Agent", System.getProperty("http.agent"));
        BasicHttpResponse httpResponse = null;
        try {
            httpResponse = (BasicHttpResponse) httpclient.execute(httpget);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("JSON", JsonHelper.GetJson(httpResponse).toString());
        json = JsonHelper.GetJson(httpResponse);
        return json;
    }
}

class JsonHelper {
    public static JSONObject GetJson(InputStream in) {
        JSONObject jsonObject=null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            jsonObject = new JSONObject(sb.toString());
        } catch (Exception ex) {

        } finally {
            try {

                in.close();
            } catch (Exception ex) {
            }
        }
        return jsonObject;
    }

    public static JSONObject GetJson(HttpResponse response) {
        JSONObject jsonObject = null;
        try {
            jsonObject = GetJson(response.getEntity().getContent());
        } catch (Exception ex) {
        }
        return jsonObject;
    }
}
