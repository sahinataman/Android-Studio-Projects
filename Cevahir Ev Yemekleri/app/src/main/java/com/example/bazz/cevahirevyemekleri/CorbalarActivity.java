package com.example.bazz.cevahirevyemekleri;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.bazz.cevahirevyemekleri.Database.CorbalarDB;
import com.example.bazz.cevahirevyemekleri.SqlLiteDB.CevahirSQLDB;

import java.util.List;

public class CorbalarActivity extends Activity {
    ImageButton geri_buton;
    TextView eski_ezo,eski_paca,eski_iskembe,eski_mercimek,eski_sebze,eski_tarhana,eski_tavuksuyu,eski_yayla, eski_domates;
    public static List<CorbalarDB> corbalar;
    CevahirSQLDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corbalar);

        eski_domates = (TextView)findViewById(R.id.eski_domates_fiyati);
        eski_ezo = (TextView)findViewById(R.id.eski_ezogelin_fiyati);
        eski_paca = (TextView)findViewById(R.id.eski_kellepaca_fiyati);
        eski_iskembe = (TextView)findViewById(R.id.eski_iskembe_fiyati);
        eski_mercimek = (TextView)findViewById(R.id.eski_mercimek_fiyati);
        eski_sebze = (TextView)findViewById(R.id.eski_sebze_fiyati);
        eski_tarhana = (TextView)findViewById(R.id.eski_tarhana_fiyati);
        eski_tavuksuyu = (TextView)findViewById(R.id.eski_tavuksuyu_fiyati);
        eski_yayla = (TextView)findViewById(R.id.eski_yayla_fiyati);


        db = new CevahirSQLDB(getApplicationContext());


        //CORBA VERİLERİ

        CorbalarDB domates = new CorbalarDB( 0,"Domates Çorbası","5  TL" );
        CorbalarDB ezo = new CorbalarDB( 1,"Ezogelin Çorbası","6 TL" );
        CorbalarDB paca = new CorbalarDB( 2,"KellePaça Çorbası","7 TL" );
        CorbalarDB iskembe = new CorbalarDB( 3,"İşkembe Çorbası","8 TL" );
        CorbalarDB mercimek = new CorbalarDB( 4,"Mercimek Çorbası","9 TL" );
        CorbalarDB sebze = new CorbalarDB( 5,"Sebze Çorbası","10  TL" );
        CorbalarDB tarhana = new CorbalarDB( 6,"Tarhana Çorbası","11 TL" );
        CorbalarDB tavuksuyu = new CorbalarDB( 7,"Tavuksuyu Çorbası","12 TL" );
        CorbalarDB yayla = new CorbalarDB( 8,"Yayla Çorbası","13 TL" );

        db.createCorba(domates);
        db.createCorba(ezo);
        db.createCorba(paca);
        db.createCorba(iskembe);
        db.createCorba(mercimek);
        db.createCorba(sebze);
        db.createCorba(tarhana);
        db.createCorba(tavuksuyu);
        db.createCorba(yayla);

        CorbalarDB a = db.getCorba( 1 );
        CorbalarDB b = db.getCorba( 2 );
        CorbalarDB c = db.getCorba( 3 );
        CorbalarDB d = db.getCorba( 4 );
        CorbalarDB e = db.getCorba( 5 );
        CorbalarDB f = db.getCorba( 6 );
        CorbalarDB g = db.getCorba( 7 );
        CorbalarDB h = db.getCorba( 8 );
        CorbalarDB j = db.getCorba( 9 );

        eski_domates.setText( a.corba_fiyati );
        eski_ezo.setText( b.corba_fiyati );
        eski_paca.setText( c.corba_fiyati );
        eski_iskembe.setText( d.corba_fiyati );
        eski_mercimek.setText( e.corba_fiyati );
        eski_sebze.setText( f.corba_fiyati );
        eski_tarhana.setText( g.corba_fiyati );
        eski_tavuksuyu.setText( h.corba_fiyati );
        eski_yayla.setText( j.corba_fiyati );

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
