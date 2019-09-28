package com.example.seuimc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.seuimc.ShowActivity.DADOS_KEY;

public class MainActivity extends AppCompatActivity implements Comunicador {
    private Button btnHome;

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

            Pessoa pessoaDados = bundle.getParcelable(DADOS_KEY);

            setBundleToFragment(pessoaDados, PA_KEY);
        }

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SendActivity.class));
            }
        });
    }

    public void setBundleToFragment(Pessoa pessoa, String CHAVE) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(CHAVE, pessoa);
        Fragment calculoFragment = new CalculoFragment();
        calculoFragment.setArguments(bundle);
        replaceFragment(R.id.container_up, calculoFragment);
    }

    public void replaceFragment(int container, Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }


    @Override
    public void recebeMensagem(Pessoa pessoa) {
        setBundleToFragment(pessoa, PA_KEY);
    }
}
