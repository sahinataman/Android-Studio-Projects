package com.example.bazz.cevahirevyemekleri.Database;

/**
 * Created by Bazz on 08.02.2017.
 */

public class IzgaralarDB {
    public int izgara_id;
    public String izgara_adi;
    public String izgara_fiyati;

    public IzgaralarDB(int id, String adi, String fiyat) {
        this.izgara_id=id;
        this.izgara_adi=adi;
        this.izgara_fiyati=fiyat;
    };

    public int getIzgara_id() {
        return this.izgara_id;
    }

    public void setIzgara_id(int izgara_id) {
        this.izgara_id = izgara_id;
    }

    public String getIzgara_adi() {
        return izgara_adi;
    }

    public void setIzgara_adi(String izgara_adi) {
        this.izgara_adi = izgara_adi;
    }

    public String getIzgara_fiyati() {
        return izgara_fiyati;
    }

    public void setIzgara_fiyati(String izgara_fiyati) {
        this.izgara_fiyati = izgara_fiyati;
    }
}