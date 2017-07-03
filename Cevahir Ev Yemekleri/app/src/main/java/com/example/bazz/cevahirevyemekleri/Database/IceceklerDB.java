package com.example.bazz.cevahirevyemekleri.Database;

/**
 * Created by Bazz on 08.02.2017.
 */

public class IceceklerDB {
    public int icecek_id;
    public String icecek_adi;
    public String icecek_fiyati;

    public IceceklerDB(int id, String adi, String fiyat) {
        this.icecek_id=id;
        this.icecek_adi=adi;
        this.icecek_fiyati=fiyat;
    };

    public int getIcecek_id() {
        return icecek_id;
    }

    public void setIcecek_id(int icecek_id) {
        this.icecek_id = icecek_id;
    }

    public String getIcecek_adi() {
        return icecek_adi;
    }

    public void setIcecek_adi(String icecek_adi) {
        this.icecek_adi = icecek_adi;
    }

    public String getIcecek_fiyati() {
        return icecek_fiyati;
    }

    public void setIcecek_fiyati(String icecek_fiyati) {
        this.icecek_fiyati = icecek_fiyati;
    }
}