package com.example.bazz.adaokulu.AnasayfaActivity;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.bazz.adaokulu.AnasayfaActivity.Galeri.CirclePageIndicator;
import com.example.bazz.adaokulu.AnasayfaActivity.Galeri.ScreenSlidePagerAdapter;
import com.example.bazz.adaokulu.R;

import java.util.Arrays;
public class GaleriActivity extends ActionBarActivity {
    ImageButton geri_buton;
    //Resimlerimizin  bulunduğu yolları IMAGES adlı dizide tutuyoruz...
    public static final String[] IMAGES = new String[] {
            "https://pbs.twimg.com/media/CpglrtQXYAQ979U.jpg:large",
            "https://pbs.twimg.com/media/CpfVbpAWYAAklcn.jpg:large",
            "https://pbs.twimg.com/media/Cor4Z47UsAEJfMD.jpg:large",
            "https://pbs.twimg.com/media/ComcChaWIAAG41_.jpg:large",
            "https://pbs.twimg.com/media/Cp6FysoWcAAbVuK.jpg",
            "https://pbs.twimg.com/media/Cp4-4S0WcAAz6EW.jpg:large",
            "https://pbs.twimg.com/media/Cp0QuUJXgAAqrCC.jpg:large",
            "https://pbs.twimg.com/media/CpvmB7HWcAAMMWC.jpg:large",
            "https://pbs.twimg.com/media/CohNWRtVIAA69jv.jpg",
            "https://pbs.twimg.com/media/CoXg1v0W8AASbY8.jpg:large",
            "https://pbs.twimg.com/media/CoTRE5xWcAA3tW_.jpg:large",
            "https://pbs.twimg.com/media/CoOnKdUW8AAsXEP.jpg:large",
            "https://pbs.twimg.com/media/CoH2ctBWgAAS9SF.jpg",
            "https://pbs.twimg.com/media/CnKDunoXYAEGX4t.jpg:large",
            "https://pbs.twimg.com/media/Cm6pSO5WYAAsjHh.jpg"
    };

    private ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.galeri1);
        //ViewPager tanımladık..
        pager = (ViewPager) findViewById(R.id.pager);
        //Resimlermizi arayüzde göstermek için kullancagmız ScreenSlidePagerAdapter sınıfına resim, yollarnı set ettim.
        ScreenSlidePagerAdapter pagerAdapter =new ScreenSlidePagerAdapter(getSupportFragmentManager());

        pagerAdapter.addAll(Arrays.asList(IMAGES));
        pager.setAdapter(pagerAdapter);
        //Resmin altındaki kucuk yuvarlak iconları resim saysına göre üreten CirclePageIndicator sınıfını cagırdık
        CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(pager);

        geri_buton=(ImageButton)findViewById(R.id.geriBTN);
        geri_buton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    @Override
    public void onBackPressed() {

            super.onBackPressed();

    }
}
