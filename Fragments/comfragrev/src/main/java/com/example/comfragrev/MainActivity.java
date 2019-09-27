package com.example.comfragrev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

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

    @Override
    public void recebeMensagem(Animal animal) {
        setBundleToFragment(animal, ANIMAL_KEY);
    }

    public void setBundleToFragment(Animal animal, String CHAVE){
        Bundle bundle = new Bundle();
        bundle.putParcelable(CHAVE, animal);
        Fragment fotoFragment = new FotoFragment();
        fotoFragment.setArguments(bundle);
        replaceFragment(R.id.container_fotos, fotoFragment);
    }
}
