package com.example.bazz.cevahirevyemekleri;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.bazz.cevahirevyemekleri.Database.IzgaralarDB;
import com.example.bazz.cevahirevyemekleri.SqlLiteDB.CevahirSQLDB;

public class FiyatlariDegistirIzgaraActivity extends AppCompatActivity {
    String str_tavuk,str_kofte,str_karisik,str_sis,str_kebap,str_kanat,str_but;
    Button guncelle;
    EditText yeni_tavuk ,yeni_kofte, yeni_karisik ,yeni_sis ,yeni_kebap ,yeni_kanat ,yeni_but;
    CevahirSQLDB db;
    ImageButton geri_buton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_fiyatlari_degistir_izgara );

        db = new CevahirSQLDB(getApplicationContext());

        yeni_tavuk = (EditText)findViewById(R.id.yeni_tavukizgara_fiyati);
        yeni_kofte = (EditText)findViewById(R.id.yeni_kofte_fiyati);
        yeni_karisik = (EditText)findViewById(R.id.yeni_karisik_fiyati);
        yeni_sis = (EditText)findViewById(R.id.yeni_sis_fiyati);
        yeni_kebap = (EditText)findViewById(R.id.yeni_kebap_fiyati);
        yeni_kanat = (EditText)findViewById(R.id.yeni_kanat_fiyati);
        yeni_but = (EditText)findViewById(R.id.yeni_but_fiyati);

        IzgaralarDB a = db.getIzgara( 1 );
        IzgaralarDB b = db.getIzgara( 2 );
        IzgaralarDB c = db.getIzgara( 3 );
        IzgaralarDB d = db.getIzgara( 4 );
        IzgaralarDB e = db.getIzgara( 5 );
        IzgaralarDB f = db.getIzgara( 6 );
        IzgaralarDB g = db.getIzgara( 7 );

        yeni_tavuk.setText( a.izgara_fiyati );
        yeni_kofte.setText( b.izgara_fiyati );
        yeni_karisik.setText( c.izgara_fiyati );
        yeni_sis.setText( d.izgara_fiyati );
        yeni_kebap.setText( e.izgara_fiyati );
        yeni_kanat.setText( f.izgara_fiyati );
        yeni_but.setText( g.izgara_fiyati );

        geri_buton = (ImageButton)findViewById( R.id.geriBTN );
        geri_buton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });
        guncelle=(Button)findViewById(R.id.guncelleBTN);
        guncelle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                str_tavuk = yeni_tavuk.getText().toString();
                str_kofte = yeni_kofte.getText().toString();
                str_karisik = yeni_karisik.getText().toString();
                str_sis = yeni_sis.getText().toString();
                str_kebap = yeni_kebap.getText().toString();
                str_kanat = yeni_kanat.getText().toString();
                str_but = yeni_but.getText().toString();


                IzgaralarDB a1 = db.getIzgara( 1 );
                IzgaralarDB b1 = db.getIzgara( 2 );
                IzgaralarDB c1 = db.getIzgara( 3 );
                IzgaralarDB d1 = db.getIzgara( 4 );
                IzgaralarDB e1 = db.getIzgara( 5 );
                IzgaralarDB f1 = db.getIzgara( 6 );
                IzgaralarDB g1 = db.getIzgara( 7 );

                a1.izgara_fiyati=str_tavuk;
                b1.izgara_fiyati=str_kofte;
                c1.izgara_fiyati=str_karisik;
                d1.izgara_fiyati=str_sis;
                e1.izgara_fiyati=str_kebap;
                f1.izgara_fiyati=str_kanat;
                g1.izgara_fiyati=str_but;

                db.updateIzgara(a1);
                db.updateIzgara(b1);
                db.updateIzgara(c1);
                db.updateIzgara(d1);
                db.updateIzgara(e1);
                db.updateIzgara(f1);
                db.updateIzgara(g1);

                showMessage("BAŞARILI", "Izgara fiyatları başarılı bir şekilde güncellenmiştir. ");

            }
        });
    }

    public void showMessage(String baslik,String mesaj)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(FiyatlariDegistirIzgaraActivity.this).create();
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
