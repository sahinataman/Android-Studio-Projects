package com.example.bazz.adaokulu.OBS;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.bazz.adaokulu.R;

/**
 * Created by Bazz on 19.08.2016.
 */
public class ServisSaatleri extends Activity {
    ImageButton geri_buton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servis_saatleri);

        geri_buton=(ImageButton)findViewById(R.id.geriBTN);
        geri_buton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
