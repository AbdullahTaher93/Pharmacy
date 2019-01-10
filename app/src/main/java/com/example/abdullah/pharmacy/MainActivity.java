package com.example.abdullah.pharmacy;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
EditText email,password;
    String json;
    String result="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=(EditText)findViewById(R.id.input_password);
        password=(EditText)findViewById(R.id.input_email);


    }
    public void singup(View view){
        Json json1=new Json();
        json1.execute();
        Intent intent = new Intent(this,signup.class);
        startActivity(intent);
    }



    public void map(View view) {
        Json json1=new Json();
        json1.execute();
        boolean result1=false;
        JSONObject ob;
        Intent intent = new Intent(this,maps.class);
        EditText email=(EditText)findViewById(R.id.input_email);
        EditText password=(EditText)findViewById(R.id.input_password);
        DataConnection db=new DataConnection(this);
        try {
             ob=new JSONObject(String.valueOf(result));
            result1=ob.get("result").toString().equals("true");

        }catch (Exception e){

        }



        if (!email.getText().toString().equals("") && !password.getText().toString().equals("") )
            result1=db.viewdata(email.getText().toString(),password.getText().toString());
        //Intent intent = new Intent(this,Viewall.class);
        //startActivity(intent);



        if(result1==true) {
            startActivity(intent);
            json=Dataformatasjson();
        }
        else
            Toast.makeText(this,"yor email or password are incorrect  ",Toast.LENGTH_LONG).show();
    }


    public String Dataformatasjson(){

        final JSONObject informatoinclient=new JSONObject();
        try {

            informatoinclient.put("email",email.getText().toString());
            informatoinclient.put("password",password.getText().toString());

            return  informatoinclient.toString();


        } catch (JSONException ex){
            Log.d("Json","Can't fount json data");
        }
        return  null;

    }





    public class CallAPI extends AsyncTask<String, String, String> {


        public CallAPI(){
            //set context variables if required
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {


            try {

                URL obj= new URL("http://104.45.16.127:8080/DSS_P4/webapi/login");
                HttpURLConnection con= (HttpURLConnection) obj.openConnection();


                con.setRequestMethod("POST");
                con.setRequestProperty("Content-type","application/json");


                con.setDoOutput(true);
                DataOutputStream wr=new DataOutputStream(con.getOutputStream());
                wr.writeBytes(json);
                wr.flush();
                wr.close();


                int res=con.getResponseCode();
                Log.d("responscode", "sendput: "+res);


                BufferedReader in=new BufferedReader(
                        new InputStreamReader(con.getInputStream()));

                String line;
                StringBuffer respo=new StringBuffer();

                while ((line=in.readLine())!=null)
                {
                    respo.append(line);

                }
                in.close();
                result=respo.toString();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return null;
        }
    }





}
