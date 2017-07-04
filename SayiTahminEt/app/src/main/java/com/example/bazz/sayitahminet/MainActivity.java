package com.example.bazz.sayitahminet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public  int[] dizi=new int [3];
    public void Uret(View v){
        EditText t1= (EditText)findViewById(R.id.editText);
        int k=Integer.parseInt(String.valueOf(t1.getText()));
        Random rnd= new Random();
        int sayi =0;
        boolean durum =false;
        for(int i=0;i<dizi.length;i++){
            durum=false;
            while (durum==false){
                sayi=rnd.nextInt(k);
                for(int j=0; j<dizi.length;j++){
                    if (dizi[j]==sayi) break;
                    if (j==dizi.length-1) durum=true;
                }
            }
            dizi[i]=sayi;
        }
        EditText t2= (EditText)findViewById(R.id.editText2);
        t2.setText(String.valueOf(dizi[0]));
        EditText t3= (EditText)findViewById(R.id.editText3);
        t3.setText(String.valueOf(dizi[1]));
    }
    public int hak=3;
    public void TahminEt(View v){
        EditText t5= (EditText)findViewById(R.id.editText5);
        int tahmin=Integer.parseInt(String.valueOf(t5.getText()));

        if (tahmin==dizi[2]){
            hak=hak+1;
            Toast.makeText(getApplicationContext(),"Doğru Tahmin Afferin :) \n Oyun Hakkınız:"+hak,Toast.LENGTH_SHORT).show();
        }

        if (tahmin!=dizi[2]){
            hak=hak-1;
            if(hak==0 || hak<0 ) {
                Toast.makeText(getApplicationContext(),"!!!GAMEOVER!!!",Toast.LENGTH_SHORT).show();

            }
            else Toast.makeText(getApplicationContext(),"Kalan hakkınız: "+hak+" :(",Toast.LENGTH_SHORT).show();
        }


    }
}
