package com.example.bandatabview.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.bandatabview.R;
import com.example.bandatabview.adapters.AlbumAdapter;
import com.example.bandatabview.models.Album;
import com.example.bandatabview.views.fragments.FotoFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Album> listaAlbum = new ArrayList<>();

        listaAlbum.add(new Album("The Source",
                FotoFragment.novaInstancia(R.drawable.thesource, "The Source")));
        listaAlbum.add(new Album("Into the Electric Castle",
                FotoFragment.novaInstancia(R.drawable.intotheelectric, "Into the Electric Castle")));
        listaAlbum.add(new Album("The Theory of Everything",
                FotoFragment.novaInstancia(R.drawable.thetheoryofeverything, "The Theory of Everything")));
        listaAlbum.add(new Album("Universal Migrator",
                FotoFragment.novaInstancia(R.drawable.universalmigrator, "Universal Migrator")));
        listaAlbum.add(new Album("01011001",
                FotoFragment.novaInstancia(R.drawable.ayreon010100, "01011001")));

        AlbumAdapter adapter = new AlbumAdapter(getSupportFragmentManager(), listaAlbum);

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);

        viewPager.setOffscreenPageLimit(listaAlbum.size());

        tabLayout.setupWithViewPager(viewPager);

    }
}
