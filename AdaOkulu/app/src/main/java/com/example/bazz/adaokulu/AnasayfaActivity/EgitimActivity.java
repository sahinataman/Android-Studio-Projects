package com.example.bazz.adaokulu.AnasayfaActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.bazz.adaokulu.R;

public class EgitimActivity extends AppCompatActivity {
    ImageButton geri_buton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.egitim);

        geri_buton=(ImageButton)findViewById(R.id.geriBTN);
        geri_buton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

}

