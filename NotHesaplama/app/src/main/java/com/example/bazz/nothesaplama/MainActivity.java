package com.example.bazz.nothesaplama;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText vizesnv,finalsnv,ort;
    Button sonuc;
    private double m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vizesnv=(EditText)findViewById(R.id.vizeEditText);
        finalsnv=(EditText)findViewById(R.id.finalEditText);
        sonuc=(Button)findViewById(R.id.sonucButton);

    }

    public void SonucuGoster(View v){
        vizesnv=(EditText)findViewById(R.id.vizeEditText);
        finalsnv=(EditText)findViewById(R.id.finalEditText);
        ort=(EditText)findViewById(R.id.ortalamaEditText);

        float k=Integer.parseInt(vizesnv.getText().toString());
        float l=Integer.parseInt(finalsnv.getText().toString());

        m=((k*4)/10)+((l*6)/10);
        ort.setText(String.valueOf(String.format("%.2f", m)));

        if(m>=0 && m<40 ){
            Toast.makeText(getApplicationContext(),"FF ile Büte Kaldınız :(",Toast.LENGTH_SHORT).show();
        }
        if(m>=40 && m<=49){
            Toast.makeText(getApplicationContext(),"FD ile Büte Kaldınız :(",Toast.LENGTH_SHORT).show();
        }
        if(m>49 && m<60 && l>49){
            Toast.makeText(getApplicationContext(),"DD ile Geçtiniz :)",Toast.LENGTH_SHORT).show();
        }
        if(m>59 && m<70 && l>49){
            Toast.makeText(getApplicationContext(),"DC ile Geçtiniz :)",Toast.LENGTH_SHORT).show();
        }
        if(m>69 && m<75 && l>49){
            Toast.makeText(getApplicationContext(),"CC ile Geçtiniz :)",Toast.LENGTH_SHORT).show();
        }
        if(m>74 && m<80 && l>49){
            Toast.makeText(getApplicationContext(),"CB ile Geçtiniz :)",Toast.LENGTH_SHORT).show();
        }
        if(m>79 && m<85 && l>49){
            Toast.makeText(getApplicationContext(),"BB ile Geçtiniz :)",Toast.LENGTH_SHORT).show();
        }
        if(m>84 && m<90 && l>49){
            Toast.makeText(getApplicationContext(),"BA ile Geçtiniz :)",Toast.LENGTH_SHORT).show();
        }
        if(m>89 && m<101 && l>49){
            Toast.makeText(getApplicationContext(),"AA ile Geçtiniz :)",Toast.LENGTH_SHORT).show();
        }
        if (l<50){
            Toast.makeText(getApplicationContext(),"Finalden Barajı Geçemediniz :( \n Büte Kaldınız.",Toast.LENGTH_SHORT).show();
        }
        if (k<0 || k>100 || l<0 || l>100)
            Toast.makeText(getApplicationContext(),"Saçma bir deger girdiniz :O ",Toast.LENGTH_SHORT).show();
    }
}
