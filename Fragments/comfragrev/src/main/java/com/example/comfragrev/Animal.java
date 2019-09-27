package com.example.comfragrev;

import android.os.Parcel;
import android.os.Parcelable;

public class Animal implements Parcelable {
    private String nome;
    private int imagem;

    public Animal(String nome, int imagem) {
        this.nome = nome;
        this.imagem = imagem;
    }

    public Animal() {
    }

    protected Animal(Parcel in) {
        nome = in.readString();
        imagem = in.readInt();
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nome);
        parcel.writeInt(imagem);
    }
}
