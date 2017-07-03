package com.example.bazz.cevahirevyemekleri.Database;

/**
 * Created by Bazz on 08.02.2017.
 */

public class MenulerDB {
    public int menu_id;
    public String menu_adi;
    public String menu_fiyati;

    public MenulerDB(int id, String adi, String fiyat) {
        this.menu_id=id;
        this.menu_adi=adi;
        this.menu_fiyati=fiyat;
    };

    public int getMenu_id() {
        return this.menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_adi() {
        return menu_adi;
    }

    public void setMenu_adi(String menu_adi) {
        this.menu_adi = menu_adi;
    }

    public String getMenu_fiyati() {
        return menu_fiyati;
    }

    public void setMenu_fiyati(String menu_fiyati) {
        this.menu_fiyati = menu_fiyati;
    }
}