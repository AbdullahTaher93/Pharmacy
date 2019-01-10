package com.example.abdullah.pharmacy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class partionsofproducts extends AppCompatActivity {
    ListView ls;
    //String data[]={"Cosmética y belleza","Herbolario","Higiene y Salud","Infantil","Perfumería"};
    String data[]={"HERBALIST","HYGIENE","INFANTIL","COSMETICS","Perfumería"};


    int[] imgs={R.drawable.b2,R.drawable.b3,R.drawable.b4,R.drawable.b1,R.drawable.b5};
   final static String name="id";
   public  static TextView da;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.partionsofproduct);
        ls=(ListView)findViewById(R.id.lsofpart);
        ls.setAdapter(new adapter2(this,data,imgs));
        //da=(TextView)findViewById(R.id.t1);

        final Intent intent=new Intent(this,product.class);

      ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

             intent.putExtra(name,position+"");
              startActivity( intent);

          }
      });



    }
    public void exe(View view){
        Json json=new Json();
        json.execute();
    }

    public void pay(View view){
        Intent intent=new Intent(this,Pay.class);
        startActivity(intent);


    }
}
