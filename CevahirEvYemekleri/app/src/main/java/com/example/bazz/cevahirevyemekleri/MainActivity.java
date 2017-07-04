package com.example.bazz.cevahirevyemekleri;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity{
    TextView MarqueeText;
    Button iletisim, hangigun_hangiyemek, fiyatlar, izgaralar, tatlilar, icecekler,corbalar,galeri,bildirimler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowTitleEnabled(false); // Toolbar da app title false etme
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setContentView(R.layout.activity_main);

        MarqueeText=(TextView)findViewById(R.id.MarqueeText);
        MarqueeText.setSelected(true);

        hangigun_hangiyemek =(Button)findViewById(R.id.hangigunTXT);
        hangigun_hangiyemek.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, GunlerActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
        fiyatlar =(Button)findViewById(R.id.menulerTXT);
        fiyatlar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this,MenulerActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
        corbalar =(Button)findViewById(R.id.corbaTXT);
        corbalar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this,CorbalarActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
        izgaralar =(Button)findViewById(R.id.izgaraTXT);
        izgaralar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this,IzgaralarActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
        tatlilar =(Button)findViewById(R.id.tatliTXT);
        tatlilar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this,TatlilarActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
        icecekler =(Button)findViewById(R.id.icecekTXT);
        icecekler.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this,IceceklerActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
        galeri =(Button)findViewById(R.id.galeriTXT);
        galeri.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, GaleriActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });


        iletisim =(Button)findViewById(R.id.iletisimTXT);
        iletisim.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, IletisimActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        bildirimler =(Button)findViewById(R.id.bildirimTXT);
        bildirimler.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, BildirimlerActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return true;
    }
    public void GirisSayfasi(MenuItem item){
        Intent giris_saysasi = new Intent(getApplicationContext(),LoginPage.class );
        startActivity(giris_saysasi);
        finish();
    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Çıkış")
                .setMessage("Uygulamadan çıkmak istediğinize emin misiniz?")
                .setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }
                }).setNegativeButton("Hayır", null).show();
    }
}

