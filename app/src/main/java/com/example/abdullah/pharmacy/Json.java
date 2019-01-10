package com.example.abdullah.pharmacy;

import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Json extends AsyncTask<Void,Void,Void> {



    String data="";
    String todo="";


    @Override
    protected Void doInBackground(Void... voids) {

        try {
            URL url=new URL("http://104.45.16.127:8080/DSS_P4/webapi/pharmacy/1/products");
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            String single="";

            while(line!=null){
                line=bufferedReader.readLine();
                data=data+line;

            }
            //DataConnection db=new DataConnection(this);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } http://104.45.16.127:8080/DSS_P4/webapi/product




        try {
            URL url=new URL("http://104.45.16.127:8080/DSS_P4/webapi/product");
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            String single="";

            while(line!=null){
                line=bufferedReader.readLine();
                todo=todo+line;

            }



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }


    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        product.allda=this.data;
        product.allprudect=this.todo;

    }

}
