package com.example.bazz.adaokulu.OBS;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bazz.adaokulu.LoginPage;
import com.example.bazz.adaokulu.R;

import java.text.SimpleDateFormat;

public class OgrenciProfili extends AppCompatActivity {

    Button sinav_sonuclari,beslenme,devamsizlik,servis_saatleri,sinav_takvimi;
    TextView adSoyad,numara,tarih,sinifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogrenci_profil);

        adSoyad=(TextView)findViewById(R.id.adsoyadTV);
        numara=(TextView)findViewById(R.id.numaraTV);
        tarih = (TextView) findViewById(R.id.tarihTV);
        sinifi = (TextView) findViewById(R.id.sinifTV);

        //Tarih İçin DaTe cekiyoruz
        long date = System.currentTimeMillis();
        SimpleDateFormat zmn = new SimpleDateFormat(" dd/MM/yyyy ");
        String dateString = zmn.format(date);
        tarih.setText(dateString);

        //Burda LoginPage sınıfından gelen numara ve Ogrenci Adını cekiyorum
        Intent intent = getIntent();
        final String ad  = intent.getStringExtra("GelenADSOYAD");
        final String no  = intent.getStringExtra("GelenNumara");
        final String sinif  = intent.getStringExtra("GelenSinif");



        SharedPreferences mSharedPrefs = getSharedPreferences("kayitDostasi",MODE_APPEND);
        SharedPreferences.Editor mPrefsEditor = mSharedPrefs.edit();
        if(ad!=null) {
            mPrefsEditor.putString("keydeger", ad);
            mPrefsEditor.putString("keydeger2", no);
        }

        String name= mSharedPrefs.getString("keydeger","NULL");
        String number = mSharedPrefs.getString("keydeger2","NULL");

        mPrefsEditor.commit();


        adSoyad.setText(name);
        numara.setText(number);
        sinifi.setText(sinif);

        sinav_sonuclari =(Button)findViewById(R.id.sinavsonucBTN);
        beslenme =(Button)findViewById(R.id.beslenmeBTN);
        devamsizlik =(Button)findViewById(R.id.devamsızlıkBTN);
        servis_saatleri =(Button)findViewById(R.id.servisBTN);
        sinav_takvimi =(Button)findViewById(R.id.takvimBTN);

        sinav_sonuclari.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(OgrenciProfili.this, SinavSonucActivity.class);
                OgrenciProfili.this.startActivity(myIntent);

                Intent gonder  = new Intent(OgrenciProfili.this,SinavSonucActivity.class);
                gonder.putExtra("GelenADSOYAD", ad);
                gonder.putExtra("GelenNO",no);
                startActivity(gonder);
            }
        });
        devamsizlik.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(OgrenciProfili.this, DevamsizlikActivity.class);
                OgrenciProfili.this.startActivity(myIntent);

            }
        });
        beslenme.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(OgrenciProfili.this, BeslenmeActivity.class);
                OgrenciProfili.this.startActivity(myIntent);

            }
        });
        sinav_takvimi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(OgrenciProfili.this, SinavTakvimiActivity.class);
                OgrenciProfili.this.startActivity(myIntent);
            }
        });
        servis_saatleri.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(OgrenciProfili.this, ServisSaatleri.class);
                OgrenciProfili.this.startActivity(myIntent);
            }
        });
    }
    //geri tuşuna basınca direkt uygulamadan cıkarma
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            startActivity(new Intent(this, LoginPage.class));
        }
        return super.onKeyDown(keyCode, event);
    }
}
