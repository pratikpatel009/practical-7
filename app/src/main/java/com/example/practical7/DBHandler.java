package com.example.practical7;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

public class DBHandler extends AsyncTask<String,Void,String> {
Context context;
DBHandler(Context context ){
    this.context = context;
}

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
    String req_url = "https://gentling-rumbles.000webhostapp.com/student.php";
    String name = params[0];
    String enrollmentNumber = params[1];
    String branch = params[2];
    String year = params[3];

        try {
            URL url = new URL(req_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            OutputStream os = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
            String data = URLEncoder.encode("name","UTF-8") + "=" + URLEncoder.encode(name,"UTF-8") + "&"+
             URLEncoder.encode("enrollmentNumber","UTF-8") + "=" + URLEncoder.encode(enrollmentNumber,"UTF-8") + "&"+
             URLEncoder.encode("branch","UTF-8") + "=" + URLEncoder.encode(branch,"UTF-8") + "&"+
             URLEncoder.encode("year","UTF-8") + "=" + URLEncoder.encode(year,"UTF-8") ;
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            os.close();
            InputStream IS = httpURLConnection.getInputStream();
            IS.close();
            return "Data save success..";
        } catch (IOException e) {
            System.out.println(e);
           return new String("Exception " +e.getMessage());

        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        Toast.makeText(context, "buffering", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPostExecute(String result) {
        System.out.println(result.toString());
        Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
    }

}
