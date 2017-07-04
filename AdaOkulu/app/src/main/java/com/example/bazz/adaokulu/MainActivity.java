package com.example.bazz.adaokulu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bazz.adaokulu.AnasayfaActivity.BildirimlerActivity;
import com.example.bazz.adaokulu.AnasayfaActivity.EgitimActivity;
import com.example.bazz.adaokulu.AnasayfaActivity.GaleriActivity;
import com.example.bazz.adaokulu.AnasayfaActivity.IletisimActivity;
import com.example.bazz.adaokulu.AnasayfaActivity.MisyonActivity;
import com.example.bazz.adaokulu.AnasayfaActivity.VizyonActivity;
import com.example.bazz.adaokulu.adapter.SlidingMenuAdapter;
import com.example.bazz.adaokulu.model.ItemSlideMenu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button vizyon,misyon,egitim,iletisim,galeri,bildirimler;
    TextView kayanyazi;
    private List<ItemSlideMenu> solmenu ;
    private SlidingMenuAdapter adapter;
    private ListView sol_menu_list ;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        kayanyazi=(TextView)findViewById(R.id.scroller);
        kayanyazi.setSelected(true);

        //Anasayfada ViewScroller daki butonları tanımlıyorum
        vizyon =(Button)findViewById(R.id.vizyonTXT);
        iletisim =(Button)findViewById(R.id.iletisimTXT);
        galeri =(Button)findViewById(R.id.galeriTXT);
        bildirimler = (Button) findViewById(R.id.bildirimTXT);

        //sag_menu_list = (ListView) findViewById(R.id.sagListeMenu);
        sol_menu_list = (ListView) findViewById(R.id.solListeMenu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        solmenu = new ArrayList<>();
        //sagmenu = new ArrayList<>();

        //sol menuye eleman ekleme
        solmenu.add(new ItemSlideMenu(R.drawable.soltaraf_menu_anasayfa, "Anasayfa"));
        solmenu.add(new ItemSlideMenu(R.drawable.soltaraf_menu_vizyon, "Vizyon"));
        solmenu.add(new ItemSlideMenu(R.drawable.soltaraf_menu_bildirim,"Bildirim"));
        solmenu.add(new ItemSlideMenu(R.drawable.soltaraf_menu_galeri,"Galeri"));
        solmenu.add(new ItemSlideMenu(R.drawable.soltaraf_menu_iletisim,"İletişim"));

        //sagmenu.add(new ItemSlideMenu(R.drawable.login,"Öğrenci Girişi"));


        adapter = new SlidingMenuAdapter(this, solmenu);
        sol_menu_list.setAdapter(adapter);

        drawerLayout.closeDrawer(sol_menu_list);


        sol_menu_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sol_menu_list.setItemChecked(position, true);
                replaceFragment(position);
                drawerLayout.closeDrawer(sol_menu_list);
            }
        });

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_opened, R.string.drawer_closed){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //Anasayfada scrollview deki butonları tıklanırken ki olayları
        misyon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, MisyonActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
        vizyon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, VizyonActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
        egitim.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, EgitimActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
        iletisim.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, IletisimActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent myIntent = new Intent(MainActivity.this, GaleriActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
        bildirimler.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent myIntent = new Intent(MainActivity.this, BildirimlerActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu2, menu);
        return true;
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    private void replaceFragment(int pos) {
        switch (pos) {
            case 0:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, VizyonActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, MisyonActivity.class));
                break;
            case 3:
                startActivity(new Intent(this, EgitimActivity.class));
                break;
            case 4:
                startActivity(new Intent(this, BildirimlerActivity.class));
                break;
            case 5:
                startActivity(new Intent(this, GaleriActivity.class));
                break;
            case 6:
                startActivity(new Intent(this, IletisimActivity.class));
                break;

            default:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
    public void GirisSayfasi(MenuItem item){
        Intent giris_saysasi = new Intent(getApplicationContext(),LoginPage.class );
        startActivity(giris_saysasi);
        finish();
    }


}