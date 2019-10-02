package com.example.revisaorecycler.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Animal implements Parcelable {
    private int imagem;
    private String raca;
    private String detalhe;

    public Animal(int imagem, String raca, String detalhe) {
        this.imagem = imagem;
        this.raca = raca;
        this.detalhe = detalhe;
    }

    public Animal() {
    }

    protected Animal(Parcel in) {
        imagem = in.readInt();
        raca = in.readString();
        detalhe = in.readString();
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imagem);
        parcel.writeString(raca);
        parcel.writeString(detalhe);
    }
}
