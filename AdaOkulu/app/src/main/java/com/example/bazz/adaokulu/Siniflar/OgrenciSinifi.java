package com.example.bazz.adaokulu.Siniflar;


public class OgrenciSinifi {
    public String Adi;
    public String KullaniciAdi;
    public String Sifre;
    public String Numara;
    public String Sinifi;
    public String MatNotu1;
    public String TürkceNotu1;
    public String SosyalNotu1;
    public String FenNotu1;
    public String MatNotu2;
    public String TürkceNotu2;
    public String SosyalNotu2;
    public String FenNotu2;
    public String MatNotu3;
    public String TürkceNotu3;
    public String SosyalNotu3;
    public String FenNotu3;


    public OgrenciSinifi(String ad, String user, String password,String sinif, String numara) {
        this.Numara=numara;
        this.KullaniciAdi = user;
        this.Sinifi=sinif;
        this.Sifre = password;
        this.Adi = ad;

    };
    public OgrenciSinifi(String ad, String numara, String mat1, String sosyal1, String fen1, String turce1,
                         String mat2, String sosyal2, String fen2, String turce2, String mat3, String sosyal3, String fen3, String turce3){
        this.Adi=ad;
        this.Numara=numara;
        this.FenNotu1 = fen1;  this.FenNotu2 = fen2;  this.FenNotu3 = fen3;
        this.MatNotu1 = mat1;   this.MatNotu2 = mat2;  this.MatNotu3 = mat3;
        this.TürkceNotu1 =turce1;  this.TürkceNotu2 =turce2;  this.TürkceNotu3 =turce3;
        this.SosyalNotu1=sosyal1;  this.SosyalNotu2=sosyal2;  this.SosyalNotu3=sosyal3;
    }

}

