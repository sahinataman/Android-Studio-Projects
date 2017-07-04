package com.example.bazz.cevahirevyemekleri;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class GunlerActivity extends AppCompatActivity {
    ImageButton geri_buton;
    Button pazartesi,sali,carsamba,persembe,cuma,cumartesi,pazar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gunler);

        pazartesi =(Button)findViewById(R.id.pazartesiBTN);
        pazartesi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(GunlerActivity.this, GunlerdenPazartesiActivity.class);
                GunlerActivity.this.startActivity(myIntent);
            }
        });
        sali =(Button)findViewById(R.id.saliBTN);
        sali.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(GunlerActivity.this, GunlerdenSaliActivity.class);
                GunlerActivity.this.startActivity(myIntent);
            }
        });
        carsamba =(Button)findViewById(R.id.carsambaBTN);
        carsamba.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(GunlerActivity.this, GunlerdenCarsambaActivity.class);
                GunlerActivity.this.startActivity(myIntent);
            }
        });
        persembe =(Button)findViewById(R.id.persembeBTN);
        persembe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(GunlerActivity.this, GunlerdenPersembeActivity.class);
                GunlerActivity.this.startActivity(myIntent);
            }
        });
        cuma =(Button)findViewById(R.id.cumaBTN);
        cuma.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(GunlerActivity.this, GunlerdenCumaActivity.class);
                GunlerActivity.this.startActivity(myIntent);
            }
        });
        cumartesi =(Button)findViewById(R.id.cumartesiBTN);
        cumartesi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(GunlerActivity.this, GunlerdenCumartesiActivity.class);
                GunlerActivity.this.startActivity(myIntent);
            }
        });
        pazar =(Button)findViewById(R.id.pazarBTN);
        pazar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(GunlerActivity.this, GunlerdenPazarActivity.class);
                GunlerActivity.this.startActivity(myIntent);
            }
        });
        geri_buton = (ImageButton)findViewById(R.id.geriBTN);
        geri_buton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

}
