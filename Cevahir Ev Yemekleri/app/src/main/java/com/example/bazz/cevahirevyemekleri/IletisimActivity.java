package com.example.bazz.cevahirevyemekleri;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class IletisimActivity extends FragmentActivity implements OnMapReadyCallback {
    private Toolbar toolbar;
    public GoogleMap mMap;
    ImageButton facebook,forsquare,twitter,website,geri_buton,ara_buton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iletisim);

        // Fragment ile harita veri tasarımı...
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        facebook = (ImageButton) findViewById(R.id.facebookBTN);
        twitter = (ImageButton) findViewById(R.id.twitterBTN);
        website = (ImageButton) findViewById(R.id.websiteBTN);
        forsquare = (ImageButton) findViewById(R.id.forsquareBTN);
        //Facebook iletişim adresi
        facebook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://www.facebook.com/cevahirevyemekleri/?fref=ts"));
                startActivity(myWebLink);
            }
        });
        //Twitter iletişim adresi
        twitter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://twitter.com/search?q=cevahir%20ev%20yemekleri&src=typd&lang=tr"));
                startActivity(myWebLink);
            }
        });
        //Forsquare iletişim adresi
        forsquare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://tr.foursquare.com/v/cevahir-ev-yemekleri--cafe/4e786a27b61ce1c8987f4bf4"));
                startActivity(myWebLink);
            }
        });
        //Website iletişim adresi
        website.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("http://www.cevahirevyemekleri.com/"));
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
                String temp = "tel:" + "02862131600";
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
        LatLng cevahir = new LatLng(40.149348,26.401347 );

        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.cevahir_red_marker);

        MarkerOptions markerOptions = new MarkerOptions().position(cevahir)
                .title("Cevahir Ev Yemekleri")
                .snippet("Lezzet adına hersey...")
                .icon(icon);

        mMap.addMarker(markerOptions);
    }

}