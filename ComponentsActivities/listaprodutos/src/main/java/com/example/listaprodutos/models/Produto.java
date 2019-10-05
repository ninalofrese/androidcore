package com.example.listaprodutos.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Produto implements Parcelable {
    private int imagem;
    private String nome;
    private Double preco;

    public Produto(int imagem, String nome, Double preco) {
        this.imagem = imagem;
        this.nome = nome;
        this.preco = preco;
    }

    public Produto() {
    }

    protected Produto(Parcel in) {
        imagem = in.readInt();
        nome = in.readString();
        if (in.readByte() == 0) {
            preco = null;
        } else {
            preco = in.readDouble();
        }
    }

    public static final Creator<Produto> CREATOR = new Creator<Produto>() {
        @Override
        public Produto createFromParcel(Parcel in) {
            return new Produto(in);
        }

        @Override
        public Produto[] newArray(int size) {
            return new Produto[size];
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imagem);
        parcel.writeString(nome);
        if (preco == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(preco);
        }
    }
}
