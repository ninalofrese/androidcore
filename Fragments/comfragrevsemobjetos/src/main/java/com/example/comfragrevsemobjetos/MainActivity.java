package com.example.comfragrevsemobjetos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.comfragrevsemobjetos.R;

public class MainActivity extends AppCompatActivity implements Comunicador {
    public static final String ANIMAL_KEY = "animal";
    public static final String NOME_KEY = "nome";
    public static final String IMG_KEY = "imagem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(R.id.container_botoes, new BotoesFragment());
    }

    public void replaceFragment(int container, Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }

    public void setBundleToFragment(int imagem, String nome, String CHAVEIMAGEM, String CHAVENOME){
        Bundle bundle = new Bundle();
        bundle.putInt(CHAVEIMAGEM, imagem);
        bundle.putString(CHAVENOME, nome);
        Fragment fotoFragment = new FotoFragment();
        fotoFragment.setArguments(bundle);
        replaceFragment(R.id.container_fotos, fotoFragment);
    }

    @Override
    public void recebeMensagem(int imagem, String nome) {
        setBundleToFragment(imagem, nome, IMG_KEY, NOME_KEY);
    }
}
