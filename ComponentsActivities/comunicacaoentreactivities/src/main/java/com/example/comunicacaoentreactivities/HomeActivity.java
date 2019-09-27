package com.example.comunicacaoentreactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import static com.example.comunicacaoentreactivities.MainActivity.NOME_KEY;
import static com.example.comunicacaoentreactivities.MainActivity.TELEFONE_KEY;

public class HomeActivity extends AppCompatActivity {
    private TextView txtNome;
    private TextView txtTelefone;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txtNome = findViewById(R.id.displayNome);
        txtTelefone = findViewById(R.id.displayTelefone);
        btnVoltar = findViewById(R.id.buttonBack);

        Intent intent = getIntent();

        // trata no caso de vir nulo, para não dar crash para o usuário
        if (getIntent() != null && intent.getExtras() != null) {
            Bundle bundle = intent.getExtras();

            String nome = bundle.getString(NOME_KEY);
            String telefone = bundle.getString(TELEFONE_KEY);

            txtNome.setText(nome);
            txtTelefone.setText(telefone);

        } else {
            Snackbar.make(txtNome, "Não há dados!", Snackbar.LENGTH_LONG).show();
        }

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
            }
        });

    }
}
