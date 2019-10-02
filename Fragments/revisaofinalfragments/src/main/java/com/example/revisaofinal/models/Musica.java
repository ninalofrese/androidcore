package com.example.revisaofinal.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Musica implements Parcelable {
    private String musica;
    private String album;
    private String letra;

    public Musica(String musica, String album, String letra) {
        this.musica = musica;
        this.album = album;
        this.letra = letra;
    }

    public Musica() {
    }

    protected Musica(Parcel in) {
        musica = in.readString();
        album = in.readString();
        letra = in.readString();
    }

    public static final Creator<Musica> CREATOR = new Creator<Musica>() {
        @Override
        public Musica createFromParcel(Parcel in) {
            return new Musica(in);
        }

        @Override
        public Musica[] newArray(int size) {
            return new Musica[size];
        }
    };

    public String getMusica() {
        return musica;
    }

    public void setMusica(String musica) {
        this.musica = musica;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(musica);
        parcel.writeString(album);
        parcel.writeString(letra);
    }
}
