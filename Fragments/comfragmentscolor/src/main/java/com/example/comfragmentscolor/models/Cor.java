package com.example.comfragmentscolor.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Cor implements Parcelable {
    private int color;
    private String nomeDaCor;

    public Cor(int color, String nomeDaCor) {
        this.color = color;
        this.nomeDaCor = nomeDaCor;
    }
    public Cor(){

    }

    protected Cor(Parcel in) {
        color = in.readInt();
        nomeDaCor = in.readString();
    }

    public static final Creator<Cor> CREATOR = new Creator<Cor>() {
        @Override
        public Cor createFromParcel(Parcel in) {
            return new Cor(in);
        }

        @Override
        public Cor[] newArray(int size) {
            return new Cor[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(color);
        parcel.writeString(nomeDaCor);
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getNomeDaCor() {
        return nomeDaCor;
    }

    public void setNomeDaCor(String nomeDaCor) {
        this.nomeDaCor = nomeDaCor;
    }
}
