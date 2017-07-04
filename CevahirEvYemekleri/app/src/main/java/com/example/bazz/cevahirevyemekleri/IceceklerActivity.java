package com.example.bazz.cevahirevyemekleri;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.bazz.cevahirevyemekleri.Database.IceceklerDB;
import com.example.bazz.cevahirevyemekleri.SqlLiteDB.CevahirSQLDB;

import java.util.List;

public class IceceklerActivity extends AppCompatActivity {
    ImageButton geri_buton;
    TextView eski_fanta,eski_cacacola,eski_zero,eski_light,eski_iceseftali,eski_fusetea,eski_sprite,eski_sefnektar,eski_pornektar,eski_visnenektar,eski_meyvelisoda,eski_sadesoda,eski_ayran,eski_su;
    public static List<IceceklerDB> icecekler;
    CevahirSQLDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icecekler);

        eski_fanta = (TextView)findViewById(R.id.eski_fanta_fiyati);
        eski_cacacola = (TextView)findViewById(R.id.eski_cacacola_fiyati);
        eski_zero = (TextView)findViewById(R.id.eski_zero_fiyati);
        eski_light = (TextView)findViewById(R.id.eski_light_fiyati);
        eski_iceseftali = (TextView)findViewById(R.id.eski_iceseftali_fiyati);
        eski_fusetea = (TextView)findViewById(R.id.eski_fusetea_fiyati);
        eski_sprite = (TextView)findViewById(R.id.eski_sprite_fiyati);
        eski_sefnektar = (TextView)findViewById(R.id.eski_sefnektar_fiyati);
        eski_pornektar = (TextView)findViewById(R.id.eski_pornektar_fiyati);
        eski_visnenektar = (TextView)findViewById(R.id.eski_visnenektar_fiyati);
        eski_meyvelisoda = (TextView)findViewById(R.id.eski_meyvelisoda_fiyati);
        eski_sadesoda = (TextView)findViewById(R.id.eski_sadesoda_fiyati);
        eski_ayran = (TextView)findViewById(R.id.eski_ayran_fiyati);
        eski_su = (TextView)findViewById(R.id.eski_su_fiyati);

        db = new CevahirSQLDB(getApplicationContext());


        //İÇECEK VERİLERİ

        IceceklerDB fanta = new IceceklerDB( 1,"Fanta","4  TL" );
        IceceklerDB cacacola = new IceceklerDB( 2,"Cacacola","4  TL" );
        IceceklerDB zero = new IceceklerDB( 3,"Zero","4  TL" );
        IceceklerDB light = new IceceklerDB( 4,"Light","4  TL" );
        IceceklerDB iceseftali = new IceceklerDB( 5,"Icetea Şeftali ","4  TL" );
        IceceklerDB fusetea = new IceceklerDB( 6,"Domates Çorbası","4  TL" );
        IceceklerDB sprite = new IceceklerDB( 7,"Fuse Tea Limon","4  TL" );
        IceceklerDB sefnektar = new IceceklerDB( 8,"Şeftali Nektar","4  TL" );
        IceceklerDB pornektar = new IceceklerDB( 9,"Portakal Nektar","4  TL" );
        IceceklerDB visnenektar = new IceceklerDB( 10,"Vişne Nektar","4  TL" );
        IceceklerDB meyvelisoda = new IceceklerDB( 11,"Meyveli Soda","2  TL" );
        IceceklerDB sadesoda = new IceceklerDB( 12,"Sade Soda","2  TL" );
        IceceklerDB ayran = new IceceklerDB( 13,"Ayran","1  TL" );
        IceceklerDB su = new IceceklerDB( 14,"Su","1  TL" );

        db.createIcecek( fanta );
        db.createIcecek( cacacola );
        db.createIcecek( zero );
        db.createIcecek( light );
        db.createIcecek( iceseftali );
        db.createIcecek( fusetea );
        db.createIcecek( sprite );
        db.createIcecek( sefnektar );
        db.createIcecek( pornektar );
        db.createIcecek( visnenektar );
        db.createIcecek( meyvelisoda );
        db.createIcecek( sadesoda );
        db.createIcecek( ayran );
        db.createIcecek( su );

        IceceklerDB a = db.getIcecek( 1 );
        IceceklerDB b = db.getIcecek( 2 );
        IceceklerDB c = db.getIcecek( 3 );
        IceceklerDB d = db.getIcecek( 4 );
        IceceklerDB e = db.getIcecek( 5 );
        IceceklerDB f = db.getIcecek( 6 );
        IceceklerDB g = db.getIcecek( 7 );
        IceceklerDB h = db.getIcecek( 8 );
        IceceklerDB j = db.getIcecek( 9 );
        IceceklerDB k = db.getIcecek( 10 );
        IceceklerDB l = db.getIcecek( 11 );
        IceceklerDB m = db.getIcecek( 12 );
        IceceklerDB n = db.getIcecek( 13 );
        IceceklerDB p = db.getIcecek( 14 );


        eski_fanta.setText( a.icecek_fiyati );
        eski_cacacola.setText( b.icecek_fiyati );
        eski_zero.setText( c.icecek_fiyati );
        eski_light.setText( d.icecek_fiyati );
        eski_iceseftali.setText( e.icecek_fiyati );
        eski_fusetea.setText( f.icecek_fiyati );
        eski_sprite.setText( g.icecek_fiyati );
        eski_sefnektar.setText( h.icecek_fiyati );
        eski_pornektar.setText( j.icecek_fiyati );
        eski_visnenektar.setText( k.icecek_fiyati );
        eski_meyvelisoda.setText( l.icecek_fiyati );
        eski_sadesoda.setText( m.icecek_fiyati );
        eski_ayran.setText( n.icecek_fiyati );
        eski_su.setText( p.icecek_fiyati );

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
