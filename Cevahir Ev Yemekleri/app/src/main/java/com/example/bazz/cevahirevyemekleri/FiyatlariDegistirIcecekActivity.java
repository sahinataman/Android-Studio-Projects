package com.example.bazz.cevahirevyemekleri;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.bazz.cevahirevyemekleri.Database.IceceklerDB;
import com.example.bazz.cevahirevyemekleri.SqlLiteDB.CevahirSQLDB;

public class FiyatlariDegistirIcecekActivity extends AppCompatActivity {

    ImageButton geri_buton;
    String str_fanta,str_cacacola,str_zero,str_light,str_iceseftali,str_fusetea,str_sprite,str_sefnektar,str_pornektar,str_visnenektar,str_meyvelisoda,str_sadesoda,str_ayran,str_su;
    Button guncelle;
    EditText yeni_fanta,yeni_cacacola,yeni_zero,yeni_light,yeni_iceseftali,yeni_fusetea,yeni_sprite,yeni_sefnektar,yeni_pornektar,yeni_visnenektar,yeni_meyvelisoda,yeni_sadesoda,yeni_ayran,yeni_su;
    CevahirSQLDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_fiyatlari_degistir_icecek );

        db = new CevahirSQLDB(getApplicationContext());

        yeni_fanta = (EditText)findViewById(R.id.yeni_fanta_fiyati);
        yeni_cacacola = (EditText)findViewById(R.id.yeni_cacacola_fiyati);
        yeni_zero = (EditText)findViewById(R.id.yeni_zero_fiyati);
        yeni_light = (EditText)findViewById(R.id.yeni_light_fiyati);
        yeni_iceseftali = (EditText)findViewById(R.id.yeni_iceseftali_fiyati);
        yeni_fusetea = (EditText)findViewById(R.id.yeni_fusetea_fiyati);
        yeni_sprite = (EditText)findViewById(R.id.yeni_sprite_fiyati);
        yeni_sefnektar = (EditText)findViewById(R.id.yeni_sefnektar_fiyati);
        yeni_pornektar = (EditText)findViewById(R.id.yeni_pornektar_fiyati);
        yeni_visnenektar = (EditText)findViewById(R.id.yeni_visnenektar_fiyati);
        yeni_meyvelisoda = (EditText)findViewById(R.id.yeni_meyveli_fiyati);
        yeni_sadesoda = (EditText)findViewById(R.id.yeni_sadesoda_fiyati);
        yeni_ayran = (EditText)findViewById(R.id.yeni_ayran_fiyati);
        yeni_su = (EditText)findViewById(R.id.yeni_su_fiyati);

        IceceklerDB a1 = db.getIcecek( 1 );
        IceceklerDB b1 = db.getIcecek( 2 );
        IceceklerDB c1 = db.getIcecek( 3 );
        IceceklerDB d1 = db.getIcecek( 4 );
        IceceklerDB e1 = db.getIcecek( 5 );
        IceceklerDB f1 = db.getIcecek( 6 );
        IceceklerDB g1 = db.getIcecek( 7 );
        IceceklerDB h1 = db.getIcecek( 8 );
        IceceklerDB j1 = db.getIcecek( 9 );
        IceceklerDB k1 = db.getIcecek( 10 );
        IceceklerDB l1 = db.getIcecek( 11 );
        IceceklerDB m1 = db.getIcecek( 12 );
        IceceklerDB n1 = db.getIcecek( 13 );
        IceceklerDB p1 = db.getIcecek( 14 );

        yeni_fanta.setText( a1.icecek_fiyati );
        yeni_cacacola.setText( b1.icecek_fiyati );
        yeni_zero.setText( c1.icecek_fiyati );
        yeni_light.setText( d1.icecek_fiyati );
        yeni_iceseftali.setText( e1.icecek_fiyati );
        yeni_fusetea.setText( f1.icecek_fiyati );
        yeni_sprite.setText( g1.icecek_fiyati );
        yeni_sefnektar.setText( h1.icecek_fiyati );
        yeni_pornektar.setText( j1.icecek_fiyati );
        yeni_visnenektar.setText( k1.icecek_fiyati );
        yeni_meyvelisoda.setText( l1.icecek_fiyati );
        yeni_sadesoda.setText( m1.icecek_fiyati );
        yeni_ayran.setText( n1.icecek_fiyati );
        yeni_su.setText( p1.icecek_fiyati );

        geri_buton = (ImageButton)findViewById( R.id.geriBTN );
        geri_buton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });
        guncelle=(Button)findViewById(R.id.guncelleBTN);
        guncelle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                str_fanta = yeni_fanta.getText().toString();
                str_cacacola = yeni_cacacola.getText().toString();
                str_zero = yeni_zero.getText().toString();
                str_light = yeni_light.getText().toString();
                str_iceseftali = yeni_iceseftali.getText().toString();
                str_fusetea = yeni_fusetea.getText().toString();
                str_sprite = yeni_sprite.getText().toString();
                str_sefnektar = yeni_sefnektar.getText().toString();
                str_pornektar = yeni_pornektar.getText().toString();
                str_visnenektar = yeni_visnenektar.getText().toString();
                str_meyvelisoda = yeni_meyvelisoda.getText().toString();
                str_sadesoda = yeni_sadesoda.getText().toString();
                str_ayran = yeni_ayran.getText().toString();
                str_su = yeni_su.getText().toString();


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

                a.icecek_fiyati=str_fanta;
                b.icecek_fiyati=str_cacacola;
                c.icecek_fiyati=str_zero;
                d.icecek_fiyati=str_light;
                e.icecek_fiyati=str_iceseftali;
                f.icecek_fiyati=str_fusetea;
                g.icecek_fiyati=str_sprite;
                h.icecek_fiyati=str_sefnektar;
                j.icecek_fiyati=str_pornektar;
                k.icecek_fiyati=str_visnenektar;
                l.icecek_fiyati=str_meyvelisoda;
                m.icecek_fiyati=str_sadesoda;
                n.icecek_fiyati=str_ayran;
                p.icecek_fiyati=str_su;

                db.updateIcecek(a);
                db.updateIcecek(b);
                db.updateIcecek(c);
                db.updateIcecek(d);
                db.updateIcecek(e);
                db.updateIcecek(f);
                db.updateIcecek(g);
                db.updateIcecek(h);
                db.updateIcecek(j);
                db.updateIcecek(k);
                db.updateIcecek(l);
                db.updateIcecek(m);
                db.updateIcecek(n);
                db.updateIcecek(p);

                showMessage("BAŞARILI", "İçecek fiyatları başarılı bir şekilde güncellenmiştir. ");

            }
        });


    }
    public void showMessage(String baslik,String mesaj)
    {
        android.support.v7.app.AlertDialog alertDialog = new android.support.v7.app.AlertDialog.Builder(FiyatlariDegistirIcecekActivity.this).create();
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
