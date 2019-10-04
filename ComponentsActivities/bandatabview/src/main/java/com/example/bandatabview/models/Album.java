package com.example.bandatabview.models;

import androidx.fragment.app.Fragment;

public class Album {
    private String nomeAlbum;
    private int imgAlbum;
    private Fragment fragment;

    public Album(String nomeAlbum, Fragment fragment) {
        this.nomeAlbum = nomeAlbum;
        this.fragment = fragment;
    }

    public Album() {
    }

    public Album(String nomeAlbum, int imgAlbum, Fragment fragment) {
        this.nomeAlbum = nomeAlbum;
        this.imgAlbum = imgAlbum;
        this.fragment = fragment;
    }

    public String getNomeAlbum() {
        return nomeAlbum;
    }

    public void setNomeAlbum(String nomeAlbum) {
        this.nomeAlbum = nomeAlbum;
    }

    public int getImgAlbum() {
        return imgAlbum;
    }

    public void setImgAlbum(int imgAlbum) {
        this.imgAlbum = imgAlbum;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}
