package com.example.abdullah.pharmacy;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.Arrays;

public class adapter3 extends BaseAdapter {
    private static LayoutInflater layoutInflater=null;
    Context context;
    String data[][];
    String imgs[];
    String datacart[][];
    int imgscart[];
    String[][] data2=new String[100][4];
    String imgs2[]=new String[100];
    Float totalprice=Float.parseFloat("0");
    public static int count=0;





    public adapter3(Context context, String data[][],String imgs[]){
        this.context=context;
        this.data=data;
        this.imgs=imgs;
        datacart=new String[data.length][3];
        imgscart=new int[data.length];
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE) ;

    }



    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup parent) {
        final View view=layoutInflater.inflate(R.layout.cartshop,null);
        final View view1=layoutInflater.inflate(R.layout.listofcartshop,null);

        TextView titel=(TextView)view.findViewById(R.id.titel);
        TextView details=(TextView)view.findViewById(R.id.details);
        TextView price=(TextView)view.findViewById(R.id.price);

        ImageView productphoto=(ImageView)view.findViewById(R.id.productphoto);
        RatingBar ratingBar=(RatingBar)view.findViewById(R.id.ratingBar);
        Button cartshop1=(Button)view.findViewById(R.id.carshop);
        final ListView ls=(ListView)view1.findViewById(R.id.ls);




        titel.setText(data[i][0]);
        details.setText(data[i][1]);
        price.setText(data[i][2]+"€");


        Picasso.with(context)
                .load(imgs[i])
                .into(productphoto);
        ratingBar.setProgress(Integer.valueOf( data[i][3]));
        productphoto.setTag(i);

        cartshop1.setOnClickListener(new View.OnClickListener(){
             @Override
            public void onClick(View v) {
                 int  k=0;
                 for(int j=0;j<data.length;j++) {

                     if (j != i) {
                         data2[k][0] = data[j][0];
                         data2[k][1] = data[j][1];
                         data2[k][2] = data[j][2];
                         data2[k][3] = data[j][3];
                         imgs2[k] = imgs[j];
                         totalprice = totalprice + Float.parseFloat(data[j][2]);

                         k++;
                     }
                 }
                 data2=Arrays.copyOf(data2,k);
                 imgs2=Arrays.copyOf(imgs2,k);

                 Listofcartshop.ls.setAdapter(new adapter3(context,data2,imgs2));
                 Listofcartshop.imgsofcartshop=imgs2;
                 Listofcartshop.listofcartshop=data2;
                 Listofcartshop.totalprifce=totalprice;
                 //adapter.datacart=data2;
                 //adapter.imgscart=imgs2;
                 //adapter.count=k;
                 //adapter.Totalprice=totalprice;

                 Listofcartshop.to.setText("Total Price ="+totalprice+"   €");

            }
        });

        return view;
    }
}
