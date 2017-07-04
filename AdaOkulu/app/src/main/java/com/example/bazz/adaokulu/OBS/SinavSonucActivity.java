package com.example.bazz.adaokulu.OBS;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.bazz.adaokulu.Siniflar.OgrenciSinifi;
import com.example.bazz.adaokulu.R;

import java.util.ArrayList;
import java.util.List;

public class SinavSonucActivity extends AppCompatActivity {
    List<OgrenciSinifi> ders_notlari;
    TextView mat1,mat2,mat3,turkce1,turkce2,turkce3,sosyal1,sosyal2,sosyal3,fen1,fen2,fen3;
    TextView genelMAT,genelFEN,genelSOSYAL,genelTURKCE;
    TextView adSOYAD,ogrNO;
    ImageButton geri_buton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinav_sonuclari);


        //Burda LoginPage sınıfından gelen numara ve Ogrenci Adını cekiyorum
        Intent gelen = getIntent();
        String ad  = gelen.getStringExtra("GelenADSOYAD");
        String no  = gelen.getStringExtra("GelenNO");


        SharedPreferences mSharedPrefs = getSharedPreferences("kayitDostasi",MODE_APPEND);
        SharedPreferences.Editor mPrefsEditor = mSharedPrefs.edit();

        if(ad!=null) {
            mPrefsEditor.putString("keydeger", ad);
            mPrefsEditor.putString("keydeger2", no);
        }

        String name= mSharedPrefs.getString("keydeger","NULL");
        String numara = mSharedPrefs.getString("keydeger2","NULL");

        mPrefsEditor.commit();

        adSOYAD=(TextView)findViewById(R.id.isimTV);
        ogrNO =(TextView)findViewById(R.id.noTV);

        adSOYAD.setText(name);
        ogrNO.setText(numara);



        mat1=(TextView)findViewById(R.id.mat1TV);
        mat2=(TextView)findViewById(R.id.mat2TV);
        mat3=(TextView)findViewById(R.id.mat3TV);
        sosyal1=(TextView)findViewById(R.id.sosyal1TV);
        sosyal2=(TextView)findViewById(R.id.sosyal2TV);
        sosyal3=(TextView)findViewById(R.id.sosyal3TV);
        turkce1=(TextView)findViewById(R.id.turkce1TV);
        turkce2=(TextView)findViewById(R.id.turkce2TV);
        turkce3=(TextView)findViewById(R.id.turkce3TV);
        fen1=(TextView)findViewById(R.id.fen1TV);
        fen2=(TextView)findViewById(R.id.fen2TV);
        fen3=(TextView)findViewById(R.id.fen3TV);

        genelFEN=(TextView)findViewById(R.id.fengenel);
        genelMAT=(TextView)findViewById(R.id.matgenel);
        genelTURKCE=(TextView)findViewById(R.id.turkcegenel);
        genelSOSYAL=(TextView)findViewById(R.id.sosyalgenel);


        //Ogrencinin ders notlarıonı elle burdan girdim;
        ders_notlari = new ArrayList<OgrenciSinifi>();
        //                                  AD         NUMARA      M1   S1  F1   T1    M2   S2  F2    T2   M3   S3  F3   T3
        ders_notlari.add(new OgrenciSinifi("Bager Temel","123502454","80","90","85","65","60","80","90","70","65","60","80","90"));
        ders_notlari.add(new OgrenciSinifi("Şahin Ataman","130401025","95","82","88","96","90","85","65","60","80","90","70","65"));
        ders_notlari.add(new OgrenciSinifi("Serhat Uce","130142525","45","58","87","84","82","88","96","90","85","65","60","76"));
        ders_notlari.add(new OgrenciSinifi("Gökhan Özdemir","120501203","66","54","48","25","58","87","84","82","88","96","90","85"));


        for (OgrenciSinifi k : ders_notlari) {
            if(k.Adi.equals(name)){
                mat1.setText(k.MatNotu1);  mat2.setText(k.MatNotu2);  mat3.setText(k.MatNotu3);
                sosyal1.setText(k.SosyalNotu1);  sosyal2.setText(k.SosyalNotu2);  sosyal3.setText(k.SosyalNotu3);
                turkce1.setText(k.TürkceNotu1);  turkce2.setText(k.TürkceNotu2);  turkce3.setText(k.TürkceNotu3);
                fen1.setText(k.FenNotu1);  fen2.setText(k.FenNotu2);  fen3.setText(k.FenNotu3);

                float genel_mat,genel_fen,genel_turkce, genel_sosyal;
                genel_mat=(Integer.parseInt(k.MatNotu1)+Integer.parseInt(k.MatNotu2)+Integer.parseInt(k.MatNotu3))/3;
                genel_turkce=(Integer.parseInt(k.TürkceNotu1)+Integer.parseInt(k.TürkceNotu2)+Integer.parseInt(k.TürkceNotu3))/3;
                genel_sosyal=(Integer.parseInt(k.SosyalNotu1)+Integer.parseInt(k.SosyalNotu2)+Integer.parseInt(k.SosyalNotu3))/3;
                genel_fen=genel_mat=(Integer.parseInt(k.FenNotu1)+Integer.parseInt(k.FenNotu2)+Integer.parseInt(k.FenNotu3))/3;

                genelMAT.setText(" "+genel_mat);
                genelTURKCE.setText(" "+genel_turkce);
                genelFEN.setText(" "+genel_fen);
                genelSOSYAL.setText(" "+genel_sosyal);
            }
        }

        //Toolbarda geri iconuna basılma durumunda
        geri_buton=(ImageButton)findViewById(R.id.geriBTN);
        geri_buton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent geri = new Intent(SinavSonucActivity.this, OgrenciProfili.class);
                startActivity(geri);
                finish();
            }
        });

    }
    //geri tuşuna basınca direkt uygulamadan cıkarma
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            startActivity(new Intent(this, OgrenciProfili.class));
        }
        return super.onKeyDown(keyCode, event);
    }

}

