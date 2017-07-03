package com.example.bazz.cevahirevyemekleri;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class GaleriActivity extends AppCompatActivity {

    GalleriAdapter mAdapter;
    RecyclerView mRecyclerView;
    ImageButton geri_buton;

    ArrayList<GaleriImageModel> data = new ArrayList<>();

    public static String IMGS[] = {

            "https://media-cdn.tripadvisor.com/media/photo-s/08/29/cd/9a/two-large-plates-for.jpg",
            "https://media-cdn.tripadvisor.com/media/photo-s/08/29/cd/9b/comfortable-homely-atmosphere.jpg",
            "https://irs3.4sqi.net/img/general/600x600/70457342_SOAPoIGD86SziWNxEVUxZ-pRRsZ9D4iyMkMTYhWs7L8.jpg",
            "https://i.ytimg.com/vi/kAzKl03NWyM/maxresdefault.jpg",
            "http://1.bp.blogspot.com/-DuHgxpyuebs/VoomPAyHcNI/AAAAAAAAMSk/vzPkPCqqv3o/s1600/Ege%2B%252814%2529.jpg",
            "https://farm9.static.flickr.com/8672/15183678363_31ffda2f1a_b.jpg",
            "https://www.esnafbul.com/resimler/esnaf/670px356/cevahir-6294568.JPG",
            "http://morfikirler.com/wp-content/uploads/2006/12/evyemekleri.jpg",
            "https://www.organicbuyersgroup.com.au/shop/images/patisserie.jpg",
            "https://lh3.googleusercontent.com/-aTC2a8LmDpY/UxisT2wHwKI/AAAAAAAAEkU/8gQdI1CIWqU/s640/blogger-image--817064491.jpg",
            "http://1.bp.blogspot.com/-QXALtzBzQJ4/UFYadaw6pCI/AAAAAAAAB4w/350_gQA2dlA/s1600/Foca+zeytinyagli.JPG",
            "http://hanimelievyemekleri.net/wp-content/uploads/2014/09/10.jpg",
            "http://www.evdeis.org/wp-content/uploads/2016/11/ev-yemekleri.jpg",
            "http://www.cizgaramangalkonagi.com/images/et-yemekleri/4.jpg",
            "http://www.bekratasfirinkebap.com/img/demo/food/adana-big.jpg",
            "http://www.fishofnorth.com/urun_resimleri/203_IZGARA_BONFILE.jpg",
            "http://www.anadolupidekebap.com/upload/urun/tavuk_kanatlar_1.jpg",
            "http://www.jagonews24.com/images/PhotoGallery/2014December/a-1-lg20141219132419.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeri);

        for (int i = 0; i < IMGS.length; i++) {

            GaleriImageModel galeriImageModel = new GaleriImageModel();
            galeriImageModel.setName("Cevahir Ev Yemekleri - " + i);
            galeriImageModel.setUrl(IMGS[i]);
            data.add(galeriImageModel);

        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mRecyclerView.setHasFixedSize(true);


        mAdapter = new GalleriAdapter(GaleriActivity.this, data);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,
                new RecyclerItemClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {

                        Intent intent = new Intent(GaleriActivity.this, GaleriDetailActivity.class);
                        intent.putParcelableArrayListExtra("data", data);
                        intent.putExtra("pos", position);
                        startActivity(intent);

                    }
                }));

        geri_buton = (ImageButton)findViewById(R.id.geriBTN);
        geri_buton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

}
