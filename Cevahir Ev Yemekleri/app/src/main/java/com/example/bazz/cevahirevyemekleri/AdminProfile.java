package com.example.bazz.cevahirevyemekleri;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class AdminProfile extends AppCompatActivity {


    TextView adSoyad,Tc,tarih;
    Button corba_fiyati_degistir, icecek_fiyati_degistir,izgara_fiyati_degistir,menu_fiyati_degistir,tatli_fiyati_degistir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_profil);

        adSoyad=(TextView)findViewById(R.id.adsoyadTV);
        tarih = (TextView) findViewById(R.id.tarihTV);
        Tc = (TextView) findViewById(R.id.tcTV);

        //Tarih İçin DaTe cekiyoruz
        long date = System.currentTimeMillis();
        SimpleDateFormat zmn = new SimpleDateFormat(" dd/MM/yyyy ");
        String dateString = zmn.format(date);
        tarih.setText(dateString);

        //Burda LoginPage sınıfından gelen numara ve Ogrenci Adını cekiyorum
        Intent intent = getIntent();
        final String ad  = intent.getStringExtra("GelenADSOYAD");
        final String tc  = intent.getStringExtra("GelenTC");

        SharedPreferences mSharedPrefs = getSharedPreferences("kayitDostasi",MODE_APPEND);
        SharedPreferences.Editor mPrefsEditor = mSharedPrefs.edit();
        if(ad!=null) {
            mPrefsEditor.putString("keydeger", ad);
            mPrefsEditor.putString("keydeger2", tc);
        }

        String name= mSharedPrefs.getString("keydeger","NULL");
        String TC = mSharedPrefs.getString("keydeger2","NULL");

        mPrefsEditor.commit();


        adSoyad.setText(name);
        Tc.setText(TC);

        //Adminin yapabileceği işlemler
        corba_fiyati_degistir = (Button)findViewById(R.id.corbaFYTdegistirBTN);
        corba_fiyati_degistir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(AdminProfile.this, FiyatlariDegistirCorbaActivity.class);
                AdminProfile.this.startActivity(myIntent);
            }
        });

        icecek_fiyati_degistir = (Button)findViewById(R.id.icecekFYTdegistirBTN);
        icecek_fiyati_degistir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(AdminProfile.this, FiyatlariDegistirIcecekActivity.class);
                AdminProfile.this.startActivity(myIntent);
            }
        });
        izgara_fiyati_degistir = (Button)findViewById(R.id.izgaraFYTdegistirBTN);
        izgara_fiyati_degistir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(AdminProfile.this, FiyatlariDegistirIzgaraActivity.class);
                AdminProfile.this.startActivity(myIntent);
            }
        });
        menu_fiyati_degistir = (Button)findViewById(R.id.menuFYTdegistirBTN);
        menu_fiyati_degistir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(AdminProfile.this, FiyatlariDegistirMenuActivity.class);
                AdminProfile.this.startActivity(myIntent);
            }
        });
        tatli_fiyati_degistir = (Button)findViewById(R.id.tatliFYTdegistirBTN);
        tatli_fiyati_degistir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(AdminProfile.this, FiyatlariDegistirTatliActivity.class);
                AdminProfile.this.startActivity(myIntent);
            }
        });



    }
    //geri tuşuna basınca direkt uygulamadan cıkarma
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Çıkış")
                    .setMessage("Uygulamadan çıkmak istediğinize emin misiniz?")
                    .setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(AdminProfile.this,LoginPage.class);
                            startActivity(intent);
                        }
                    }).setNegativeButton("Hayır", null).show();
        }
        return super.onKeyDown(keyCode, event);
    }
}
