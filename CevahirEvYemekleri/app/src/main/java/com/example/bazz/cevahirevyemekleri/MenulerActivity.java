package com.example.bazz.cevahirevyemekleri;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.bazz.cevahirevyemekleri.Database.MenulerDB;
import com.example.bazz.cevahirevyemekleri.SqlLiteDB.CevahirSQLDB;

public class MenulerActivity extends AppCompatActivity {

    ImageButton geri_buton;
    TextView eski_kucuk,eski_orta,eski_buyuk,eski_ogrenci,eski_cevahir,eski_menu1,eski_menu2,eski_menu3;
    CevahirSQLDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuler);

        eski_kucuk = (TextView)findViewById(R.id.eski_kucuk_fiyati);
        eski_orta = (TextView)findViewById(R.id.eski_orta_fiyati);
        eski_buyuk = (TextView)findViewById(R.id.eski_buyuk_fiyati);
        eski_ogrenci = (TextView)findViewById(R.id.eski_ogrenci_fiyati);
        eski_cevahir = (TextView)findViewById(R.id.eski_cevahir_fiyati);
        eski_menu1 = (TextView)findViewById(R.id.eski_menu1_fiyati);
        eski_menu2 = (TextView)findViewById(R.id.eski_menu2_fiyati);
        eski_menu3 = (TextView)findViewById(R.id.eski_menu3_fiyati);

        db = new CevahirSQLDB(getApplicationContext());

        //MENU VERİLERİ

        MenulerDB kucuk = new MenulerDB( 1,"Küçük Tabak","8 TL" );
        MenulerDB orta = new MenulerDB( 2,"Orta Tabak","9 TL" );
        MenulerDB buyuk = new MenulerDB( 3,"Büyük Tabak","10 TL" );
        MenulerDB ogrenci = new MenulerDB( 4,"Ogrenci Menü","8 TL" );
        MenulerDB cevahir = new MenulerDB( 5,"Cevahir Menü","10 TL" );
        MenulerDB menu1 = new MenulerDB( 6,"Menü 1","12 TL" );
        MenulerDB menu2 = new MenulerDB( 7,"Menü 2","13 TL" );
        MenulerDB menu3 = new MenulerDB( 8,"Menü 3","14 TL" );

        db.createMenu( kucuk );
        db.createMenu( buyuk );
        db.createMenu( orta );
        db.createMenu( ogrenci );
        db.createMenu( cevahir );
        db.createMenu( menu1 );
        db.createMenu( menu2 );
        db.createMenu( menu3 );

        MenulerDB a = db.getMenu( 1 );
        MenulerDB b = db.getMenu( 2 );
        MenulerDB c = db.getMenu( 3 );
        MenulerDB d = db.getMenu( 4 );
        MenulerDB e = db.getMenu( 5 );
        MenulerDB f = db.getMenu( 6 );
        MenulerDB g = db.getMenu( 7 );
        MenulerDB h = db.getMenu( 8 );

        eski_kucuk.setText( a.menu_fiyati );
        eski_orta.setText( b.menu_fiyati );
        eski_buyuk.setText( c.menu_fiyati );
        eski_ogrenci.setText( d.menu_fiyati );
        eski_cevahir.setText( e.menu_fiyati );
        eski_menu1.setText( f.menu_fiyati );
        eski_menu2.setText( g.menu_fiyati );
        eski_menu3.setText( h.menu_fiyati );

        db.closeDB();

        //Bir Onceki layout a geri dönme
        geri_buton = (ImageButton) findViewById(R.id.geriBTN);
        geri_buton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
