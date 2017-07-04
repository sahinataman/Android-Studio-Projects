package com.example.bazz.adaokulu.AnasayfaActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.bazz.adaokulu.R;

public class BildirimlerActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageButton geri_buton;
    private String[] bildirimler = {
            "Sayın Velilerimiz, cumartesi günleri yaptığımız haftalık kontrol sınıfları bu hfta yapılan dönem kontrol sınavları nedeniyle yapılmayacaktır.Bunun yerine cumartesi günü secmeli sanat kültür uygulamaları yapılacaktır.Bilginize...",
            "Sayın Velilerimiz,Türkiye geneli gerrçekleşen Siber saldırılardan kaynaklı olarak , BİLDİRİMLERİMİZİ güvenlik nedeniyle geçici bir süreliğine sadece Sınav Sonuçları şeklinde sizlere ileteceğimizi bildirir anlayışınız için teşekkür ederiz.",
            "SayınVelilerimiz , 23.04.2016 Haftalık Kontrol Sınav Sonuçları sisteme yüklenmiştir.",
            "Sayın Velilerimiz bugun yapılan deneme sınavı sonuçları Pazartesi öğrencilerimize dağıtılacaktır...",
            "Ada Okulları Hasan Kalyoncu Üniversitesinde öğrenci ve velilerle konferans ta buluştu. Konferansta konuşan Kurucu Müdür Hadi Albayram, yeni eğitim öğretim yılına hazır olduklarını belirtti.",
            "“Ada’da yaşam başlıyor” sloganıyla yola çıkan Özel Ada Okulları Kurucu Genel Müdürü Hadi Albayram, konuşmasında şunlara değindi.” Ada okulları eğitim kadromuzla 2015-2016 eğitim-öğretim yılına kendimizi geliştirerek ve yenileyerek başlamanın heyecanı içindeyiz.",
            "Asıl Hedefimiz bilgiye ulaşmaktan çok bilgiyi doğru kullanabilen, eleştirel düşünme ve bilgiyi transfer edebilme becerisi kazanmış bireyler yetiştirmektir. Tüm bunların yanında yabancı dilde yetkin sanat ve spor dallarına ilgili sosyal yaşamda kendini kanıtlayabilen, başarılı ve çağdaş bir nesli; velilerimizin attığı temeller üzerine ekleyeceğimiz eğitim ilkemizle şekillenecektir."
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bildirimler);

        toolbar=(Toolbar) findViewById(R.id.bildirimToolbar);
        setSupportActionBar(toolbar);



        ListView listemiz = (ListView) findViewById(R.id.bildirimlistView);
        ArrayAdapter<String> veriAdaptoru = new ArrayAdapter<String>
                (this, R.layout.bildirimler_txt, R.id.bildrmTV, bildirimler);

        listemiz.setAdapter(veriAdaptoru);
        listemiz.setBackgroundColor(Color.parseColor("#f1e8e8"));

        geri_buton=(ImageButton)findViewById(R.id.geriBTN);
        geri_buton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}

