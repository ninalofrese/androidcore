package com.example.comfragmentscolor.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;

import com.example.comfragmentscolor.R;
import com.example.comfragmentscolor.interfaces.Comunicator;
import com.example.comfragmentscolor.models.Cor;

public class MainActivity extends AppCompatActivity implements Comunicator {
   public static final String COLOR_KEY = "color";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //quando inicia a activity, ele já mostra o fragment que tem os botões
        replaceFragment(R.id.container1, new ButtonsFragment());
    }

    //faz a transação de substituir os containers por fragments
    private void replaceFragment(int container, Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }

    @Override
    public void getMessage(Cor color) {
        setBundleToFragment(color, COLOR_KEY);
    }


    public void setBundleToFragment(Cor cor, String CHAVE){
        Bundle bundle = new Bundle();

        bundle.putParcelable(CHAVE, cor);

        Fragment colorFragment = new ColorFragment();

        colorFragment.setArguments(bundle);

        //Troca o segundo container pelo Fragment
        replaceFragment(R.id.container2, colorFragment);
    }
}
