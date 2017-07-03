package com.example.bazz.cevahirevyemekleri.Database;


public class AdminDB {
    public String Adi;
    public String KullaniciAdi;
    public String Sifre;
    public String TC;
    public String Telno;
    public String Adres;

    public AdminDB(String ad, String user, String password, String tel , String tc , String adres) {
        this.KullaniciAdi = user;
        this.Sifre = password;
        this.Adi = ad;
        this.TC = tc;
        this.Telno = tel;
        this.Adres = adres;

    };


}

