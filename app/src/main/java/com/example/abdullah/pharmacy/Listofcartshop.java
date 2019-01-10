package com.example.abdullah.pharmacy;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class Listofcartshop extends AppCompatActivity {
    public static String[][] listofcartshop={};
    public static String[] imgsofcartshop={};
    public static Float totalprifce;
    public static ListView ls;
    public static TextView to;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listofcartshop);
        ls=(ListView)findViewById(R.id.ls);
        ls.setAdapter(new adapter3(this,listofcartshop,imgsofcartshop));


        to=(TextView)findViewById(R.id.Totalprice);
       to.setText("Total Price ="+totalprifce+"   €");

    }
    public void pay(View view){
        Intent intent=new Intent(this,Pay.class);
        startActivity(intent);


    }

}
