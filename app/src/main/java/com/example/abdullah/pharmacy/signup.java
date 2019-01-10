package com.example.abdullah.pharmacy;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class signup  extends AppCompatActivity {
    EditText name;
    EditText surname;
    EditText birthday;
    EditText card;
    EditText email;
    EditText password;
    String getput="";
    String json;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);


        name = (EditText) findViewById(R.id.input_name);
        surname = (EditText) findViewById(R.id.input_surname);
        birthday = (EditText) findViewById(R.id.input_birthday);
        card = (EditText) findViewById(R.id.input_credit_card);
        email = (EditText) findViewById(R.id.input_email);
        password = (EditText) findViewById(R.id.input_password);


    }

    public void createaccount(View view) throws Exception {

        DataConnection db = new DataConnection(this);
        db.insertvalue( name.getText().toString(),surname.getText().toString(),birthday.getText().toString(),  email.getText().toString(),
        password.getText().toString(),card.getText().toString());


      /* try
       {
           JSONArray array = new JSONArray(alldata);
           for (int i = 0; i < array.length(); i++) {
               JSONObject jo = (JSONObject) array.get(i);
            // db.insertvalueofpharmacy(jo.get("pharmacyId").toString(),jo.get("productId").toString(),jo.get("quantity").toString());
           x= (String) jo.get("pharmacyId");
           }
       } catch (JSONException e)
       {
           e.printStackTrace();
       }
*/
        //{ "email" : "newUseCustomer@gmail.com", "password": "pwddss", "name": "Paco", "surnames":
         //   "Martínez Herrera", "birthday": "1990-05-09", "creditCardNumber": "123412562"}



        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);


         json=Dataformatasjson();
       // sendput(json);
       new CallAPI().execute();
       // db.getcount();


}


public String Dataformatasjson(){

   final JSONObject informatoinclient=new JSONObject();
    try {
        informatoinclient.put("name",name.getText().toString());
        informatoinclient.put("surnames",surname.getText().toString());
        informatoinclient.put("birthday",birthday.getText().toString());
        informatoinclient.put("email",email.getText().toString());
        informatoinclient.put("password",password.getText().toString());
        informatoinclient.put("creditCardNumber",card.getText().toString());
 return  informatoinclient.toString();


    } catch (JSONException ex){
        Log.d("Json","Can't fount json data");
    }
    return  null;

}


    public class CallAPI extends AsyncTask<String, String, String> {
        String data;

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

                URL obj= new URL("http://104.45.16.127:8080/DSS_P4/webapi/user");
               HttpURLConnection con= (HttpURLConnection) obj.openConnection();


                con.setRequestMethod("PUT");
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

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return null;
        }
    }
}


