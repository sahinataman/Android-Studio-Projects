package com.example.bazz.cevahirevyemekleri.Database;

/**
 * Created by Bazz on 08.02.2017.
 */

public class CorbalarDB {
    public int corba_id;
    public String corba_adi;
    public String corba_fiyati;

    public CorbalarDB(int id, String adi, String fiyat) {
        this.corba_id=id;
        this.corba_adi=adi;
        this.corba_fiyati=fiyat;
    };

    public int getCorba_id() {
        return this.corba_id;
    }

    public void setCorba_id(int corba_id) {
        this.corba_id = corba_id;
    }

    public String getCorba_adi() {
        return corba_adi;
    }

    public void setCorba_adi(String corba_adi) {
        this.corba_adi = corba_adi;
    }

    public String getCorba_fiyati() {
        return corba_fiyati;
    }

    public void setCorba_fiyati(String corba_fiyati) {
        this.corba_fiyati = corba_fiyati;
    }
}