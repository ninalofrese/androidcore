package com.example.comunicacaoentrefragments.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SistemaOperacional implements Parcelable {
    private int imagem;
    private String nome;

    public SistemaOperacional(int imagem, String nome) {
        this.imagem = imagem;
        this.nome = nome;
    }

    public SistemaOperacional(){

    }

    protected SistemaOperacional(Parcel in) {
        imagem = in.readInt();
        nome = in.readString();
    }

    public static final Creator<SistemaOperacional> CREATOR = new Creator<SistemaOperacional>() {
        @Override
        public SistemaOperacional createFromParcel(Parcel in) {
            return new SistemaOperacional(in);
        }

        @Override
        public SistemaOperacional[] newArray(int size) {
            return new SistemaOperacional[size];
        }
    };

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //descreve conteúdo, mas é pouco usado
    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imagem);
        parcel.writeString(nome);
    }
}
