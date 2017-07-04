package com.example.bazz.cevahirevyemekleri;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Suleiman19 on 10/22/15.
 */
public class GaleriImageModel implements Parcelable {

    String name, url;

    public GaleriImageModel() {

    }

    protected GaleriImageModel(Parcel in) {
        name = in.readString();
        url = in.readString();
    }

    public static final Creator<GaleriImageModel> CREATOR = new Creator<GaleriImageModel>() {
        @Override
        public GaleriImageModel createFromParcel(Parcel in) {
            return new GaleriImageModel(in);
        }

        @Override
        public GaleriImageModel[] newArray(int size) {
            return new GaleriImageModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(url);
    }
}
