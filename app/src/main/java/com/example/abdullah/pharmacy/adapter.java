package com.example.abdullah.pharmacy;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.drawable.Drawable;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class adapter extends BaseAdapter {

    private static LayoutInflater layoutInflater=null;
     Context context;

       String data[][];
       String imgs[];
    public static String datacart[][]=new String[100][4];
    public static    String imgscart[]=new String[100];
     public static int count=0;
    public static float Totalprice=0;





       public adapter(Context context, String data[][],String imgs[]){
           this.context=context;
           this.data=data;
           this.imgs=imgs;

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
        final View view = layoutInflater.inflate(R.layout.oneofproducts, null);

        TextView titel = (TextView) view.findViewById(R.id.titel);
        TextView details = (TextView) view.findViewById(R.id.details);
        TextView price = (TextView) view.findViewById(R.id.price);
        ImageView productphoto = (ImageView) view.findViewById(R.id.productphoto);
        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        Button cartshop1 = (Button) view.findViewById(R.id.carshop);


        titel.setText(data[i][0]);
        details.setText(data[i][1]);


        cartshop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                datacart[count][0] = (data[i][0]);
                datacart[count][1] = (data[i][1]);
                datacart[count][2] = (data[i][2]);
                datacart[count][3] = (data[i][3]);
                imgscart[count] = imgs[i];
                count++;
                Totalprice = Totalprice + Float.parseFloat(data[i][2]);

                Listofcartshop.listofcartshop = datacart;
                Listofcartshop.imgsofcartshop = imgscart;
                Listofcartshop.totalprifce = Totalprice ;
                Listofcartshop.listofcartshop = Arrays.copyOf(Listofcartshop.listofcartshop, count);
                Listofcartshop.imgsofcartshop = Arrays.copyOf(Listofcartshop.imgsofcartshop, count);

                Log.d("count of ", "onClick: " + Totalprice);

                Toast.makeText(context, "Added This Product To Shopping cart", Toast.LENGTH_LONG).show();
            }
        });
        price.setText(data[i][2] + "€");
        Picasso.with(context)
                .load(imgs[i])
                .into(productphoto );
        // productphoto.setImageResource(imgs[i]);


       /* try {

            Bitmap bitmap = BitmapFactory.decodeStream((InputStream) new URL("https://i.ibb.co/3fTC7ZX/1.jpg").getContent());
            productphoto.setImageBitmap(bitmap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/





        ratingBar.setProgress(Integer.valueOf(data[i][3]));
        productphoto.setTag(i);


        return view;
    }


}
