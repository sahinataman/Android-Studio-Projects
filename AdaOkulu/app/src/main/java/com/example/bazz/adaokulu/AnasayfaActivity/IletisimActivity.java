package com.example.bazz.adaokulu.AnasayfaActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.example.bazz.adaokulu.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class IletisimActivity extends FragmentActivity implements OnMapReadyCallback {
    private Toolbar toolbar;
    private GoogleMap mMap;
    ImageButton facebook,google,twitter,geri_buton,ara_buton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iletisim);

        toolbar=(Toolbar) findViewById(R.id.iletisimToolbar);

        // Fragment ile harita veri tasarımı...
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        facebook = (ImageButton) findViewById(R.id.facebookBTN);
        twitter = (ImageButton) findViewById(R.id.twitterBTN);
        google = (ImageButton) findViewById(R.id.googleBTN);

        //Facebook iletişim adresi
        facebook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://www.facebook.com/Gaziantep-Ada-Okullar%C4%B1-1422324271374695/"));
                startActivity(myWebLink);
            }
        });
        //Twitter iletişim adresi
        twitter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://twitter.com/gantepadakoleji"));
                startActivity(myWebLink);
            }
        });
        //Google+ iletişim adresi
        google.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://plus.google.com/105718394456627039716/posts"));
                startActivity(myWebLink);
            }
        });

        geri_buton = (ImageButton) findViewById(R.id.geriBTN);
        ara_buton = (ImageButton) findViewById(R.id.araBTN);

        //Bir Onceki layout a geri dönme
        geri_buton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //İletişim ekranında ADAOKULLARI numarasını arama
        ara_buton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                String temp = "tel:" + "05414622278";
                intent.setData(Uri.parse(temp));

                startActivity(intent);
            }
        });

    }
    //Harita kordinatları bu fonksiyondan cekiliyor...
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(37.001346, 37.807941);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}