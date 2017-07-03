package com.example.bazz.cevahirevyemekleri;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

public class BildirimlerActivity extends AppCompatActivity {

    ImageButton geri_buton;
    private String[] bildirimler = {
            "Sayın Müşterilerimiz , pazar günleri için extra olarak farklı yemekler çıkmaktadır.Bilginize...",
            "Sayın Müşterilerimiz , ramazan ayını orucun ilk günü yemekler müessesemizden ücretsiz olarak iftar vakti verilmektedir.",
            "Sayın Müşterilerimiz , 25.02.2017 Cumartesi günü KÜÇÜK TABAK o güne özel 6 TL :)",
            "Sayın Müşterilerimiz , bu bayramda gönlünüz dertlerinden arınmış, tüm gözyaşlarınız dinmiş olsun. Yüzünüz de hep gülümseme, kalbiniz huzurla dolsun. Ramazan Bayramı'nız kutlu olsun.",
            "Sayın Müşterilerimiz , Pazartesi günlerine özel tüm Tatlılar 4 TL :)",
            "Çanakkale Destanının ölümsüz kahramanları; Türk milletinin azminin, vatan aşkının, bayrak sevgisinin önünde hiçbir gücün duramayacağını bir kez daha kanıtlamışlardır."
};
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bildirimler);




        ListView listemiz = (ListView) findViewById(R.id.bildirimlistView);
        ArrayAdapter<String> veriAdaptoru = new ArrayAdapter<String>
                (this, R.layout.activity_bildirimler_txt, R.id.bildrmTV, bildirimler);

        listemiz.setAdapter(veriAdaptoru);
        listemiz.setBackgroundColor( Color.parseColor("#f1e8e8"));

        geri_buton=(ImageButton)findViewById(R.id.geriBTN);
        geri_buton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
