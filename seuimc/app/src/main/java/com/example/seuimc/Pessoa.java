package com.example.seuimc;

import android.os.Parcel;
import android.os.Parcelable;

public class Pessoa implements Parcelable {
    private String nome;
    private Integer idade;
    private Double peso;
    private Double altura;

    public Pessoa(String nome, Integer idade, Double peso, Double altura) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
    }

    public Pessoa() {
    }

    public Pessoa(Double peso, Double altura) {
        this.peso = peso;
        this.altura = altura;
    }

    protected Pessoa(Parcel in) {
        nome = in.readString();
        if (in.readByte() == 0) {
            idade = null;
        } else {
            idade = in.readInt();
        }
        if (in.readByte() == 0) {
            peso = null;
        } else {
            peso = in.readDouble();
        }
        if (in.readByte() == 0) {
            altura = null;
        } else {
            altura = in.readDouble();
        }
    }

    public static final Creator<Pessoa> CREATOR = new Creator<Pessoa>() {
        @Override
        public Pessoa createFromParcel(Parcel in) {
            return new Pessoa(in);
        }

        @Override
        public Pessoa[] newArray(int size) {
            return new Pessoa[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nome);
        if (idade == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(idade);
        }
        if (peso == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(peso);
        }
        if (altura == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(altura);
        }
    }
}
