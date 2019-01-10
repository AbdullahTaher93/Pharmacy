package com.example.abdullah.pharmacy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.internal.Objects;

public class Pay extends AppCompatActivity {
    TextView card;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay);
        card=(TextView) findViewById(R.id.input_credit_card);

    }
    public void pay(View view){

       if(!card.getText().toString().equals("")) {
           Toast.makeText(this, "Done!,you have paid", Toast.LENGTH_LONG).show();
           card.setText("");
           Intent intent = new Intent(this, maps.class);
           startActivity(intent);
       }
       else {
           Toast.makeText(this, "Pleas Enter your Card number", Toast.LENGTH_LONG).show();
       }

    }
}
