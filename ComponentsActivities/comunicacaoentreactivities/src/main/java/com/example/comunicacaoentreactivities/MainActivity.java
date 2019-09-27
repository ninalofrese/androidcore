package com.example.comunicacaoentreactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout inputLayoutNome;
    private TextInputLayout inputLayoutTelefone;
    private FloatingActionButton botaoAdicionar;

    public static final String NOME_KEY = "nome";
    public static final String TELEFONE_KEY = "telefone";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputLayoutNome = findViewById(R.id.textInputLayoutNome);
        inputLayoutTelefone = findViewById(R.id.textInputLayoutTelefone);
        botaoAdicionar = findViewById(R.id.floatingActionButton);

        botaoAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = inputLayoutNome.getEditText().getText().toString();
                String telefone = inputLayoutTelefone.getEditText().getText().toString();

                if(!nome.isEmpty() && !telefone.isEmpty()){
                    //Mandando para uma nova activity
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putString(NOME_KEY, nome);
                    bundle.putString(TELEFONE_KEY, telefone);

                    intent.putExtras(bundle);
                    startActivity(intent);
                } else{
                    inputLayoutNome.setError("Preencha o nome");
                    inputLayoutTelefone.setError("Preencha o telefone");
                }
            }
        });

    }
}
