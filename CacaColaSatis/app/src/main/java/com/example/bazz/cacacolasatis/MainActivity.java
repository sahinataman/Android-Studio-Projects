package com.example.bazz.cacacolasatis;

import android.annotation.TargetApi;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=openOrCreateDatabase("ICECEKHESAPLAMA",MODE_PRIVATE,null);
        String createQuery="Create table if not exists Icecek (_id integer primary key autoincrement, drinkname text,drinkdate text)";
        db.execSQL(createQuery);
    }
    public  void KolaOnClick(View view){
        String txtkola="250ml Kola içildi.";
        addDrink(txtkola);
        Toast.makeText(this,"1 KOLA(250ml) eklendi",Toast.LENGTH_SHORT).show();
    }
    public  void FantaOnClick(View view){
        String txtfanta="200ml Fanta içildi.";
        addDrink(txtfanta);
        Toast.makeText(this,"1 FANTA(200ml) eklendi",Toast.LENGTH_SHORT).show();
    }
    public  void IceTeaOnClick(View view){
        String txticetea="250ml IceTea içildi.";
        addDrink(txticetea);
        Toast.makeText(this,"1 ICE TEA(250ml) eklendi",Toast.LENGTH_SHORT).show();
    }
    public  void SodaOnClick(View view){
        String txtsoda="200ml Limonlu Soda içildi.";
        addDrink(txtsoda);
        Toast.makeText(this,"1 SODA(200ml) eklendi",Toast.LENGTH_SHORT).show();
    }
    public  void SeftaliOnClick(View view){
        String txtkola="250ml Şeftali Nektar içildi.";
        addDrink(txtkola);
        Toast.makeText(this,"1 ŞEFTALİ(250ml) eklendi",Toast.LENGTH_SHORT).show();
    }
    public  void AyranOnClick(View view){
        String txtayran="250ml Ayran içildi.";
        addDrink(txtayran);
        Toast.makeText(this,"1 AYRAN(250ml) eklendi",Toast.LENGTH_SHORT).show();
    }
    public  void ArsivOnClick(View view){
        Intent ArsivAc = new Intent(this,IcecekArsivi.class);
        startActivity(ArsivAc);
    }

    @TargetApi(Build.VERSION_CODES.N)
    public void addDrink(String drinkname){
        db=openOrCreateDatabase("ICECEKHESAPLAMA",MODE_PRIVATE,null);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat mydate= new SimpleDateFormat("yyyy-MM-dd HH:mm.ss");
        String drinkdate=mydate.format(c.getTime());
        String insertQuery="insert into Icecek(drinkname,drinkdate) values ('";
        insertQuery+=drinkname+"','"+drinkdate+"')";
        db.execSQL(insertQuery);
    }



}
