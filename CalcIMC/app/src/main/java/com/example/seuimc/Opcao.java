package com.example.seuimc;

import android.os.Parcel;
import android.os.Parcelable;

public class Opcao implements Parcelable {
    private int imagem;
    private String texto;

    public Opcao(int imagem, String texto) {
        this.imagem = imagem;
        this.texto = texto;
    }

    public Opcao() {
    }

    protected Opcao(Parcel in) {
        imagem = in.readInt();
        texto = in.readString();
    }

    public static final Creator<Opcao> CREATOR = new Creator<Opcao>() {
        @Override
        public Opcao createFromParcel(Parcel in) {
            return new Opcao(in);
        }

        @Override
        public Opcao[] newArray(int size) {
            return new Opcao[size];
        }
    };

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imagem);
        parcel.writeString(texto);
    }
}
