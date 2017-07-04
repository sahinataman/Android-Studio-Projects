package com.example.bazz.adaokulu.OBS;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.bazz.adaokulu.R;
import com.example.bazz.adaokulu.Siniflar.BeslenmeTakvimi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BeslenmeActivity extends AppCompatActivity {
    List<BeslenmeTakvimi> yemekler;
    ImageButton geri_buton;
    TextView tarih,corba,yemek_bir,yemek_iki,icecek,tatli;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beslenme);

        tarih=(TextView)findViewById(R.id.tarihTV);
        corba=(TextView)findViewById(R.id.corbaTV);
        yemek_bir=(TextView)findViewById(R.id.anayemekTV);
        yemek_iki=(TextView)findViewById(R.id.yemekTV);
        tatli=(TextView)findViewById(R.id.tatliTV);
        icecek=(TextView)findViewById(R.id.icecekTV);


        yemekler = new ArrayList<BeslenmeTakvimi>();
        yemekler.add(new BeslenmeTakvimi("18/08/2016","Tavuksuyu Çorba","Çiftlik Kebabı","Bulgur Pilavı","Kemalpaşa Tatlısı","Ayran"));
        yemekler.add(new BeslenmeTakvimi("19/08/2016","Mercimek Çorbası","Kuru Fasulye","Pirinç Pilavı","Şıllık Tatlısı","Caca-Cola"));
        yemekler.add(new BeslenmeTakvimi("20/08/2016","Domates Çorba","Orman Kebabı","Fırında Makarna","Kadayıf Tatlısı","Ice Tea"));
        yemekler.add(new BeslenmeTakvimi("21/08/2016","Alaçatı Çorba","Tavuk Sote","Melek Pilavı","Revani Tatlısı","Karışık Nektar"));

        //Tarih İçin DaTe cekiyoruz
        long date = System.currentTimeMillis();
        SimpleDateFormat zmn = new SimpleDateFormat("dd/MM/yyyy");
        String bugun = zmn.format(date);

        tarih.setText(bugun);

        for(BeslenmeTakvimi b: yemekler ){
            if(bugun.equals(b.Tarih)){
                corba.setText(b.Corba);
                yemek_bir.setText(b.Yemek1);
                yemek_iki.setText(b.Yemek2);
                tatli.setText(b.Tatli);
                icecek.setText(b.Icecek);
            }

        }










        geri_buton=(ImageButton)findViewById(R.id.geriBTN);
        geri_buton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

}