package com.example.revisaofinal.models;

public class Musica {
    private String musica;
    private String album;

    public Musica(String musica, String album) {
        this.musica = musica;
        this.album = album;
    }

    public Musica() {
    }

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
}
