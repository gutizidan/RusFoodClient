package com.example.rusfoodclient;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelProduct implements Parcelable {

    private String judul;
    private String  harga;
    private String  image;
    private String  kategori;
    private String  deskripsi;
    public ModelProduct() {

    }


    protected ModelProduct(Parcel in) {
        judul = in.readString();
        harga = in.readString();
        image = in.readString();
        kategori = in.readString();
        deskripsi = in.readString();
    }

    public static final Creator<ModelProduct> CREATOR = new Creator<ModelProduct>() {
        @Override
        public ModelProduct createFromParcel(Parcel in) {
            return new ModelProduct(in);
        }

        @Override
        public ModelProduct[] newArray(int size) {
            return new ModelProduct[size];
        }
    };

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(judul);
        parcel.writeString(harga);
        parcel.writeString(image);
        parcel.writeString(kategori);
        parcel.writeString(deskripsi);
    }
}
