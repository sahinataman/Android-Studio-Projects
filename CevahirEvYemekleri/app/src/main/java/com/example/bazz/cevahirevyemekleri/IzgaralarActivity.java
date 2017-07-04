package com.example.bazz.cevahirevyemekleri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.bazz.cevahirevyemekleri.Database.IzgaralarDB;
import com.example.bazz.cevahirevyemekleri.SqlLiteDB.CevahirSQLDB;

import java.util.List;

public class IzgaralarActivity extends AppCompatActivity {
    TextView eski_tavuk,eski_kofte,eski_karisik,eski_sis,eski_kebap,eski_kanat,eski_but;
    ImageButton geri_buton;
    public static List<IzgaralarDB> izgaralar;
    CevahirSQLDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_izgaralar);

        eski_tavuk = (TextView)findViewById(R.id.eski_tavukizgara_fiyati);
        eski_kofte = (TextView)findViewById(R.id.eski_kofte_fiyati);
        eski_karisik = (TextView)findViewById(R.id.eski_karisik_fiyati);
        eski_sis = (TextView)findViewById(R.id.eski_sis_fiyati);
        eski_kebap = (TextView)findViewById(R.id.eski_kebap_fiyati);
        eski_kanat = (TextView)findViewById(R.id.eski_kanat_fiyati);
        eski_but = (TextView)findViewById(R.id.eski_but_fiyati);

        db = new CevahirSQLDB(getApplicationContext());


        IzgaralarDB tavuk = new IzgaralarDB( 1,"Tavuk Izgara","11  TL" );
        IzgaralarDB kofte = new IzgaralarDB( 1,"Köfte Izgara","22  TL" );
        IzgaralarDB karisik = new IzgaralarDB( 1,"Karisik Izgara","33  TL" );
        IzgaralarDB sis = new IzgaralarDB( 1,"Tavuk Şiş Izgara","44  TL" );
        IzgaralarDB kebap = new IzgaralarDB( 1,"Kebap Izgara","55  TL" );
        IzgaralarDB kanat = new IzgaralarDB( 1,"Kanat Izgara","66  TL" );
        IzgaralarDB but = new IzgaralarDB( 1,"But Izgara","77  TL" );

        db.createIzgara( tavuk );
        db.createIzgara( kofte );
        db.createIzgara( karisik );
        db.createIzgara( sis );
        db.createIzgara( kebap );
        db.createIzgara( kanat );
        db.createIzgara( but );

        IzgaralarDB a = db.getIzgara( 1 );
        IzgaralarDB b = db.getIzgara( 2 );
        IzgaralarDB c = db.getIzgara( 3 );
        IzgaralarDB d = db.getIzgara( 4 );
        IzgaralarDB e = db.getIzgara( 5 );
        IzgaralarDB f = db.getIzgara( 6 );
        IzgaralarDB g = db.getIzgara( 7 );

        eski_tavuk.setText( a.izgara_fiyati );
        eski_kofte.setText( b.izgara_fiyati );
        eski_karisik.setText( c.izgara_fiyati );
        eski_sis.setText( d.izgara_fiyati );
        eski_kebap.setText( e.izgara_fiyati );
        eski_kanat.setText( f.izgara_fiyati );
        eski_but.setText( g.izgara_fiyati );

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
