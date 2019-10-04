package com.example.bandatabview.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.bandatabview.models.Album;

import java.util.List;

public class AlbumAdapter extends FragmentStatePagerAdapter {
    private List<Album> albumList;

    public AlbumAdapter(FragmentManager fm, List<Album> albumList) {
        super(fm);
        this.albumList = albumList;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return albumList.get(position).getNomeAlbum();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return albumList.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return albumList.size();
    }
}
