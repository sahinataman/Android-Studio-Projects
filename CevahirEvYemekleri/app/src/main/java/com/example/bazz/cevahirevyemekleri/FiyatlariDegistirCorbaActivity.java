package com.example.bazz.cevahirevyemekleri;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.bazz.cevahirevyemekleri.Database.CorbalarDB;
import com.example.bazz.cevahirevyemekleri.SqlLiteDB.CevahirSQLDB;

public class FiyatlariDegistirCorbaActivity extends Activity {
    ImageButton geri_buton;
    String str_domates,str_ezogelin,str_iskembe,str_paca,str_mercimek,str_sebze,str_tarhana,str_tavuksuyu,str_yayla;
    Button guncelle;
    EditText yeni_domates ,yeni_ezogelin,yeni_iskembe ,yeni_paca ,yeni_mercimek ,yeni_sebze ,yeni_tarhana,yeni_tavuksuyu ,yeni_yayla;
    CevahirSQLDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiyatlari_degistir_corba);

        db = new CevahirSQLDB(getApplicationContext());

        yeni_domates = (EditText)findViewById(R.id.yeni_domates_fiyat);
        yeni_ezogelin = (EditText)findViewById(R.id.yeni_ezogelin_fiyati);
        yeni_iskembe = (EditText)findViewById(R.id.yeni_iskembe_fiyati);
        yeni_paca = (EditText)findViewById(R.id.yeni_paca_fiyati);
        yeni_mercimek = (EditText)findViewById(R.id.yeni_mercimek_fiyati);
        yeni_sebze = (EditText)findViewById(R.id.yeni_sebze_fiyati);
        yeni_tarhana = (EditText)findViewById(R.id.yeni_tarhana_fiyati);
        yeni_tavuksuyu = (EditText)findViewById(R.id.yeni_tavuksuyu_fiyati);
        yeni_yayla = (EditText)findViewById(R.id.yeni_yayla_fiyati);

        CorbalarDB a1 = db.getCorba( 1 );
        CorbalarDB b1 = db.getCorba( 2 );
        CorbalarDB c1 = db.getCorba( 3 );
        CorbalarDB d1 = db.getCorba( 4 );
        CorbalarDB e1 = db.getCorba( 5 );
        CorbalarDB f1 = db.getCorba( 6 );
        CorbalarDB g1 = db.getCorba( 7 );
        CorbalarDB h1 = db.getCorba( 8 );
        CorbalarDB j1 = db.getCorba( 9 );

        yeni_domates.setText( a1.corba_fiyati );
        yeni_ezogelin.setText( b1.corba_fiyati );
        yeni_paca.setText( c1.corba_fiyati );
        yeni_iskembe.setText( d1.corba_fiyati );
        yeni_mercimek.setText( e1.corba_fiyati );
        yeni_sebze.setText( f1.corba_fiyati );
        yeni_tarhana.setText( g1.corba_fiyati );
        yeni_tavuksuyu.setText( h1.corba_fiyati );
        yeni_yayla.setText( j1.corba_fiyati );

        geri_buton = (ImageButton)findViewById( R.id.geriBTN );
        geri_buton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });
        guncelle=(Button)findViewById(R.id.guncelleBTN);
        guncelle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                str_domates = yeni_domates.getText().toString();
                str_ezogelin = yeni_ezogelin.getText().toString();
                str_iskembe = yeni_iskembe.getText().toString();
                str_paca= yeni_paca.getText().toString();
                str_mercimek = yeni_mercimek.getText().toString();
                str_sebze = yeni_sebze.getText().toString();
                str_tarhana = yeni_tarhana.getText().toString();
                str_tavuksuyu = yeni_tavuksuyu.getText().toString();
                str_yayla = yeni_yayla.getText().toString();

                CorbalarDB a = db.getCorba( 1 );
                CorbalarDB b = db.getCorba( 2 );
                CorbalarDB c = db.getCorba( 3 );
                CorbalarDB d = db.getCorba( 4 );
                CorbalarDB e = db.getCorba( 5 );
                CorbalarDB f = db.getCorba( 6 );
                CorbalarDB g = db.getCorba( 7 );
                CorbalarDB h = db.getCorba( 8 );
                CorbalarDB j = db.getCorba( 9 );

                a.corba_fiyati=str_domates;
                b.corba_fiyati=str_ezogelin;
                c.corba_fiyati=str_iskembe;
                d.corba_fiyati=str_paca;
                e.corba_fiyati=str_mercimek;
                f.corba_fiyati=str_sebze;
                g.corba_fiyati=str_tarhana;
                h.corba_fiyati=str_tavuksuyu;
                j.corba_fiyati=str_yayla;

                db.updateCorba(a);
                db.updateCorba(b);
                db.updateCorba(c);
                db.updateCorba(d);
                db.updateCorba(e);
                db.updateCorba(f);
                db.updateCorba(g);
                db.updateCorba(h);
                db.updateCorba(j);

                showMessage("BAŞARILI", "Çorba fiyatları başarılı bir şekilde güncellenmiştir. ");


            }
        });


    }
    public void showMessage(String baslik,String mesaj)
    {
        android.support.v7.app.AlertDialog alertDialog = new android.support.v7.app.AlertDialog.Builder(FiyatlariDegistirCorbaActivity.this).create();
        alertDialog.setTitle(baslik);
        alertDialog.setIcon( R.drawable.cevahir_logom );
        alertDialog.setMessage(mesaj);
        alertDialog.setCancelable(false);
        alertDialog.setButton(RESULT_OK,"Tamam", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                onBackPressed();
            }
        });
        alertDialog.show();
    }
}
