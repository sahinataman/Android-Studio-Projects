package com.example.bazz.cevahirevyemekleri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class GunlerdenPazartesiActivity extends AppCompatActivity {
    ImageButton geri_buton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gunlerden_pazartesi);

        //Bir Onceki layout a geri dönme
        geri_buton = (ImageButton) findViewById(R.id.geriBTN);
        geri_buton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
