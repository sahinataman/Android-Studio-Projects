package com.example.bazz.cevahirevyemekleri;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.bazz.cevahirevyemekleri.Database.TatlilarDB;
import com.example.bazz.cevahirevyemekleri.SqlLiteDB.CevahirSQLDB;

import static com.example.bazz.cevahirevyemekleri.R.layout.activity_tatlilar;

public class TatlilarActivity extends AppCompatActivity {
    ImageButton geri_buton;
    TextView eski_sutlac,eski_trilice,eski_kazandibi,eski_tiramisu,eski_revani,eski_mozaik,eski_kemalpasa,eski_irmik;
    CevahirSQLDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_tatlilar);

        db = new CevahirSQLDB(getApplicationContext());

        eski_sutlac = (TextView)findViewById( R.id.eski_sutlac_fiyati ) ;
        eski_trilice = (TextView)findViewById( R.id.eski_trilice_fiyati ) ;
        eski_kazandibi = (TextView)findViewById( R.id.eski_kazandibi_fiyati ) ;
        eski_tiramisu = (TextView)findViewById( R.id.eski_tiramisu_fiyati ) ;
        eski_revani = (TextView)findViewById( R.id.eski_revani_fiyati ) ;
        eski_mozaik = (TextView)findViewById( R.id.eski_mozaik_fiyati ) ;
        eski_kemalpasa = (TextView)findViewById( R.id.eski_kemalpasa_fiyati ) ;
        eski_irmik = (TextView)findViewById( R.id.eski_irmik_fiyati ) ;

        TatlilarDB sutlac = new TatlilarDB( 1,"Sütlaç","5  TL" );
        TatlilarDB trilice = new TatlilarDB( 1,"Triliçe","7  TL" );
        TatlilarDB kazandibi = new TatlilarDB( 1,"Kazandibi","5  TL" );
        TatlilarDB tiramisu = new TatlilarDB( 1,"Tiramisu","5  TL" );
        TatlilarDB revani = new TatlilarDB( 1,"Revani","6  TL" );
        TatlilarDB mozaik = new TatlilarDB( 1,"Mozaik","4  TL" );
        TatlilarDB kemalpasa = new TatlilarDB( 1,"Kemalpaşa","6  TL" );
        TatlilarDB irmik = new TatlilarDB( 1,"İrmik","5  TL" );

        db.createTatli(sutlac);
        db.createTatli(trilice);
        db.createTatli(kazandibi);
        db.createTatli(tiramisu);
        db.createTatli(revani);
        db.createTatli(mozaik);
        db.createTatli(kemalpasa);
        db.createTatli(irmik);

        TatlilarDB a = db.getTatli( 1 );
        TatlilarDB b = db.getTatli( 2 );
        TatlilarDB c = db.getTatli( 3 );
        TatlilarDB d = db.getTatli( 4 );
        TatlilarDB e = db.getTatli( 5 );
        TatlilarDB f = db.getTatli( 6 );
        TatlilarDB g = db.getTatli( 7 );
        TatlilarDB h = db.getTatli( 8 );

        eski_sutlac.setText( a.tatli_fiyati );
        eski_trilice.setText( b.tatli_fiyati );
        eski_kazandibi.setText( c.tatli_fiyati );
        eski_tiramisu.setText( d.tatli_fiyati );
        eski_revani.setText( e.tatli_fiyati );
        eski_mozaik.setText( f.tatli_fiyati );
        eski_kemalpasa.setText( g.tatli_fiyati );
        eski_irmik.setText( h.tatli_fiyati );
        //Bir Onceki layout a geri dönme
        geri_buton = (ImageButton) findViewById(R.id.geriBTN);
        geri_buton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });

        db.closeDB();
    }
}
