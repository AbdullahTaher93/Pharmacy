package com.example.abdullah.pharmacy;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class maps extends FragmentActivity implements OnMapReadyCallback {
    public static final String id="id";

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        //Obtain the SupportMapFragment and get notified when the map is ready to be used.
     SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }








    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(37.189357, -3.608461);


        final Marker m1=   mMap.addMarker(new MarkerOptions().position(new LatLng(37.1902975, -3.6029898)).title("Pharmacy 1").snippet("click to get details").icon(BitmapDescriptorFactory.fromResource(R.drawable.pharmacy)));
        final Marker m2=  mMap.addMarker(new MarkerOptions().position(new LatLng(37.186503, -3.603912)).title("Pharmacy 2").snippet("click to get details").icon(BitmapDescriptorFactory.fromResource(R.drawable.pharmacy)));
        final Marker m3= mMap.addMarker(new MarkerOptions().position(new LatLng(37.186896, -3.612195)).title("Pharmacy 3").snippet("click to get details").icon(BitmapDescriptorFactory.fromResource(R.drawable.pharmacy)));

        Marker m4= mMap.addMarker(new MarkerOptions().position(new LatLng(37.189289, -3.609212)).title("Your Location").snippet("select a one pharmacy what you want. ").icon(BitmapDescriptorFactory.fromResource(R.drawable.person)));
        mMap.setBuildingsEnabled(true);
        m4.showInfoWindow();

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15));
        final Context co=this;
        final Intent intent= new Intent(co,partionsofproducts.class);
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener(){
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (m1.equals(marker)) {
                    Toast.makeText(co, "you will move ot store of Pharmacy 1", Toast.LENGTH_LONG).show();
                    intent.putExtra(id,"1");
                    product.phatmacyID="1";
                    startActivity(intent);

                }
                else if(m2.equals(marker)) {
                    Toast.makeText(co, "you will move ot store of Pharmacy 2", Toast.LENGTH_LONG).show();
                    intent.putExtra(id,"2");
                    product.phatmacyID="2";
                    startActivity(intent);

                }
                else if (m3.equals(marker)) {

                    Toast.makeText(co, "you will move ot store of Pharmacy 3", Toast.LENGTH_LONG).show();
                    intent.putExtra(id,"3");
                    product.phatmacyID="3";
                    startActivity(intent);


                }
                return false;
            }


        });

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;

        }
        mMap.setMyLocationEnabled(true);

    }
}
