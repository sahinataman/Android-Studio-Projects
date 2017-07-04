package com.example.bazz.cevahirevyemekleri;

import android.app.LoaderManager.LoaderCallbacks;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.bazz.cevahirevyemekleri.Database.AdminDB;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends AppCompatActivity implements LoaderCallbacks<Cursor> {
    EditText username ,password;
    Button girisButton ;
    public  static List<AdminDB> yöneticiler;
    String str_user,str_password;
    String hata_mesaji="";
    Boolean hata = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Layoutta geri iconuna basınca bir onceki layouta donme



        //logın_activity.xml deki verilere ulaşıyorum
        username = (EditText) findViewById(R.id.kullaniciET);
        password = (EditText) findViewById(R.id.sifreET);
        girisButton = (Button) findViewById(R.id.girisBTN);

        //kullanıcı bilgilerini bu şekilde listede tuttum

        yöneticiler = new ArrayList<AdminDB>();
        yöneticiler.add(new AdminDB("Ozan AYKUT","ozan_aykut","1","05425696356","32546915632","Barlar Sokağı"));
        yöneticiler.add(new AdminDB("Ömür AYKUT","omur_aykut","1","05456324555","31222555632","Fetvane Sokak"));


        //Veriler girildikten sonra butona basıldığı zmn
        girisButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                str_user = username.getText().toString();
                str_password = password.getText().toString();

                if(str_user.matches("") || str_password.matches("")) {
                    hata_mesaji += "KullanıcıAdı ya da Şifre Alanları Boş Bırakılamaz.\n";
                    hata = true;
                }

                /*SİLMEEEEEEEEEEE
                int sifre_karakter = str_password.length();
                if(sifre_karakter<6){
                    hata_mesaji += "Şifre 6 Karakterden Az Olamaz\n";
                    hata=true;
                }*/
                //hata varsa AlertDialog ile kullanıcıyı uyarıyoruz.
                if(hata){
                    AlertDialog alertDialog = new AlertDialog.Builder(LoginPage.this).create();
                    alertDialog.setTitle("Hata");
                    alertDialog.setMessage(hata_mesaji);
                    alertDialog.setCancelable(false);
                    alertDialog.setButton(RESULT_OK,"Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            password.setText("");
                            hata_mesaji = "";
                            hata = false;
                        }
                    });
                    alertDialog.show();
                }else{
                    boolean varmı = false;
                    for (AdminDB k : yöneticiler) {
                        if(k.KullaniciAdi.equals(str_user) && k.Sifre.equals(str_password)){
                            varmı=true;
                            //Verilere uygun ogrenci bulunduğunda giriş yapılıyor
                            ProgressDialog pDialog;
                            pDialog = new ProgressDialog(LoginPage.this);
                            pDialog.setMessage("Giriş Yapılıyor...");
                            pDialog.setIndeterminate(true);
                            pDialog.setCancelable(false);
                            pDialog.show();
                            Intent giris = new Intent(getApplicationContext(),AdminProfile.class );
                            startActivity(giris);
                            finish();

                            //adSoyad ı diger sınıfa gonderdim
                            Intent intent  = new Intent(LoginPage.this,AdminProfile.class);
                            intent.putExtra("GelenADSOYAD", k.Adi);
                            intent.putExtra("GelenTC",k.TC);
                            startActivity(intent);
                        }
                    }
                    //Sistemde girilen verilere ait ögrenci bulunmadığında....
                    if(varmı==false){
                        AlertDialog alertDialog = new AlertDialog.Builder(LoginPage.this).create();
                        alertDialog.setTitle("GİRİŞ YAPILAMADI");
                        alertDialog.setMessage("Girdiğiniz bilgilere dair sistemde kayıtlı yönetici bulunmamaktadır.");
                        alertDialog.setCancelable(false);
                        alertDialog.setButton(RESULT_OK,"Tamam", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                password.setText("");
                                hata_mesaji = "";
                                hata = false;
                            }
                        });
                        alertDialog.show();
                    }
                }
            }
        });


    }
    //geri tuşuna basınca direkt uygulamadan cıkarma
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            startActivity(new Intent(this, MainActivity.class));
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}

