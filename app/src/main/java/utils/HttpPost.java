package utils;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dasha on 15.08.16.
 */
public class HttpPost extends AsyncTask<String, String, String> {
    @Override
    protected String doInBackground(String[] params) {
        HttpClient client = new DefaultHttpClient();
        org.apache.http.client.methods.HttpPost post = new
                org.apache.http.client.methods.HttpPost("http://testapi.us/api/login");
        String user_id = "";
        try {

            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            nameValuePairs.add(new BasicNameValuePair("Email", "youremail"));
            nameValuePairs
                    .add(new BasicNameValuePair("Passwd", "yourpassword"));

            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = client.execute(post);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            while ((user_id = rd.readLine()) != null) {
                Log.d("Tag_user_id", user_id);


            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return user_id;
    }

    @Override
    protected void onPostExecute(String string) {
        super.onPostExecute(string);
    }

}
