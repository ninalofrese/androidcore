package com.example.comunicacaoentrefragments.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.comunicacaoentrefragments.R;
import com.example.comunicacaoentrefragments.interfaces.Comunicador;
import com.example.comunicacaoentrefragments.model.SistemaOperacional;

public class MainActivity extends AppCompatActivity implements Comunicador {
    public static final String SO_KEY = "SO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(R.id.containter2, new PrimeiroFragment());
    }

    @Override
    public void receberMensagem(SistemaOperacional sistema) {
        setBundleToFragment(sistema, SO_KEY);
    }

    private void replaceFragment(int container, Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }

    public void setBundleToFragment(SistemaOperacional so, String CHAVE) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(CHAVE, so);

        Fragment segundoFragment = new SegundoFragment();
        segundoFragment.setArguments(bundle);

        replaceFragment(R.id.container1, segundoFragment);
    }
}
