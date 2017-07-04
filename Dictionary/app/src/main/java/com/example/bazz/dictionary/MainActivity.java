package com.example.bazz.dictionary;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class MainActivity extends AppCompatActivity {
    Button ing_1, ing_2, turk_1, turk_2,cevir;
    EditText d1, eng;
    boolean basti_mi=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cevir = (Button) findViewById(R.id.cevirID);
        ing_1 = (Button) findViewById(R.id.ingID1);
        turk_1 = (Button) findViewById(R.id.turkID1);
        ing_2 = (Button) findViewById(R.id.ingID2);
        turk_2 = (Button) findViewById(R.id.turkID2);
        d1 = (EditText) findViewById(R.id.displayTR);
        eng = (EditText) findViewById(R.id.displayENG);
        cevir.setEnabled(false);
        ing_1.setBackgroundColor(Color.parseColor("#ffbb33"));
        turk_1.setBackgroundColor(Color.parseColor("#ffbb33"));
        turk_2.setBackgroundColor(Color.parseColor("#ffbb33"));
        ing_2.setBackgroundColor(Color.parseColor("#ffbb33"));
        ing_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ing_1.setBackgroundColor(Color.YELLOW);
                turk_1.setBackgroundColor(Color.parseColor("#ffbb33"));
                turk_2.setBackgroundColor(Color.YELLOW);
                ing_2.setBackgroundColor(Color.parseColor("#ffbb33"));
                basti_mi=true;
                if(basti_mi==true){
                    cevir.setEnabled(true);
                }
            }
        });
        turk_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turk_1.setBackgroundColor(Color.YELLOW);
                ing_1.setBackgroundColor(Color.parseColor("#ffbb33"));
                turk_2.setBackgroundColor(Color.parseColor("#ffbb33"));
                ing_2.setBackgroundColor(Color.YELLOW);
                basti_mi=true;
                if(basti_mi==true){
                    cevir.setEnabled(true);
                }
            }
        });

        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eng.setText("");

            }
        });
    }
    public class Word {
        public String Tr;
        public String En;

        public Word(String tr, String en) {
            this.Tr = tr;
            this.En = en;
        }
    }
    public void Translate(View v) {
        List<Word> kelimeler = new ArrayList<Word>();
        kelimeler.add(new Word("Araba", "Car"));
        kelimeler.add(new Word("Bilgisayar", "Computer"));
        kelimeler.add(new Word("Telefon", "Phone"));
        kelimeler.add(new Word("Ev", "Home"));
        kelimeler.add(new Word("Okul", "School"));
        kelimeler.add(new Word("Meyve", "Fruit"));
        kelimeler.add(new Word("Kitap", "Book"));

        EditText eng = (EditText) findViewById(R.id.displayENG);
        EditText display1 = (EditText) findViewById(R.id.displayTR);
        String a = display1.getText().toString();


        Button button1 = (Button) findViewById(R.id.ingID1);
        ColorDrawable buttonColor = (ColorDrawable) button1.getBackground();
        int colorID = buttonColor.getColor();

        boolean var_mi=false;
        if (colorID == Color.YELLOW) {

            for (Word k : kelimeler) {
                if (a.toString().equalsIgnoreCase(k.En)) {
                    eng.setText(k.Tr);
                    var_mi=true;
                    break;
                }
                eng.setText("");
            }
        }
        else if (colorID == Color.parseColor("#ffbb33")) {
            for (Word k : kelimeler) {
                if (a.toString().equalsIgnoreCase(k.Tr)) {
                    eng.setText(k.En);
                    var_mi=true;
                    break;
                }
                eng.setText("");
            }
        }
        if(var_mi==false){
            Toast.makeText(getApplicationContext(),"Girdiğiniz kelime bulunamadı",Toast.LENGTH_SHORT).show();
        }
    }
}


