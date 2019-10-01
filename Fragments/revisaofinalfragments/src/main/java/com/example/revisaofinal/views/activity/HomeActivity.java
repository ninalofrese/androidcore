package com.example.revisaofinal.views.activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.revisao.R;
import com.example.revisaofinal.adapters.ListaMusicasAdapter;
import com.example.revisaofinal.interfaces.Comunicador;
import com.example.revisaofinal.models.Musica;
import com.example.revisaofinal.views.fragment.BandaFragment;
import com.example.revisaofinal.views.fragment.ComidaFragment;
import com.example.revisaofinal.views.fragment.FotoBandaFragment;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.revisaofinal.views.fragment.ListasMusicasFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

//Implemetar a interface Comunicador e sobrescrever seu respectivo método
public class HomeActivity extends AppCompatActivity implements Comunicador {
    private DrawerLayout drawer;
    private AppBarConfiguration mAppBarConfiguration;
    public static final String BANDA_KEY = "banda";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        //Fazer a instancia da ActionBarDrawerToggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        );

        //Setar o addDrawerListener no drawer
        drawer.addDrawerListener(toggle);

        //Invocar o método syncState() através do toggle
        toggle.syncState();

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_music, R.id.nav_food, R.id.nav_musics)
                .setDrawerLayout(drawer)
                .build();

        //Implementar a lógica do setNavigationItemSelectedListener através do navigationView
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if (id == R.id.nav_music) {
                    replaceFragment(new BandaFragment());
                } else if (id == R.id.nav_food) {
                    replaceFragment(new ComidaFragment());
                }else if (id == R.id.nav_musics) {
                    replaceFragment(new ListasMusicasFragment());
                }

                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    //Sobreescrever o método onBackPressed e implementar a lógica
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public void receberMensagem(String mensagem) {
        Bundle bundle = new Bundle();
        bundle.putString(BANDA_KEY, mensagem);

        Fragment fotoFragment = new FotoBandaFragment();
        fotoFragment.setArguments(bundle);

        replaceFragment(fotoFragment);
    }

    //Sobreescrever o método onOptionsItemSelected e implementar a lógica
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_sair) {
            startActivity(new Intent(HomeActivity.this, StartActivity.class));

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Desenvolver e implementar o método replaceFragment
    public void replaceFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

}
