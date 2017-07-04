package com.example.bazz.cevahirevyemekleri;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.bazz.cevahirevyemekleri.Database.TatlilarDB;
import com.example.bazz.cevahirevyemekleri.SqlLiteDB.CevahirSQLDB;

public class FiyatlariDegistirTatliActivity extends AppCompatActivity {
    String str_sutlac,str_trilice,str_kazandibi,str_tiramisu,str_revani,str_mozaik,str_kemalpasa,str_irmik;
    Button guncelle;
    EditText yeni_sutlac ,yeni_trilice, yeni_kazandibi ,yeni_tiramisu ,yeni_revani ,yeni_mozaik ,yeni_kemalpasa,yeni_irmik;
    CevahirSQLDB db;
    ImageButton geri_buton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_fiyatlari_degistir_tatli );

        db = new CevahirSQLDB(getApplicationContext());

        yeni_sutlac = (EditText)findViewById(R.id.yeni_sutlac_fiyati);
        yeni_trilice = (EditText)findViewById(R.id.yeni_trilice_fiyati);
        yeni_kazandibi = (EditText)findViewById(R.id.yeni_kazandibi_fiyati);
        yeni_tiramisu = (EditText)findViewById(R.id.yeni_tiramisu_fiyati);
        yeni_revani = (EditText)findViewById(R.id.yeni_revani_fiyati);
        yeni_mozaik = (EditText)findViewById(R.id.yeni_mozaik_fiyati);
        yeni_kemalpasa = (EditText)findViewById(R.id.yeni_kemalpasa_fiyati);
        yeni_irmik = (EditText)findViewById(R.id.yeni_irmik_fiyati);

        TatlilarDB a = db.getTatli( 1 );
        TatlilarDB b = db.getTatli( 2 );
        TatlilarDB c = db.getTatli( 3 );
        TatlilarDB d = db.getTatli( 4 );
        TatlilarDB e = db.getTatli( 5 );
        TatlilarDB f = db.getTatli( 6 );
        TatlilarDB g = db.getTatli( 7 );
        TatlilarDB h = db.getTatli( 8 );

        yeni_sutlac.setText( a.tatli_fiyati );
        yeni_trilice.setText( b.tatli_fiyati );
        yeni_kazandibi.setText( c.tatli_fiyati );
        yeni_tiramisu.setText( d.tatli_fiyati );
        yeni_revani.setText( e.tatli_fiyati );
        yeni_mozaik.setText( f.tatli_fiyati );
        yeni_kemalpasa.setText( g.tatli_fiyati );
        yeni_irmik.setText( h.tatli_fiyati );

        geri_buton = (ImageButton)findViewById( R.id.geriBTN );
        geri_buton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });

        guncelle=(Button)findViewById(R.id.guncelleBTN);
        guncelle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                str_sutlac = yeni_sutlac.getText().toString();
                str_trilice = yeni_trilice.getText().toString();
                str_kazandibi = yeni_kazandibi.getText().toString();
                str_tiramisu = yeni_tiramisu.getText().toString();
                str_revani = yeni_revani.getText().toString();
                str_mozaik = yeni_mozaik.getText().toString();
                str_kemalpasa = yeni_kemalpasa.getText().toString();
                str_irmik = yeni_irmik.getText().toString();


                TatlilarDB a1 = db.getTatli( 1 );
                TatlilarDB b1 = db.getTatli( 2 );
                TatlilarDB c1 = db.getTatli( 3 );
                TatlilarDB d1 = db.getTatli( 4 );
                TatlilarDB e1 = db.getTatli( 5 );
                TatlilarDB f1 = db.getTatli( 6 );
                TatlilarDB g1 = db.getTatli( 7 );
                TatlilarDB h1 = db.getTatli( 8 );

                a1.tatli_fiyati=str_sutlac;
                b1.tatli_fiyati=str_trilice;
                c1.tatli_fiyati=str_kazandibi;
                d1.tatli_fiyati=str_tiramisu;
                e1.tatli_fiyati=str_revani;
                f1.tatli_fiyati=str_mozaik;
                g1.tatli_fiyati=str_kemalpasa;
                h1.tatli_fiyati=str_irmik;

                db.updateTatli(a1);
                db.updateTatli(b1);
                db.updateTatli(c1);
                db.updateTatli(d1);
                db.updateTatli(e1);
                db.updateTatli(f1);
                db.updateTatli(g1);
                db.updateTatli(h1);

                showMessage("BAŞARILI", "Tatli fiyatları başarılı bir şekilde güncellenmiştir. ");
                db.closeDB();


            }
        });


    }
    public void showMessage(String baslik,String mesaj)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(FiyatlariDegistirTatliActivity.this).create();
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



