package com.example.abdullah.pharmacy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class adapter2 extends BaseAdapter {
    private static LayoutInflater layoutInflater=null;
    Context context;
    String data[];
    int imgs[];

    public adapter2(Context context, String data[],int imgs[]){
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
    public View getView(int i, View convertView, ViewGroup parent) {

        final View view=layoutInflater.inflate(R.layout.part,null);
        TextView titel=(TextView)view.findViewById(R.id.partname);
        ImageView productphoto=(ImageView)view.findViewById(R.id.partimage);
          titel.setText(data[i]);
        productphoto.setImageResource(imgs[i]);
        productphoto.setTag(i);
        return view;
    }
}
