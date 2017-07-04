package com.example.bazz.cevahirevyemekleri;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.bazz.cevahirevyemekleri.Database.MenulerDB;
import com.example.bazz.cevahirevyemekleri.SqlLiteDB.CevahirSQLDB;

public class FiyatlariDegistirMenuActivity extends AppCompatActivity {
    String str_kucuk,str_orta,str_buyuk,str_ogrenci,str_cevahir,str_menu1,str_menu2,str_menu3;
    Button guncelle;
    EditText yeni_kucuk ,yeni_orta, yeni_buyuk ,yeni_ogrenci ,yeni_cevahir ,yeni_menu1 ,yeni_menu2,yeni_menu3;
    CevahirSQLDB db;
    ImageButton geri_buton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_fiyatlari_degistir_menu );

        db = new CevahirSQLDB(getApplicationContext());

        yeni_kucuk = (EditText)findViewById(R.id.yeni_kucuk_fiyati);
        yeni_orta = (EditText)findViewById(R.id.yeni_orta_fiyati);
        yeni_buyuk = (EditText)findViewById(R.id.yeni_buyuk_fiyati);
        yeni_ogrenci = (EditText)findViewById(R.id.yeni_ogrenci_fiyati);
        yeni_cevahir = (EditText)findViewById(R.id.yeni_cevahir_fiyati);
        yeni_menu1 = (EditText)findViewById(R.id.yeni_menu1_fiyati);
        yeni_menu2 = (EditText)findViewById(R.id.yeni_menu2_fiyati);
        yeni_menu3 = (EditText)findViewById(R.id.yeni_menu3_fiyati);

        MenulerDB a = db.getMenu( 1 );
        MenulerDB b = db.getMenu( 2 );
        MenulerDB c = db.getMenu( 3 );
        MenulerDB d = db.getMenu( 4 );
        MenulerDB e = db.getMenu( 5 );
        MenulerDB f = db.getMenu( 6 );
        MenulerDB g = db.getMenu( 7 );
        MenulerDB h = db.getMenu( 8 );

        yeni_kucuk.setText( a.menu_fiyati );
        yeni_orta.setText( b.menu_fiyati );
        yeni_buyuk.setText( c.menu_fiyati );
        yeni_ogrenci.setText( d.menu_fiyati );
        yeni_cevahir.setText( e.menu_fiyati );
        yeni_menu1.setText( f.menu_fiyati );
        yeni_menu2.setText( g.menu_fiyati );
        yeni_menu3.setText( h.menu_fiyati );

        geri_buton = (ImageButton)findViewById( R.id.geriBTN );
        geri_buton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });

        guncelle=(Button)findViewById(R.id.guncelleBTN);
        guncelle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                str_kucuk = yeni_kucuk.getText().toString();
                str_orta = yeni_orta.getText().toString();
                str_buyuk = yeni_buyuk.getText().toString();
                str_ogrenci = yeni_ogrenci.getText().toString();
                str_cevahir = yeni_cevahir.getText().toString();
                str_menu1 = yeni_menu1.getText().toString();
                str_menu2 = yeni_menu2.getText().toString();
                str_menu3 = yeni_menu3.getText().toString();


                MenulerDB a1 = db.getMenu( 1 );
                MenulerDB b1 = db.getMenu( 2 );
                MenulerDB c1 = db.getMenu( 3 );
                MenulerDB d1 = db.getMenu( 4 );
                MenulerDB e1 = db.getMenu( 5 );
                MenulerDB f1 = db.getMenu( 6 );
                MenulerDB g1 = db.getMenu( 7 );
                MenulerDB h1 = db.getMenu( 8 );

                a1.menu_fiyati=str_kucuk;
                b1.menu_fiyati=str_orta;
                c1.menu_fiyati=str_buyuk;
                d1.menu_fiyati=str_ogrenci;
                e1.menu_fiyati=str_cevahir;
                f1.menu_fiyati=str_menu1;
                g1.menu_fiyati=str_menu2;
                h1.menu_fiyati=str_menu3;

                db.updateMenu(a1);
                db.updateMenu(b1);
                db.updateMenu(c1);
                db.updateMenu(d1);
                db.updateMenu(e1);
                db.updateMenu(f1);
                db.updateMenu(g1);
                db.updateMenu(h1);

                showMessage("BAŞARILI", "Menü fiyatları başarılı bir şekilde güncellenmiştir. ");
                db.closeDB();


            }
        });


    }
    public void showMessage(String baslik,String mesaj)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(FiyatlariDegistirMenuActivity.this).create();
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



