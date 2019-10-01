package com.example.seuimc.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.seuimc.R;
import com.example.seuimc.interfaces.Comunicador;
import com.example.seuimc.models.Opcao;
import com.example.seuimc.models.Pessoa;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static com.example.seuimc.views.ShowActivity.DADOS_KEY;

public class MainActivity extends AppCompatActivity implements Comunicador {
    public static final String OPCAO_KEY = "opcao";
    private FloatingActionButton btnHome;
    private Pessoa pessoaDados;

    public static final String PA_KEY = "peso e altura";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(R.id.container_down, new BotoesFragment());

        btnHome = findViewById(R.id.botao_home);

        Intent intent = getIntent();

        if (intent != null && intent.getExtras() != null) {
            Bundle bundle = intent.getExtras();

            pessoaDados = bundle.getParcelable(DADOS_KEY);
        }

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SendActivity.class));
            }
        });
    }

    //Manda como um extra o objeto Pessoa, recebido pelo bundle da intent gerada em ShowActivity
    public void setOptionToFragment(Opcao opcao, String CHAVE) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(CHAVE, opcao);
        bundle.putParcelable(PA_KEY, pessoaDados);
        Fragment calculoFragment = new CalculoFragment();
        calculoFragment.setArguments(bundle);
        replaceFragment(R.id.container_up, calculoFragment);
    }

    public void replaceFragment(int container, Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void recebeMensagem(Opcao opcao) {
        setOptionToFragment(opcao, OPCAO_KEY);
    }
}
