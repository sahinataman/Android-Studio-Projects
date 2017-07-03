package com.example.bazz.cevahirevyemekleri.Database;

/**
 * Created by Bazz on 08.02.2017.
 */

public class TatlilarDB {
    public int tatli_id;
    public String tatli_adi;
    public String tatli_fiyati;

    public TatlilarDB(int id, String adi, String fiyat) {
        this.tatli_id=id;
        this.tatli_adi=adi;
        this.tatli_fiyati=fiyat;
    };

    public int getTatli_id() {
        return this.tatli_id;
    }

    public void setTatli_id(int tatli_id) {
        this.tatli_id = tatli_id;
    }

    public String getTatli_adi() {
        return tatli_adi;
    }

    public void setTatli_adi(String tatli_adi) {
        this.tatli_adi = tatli_adi;
    }

    public String getTatli_fiyati() {
        return tatli_fiyati;
    }

    public void setTatli_fiyati(String tatli_fiyati) {
        this.tatli_fiyati = tatli_fiyati;
    }
}