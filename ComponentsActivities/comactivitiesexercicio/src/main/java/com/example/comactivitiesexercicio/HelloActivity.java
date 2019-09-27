package com.example.comactivitiesexercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.comactivitiesexercicio.MainActivity.EMAIL_KEY;
import static com.example.comactivitiesexercicio.MainActivity.IDADE_KEY;
import static com.example.comactivitiesexercicio.MainActivity.NOME_KEY;

public class HelloActivity extends AppCompatActivity {
    private TextView textWelcome;
    private TextView textNome;
    private TextView textEmail;
    private TextView textIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        initViews();

        Intent intent = getIntent();

        //trata possível excecao de nullpointer
        if (intent != null && intent.getExtras() != null) {
            Bundle bundle = intent.getExtras();

            String nome = bundle.getString(NOME_KEY);
            String email = bundle.getString(EMAIL_KEY);
            String idade = bundle.getString(IDADE_KEY);

            textWelcome.setText(String.format("Olá, %s!\nSeja bem-vindo(a)!", nome));
            textNome.setText(String.format("Nome: %s", nome));
            textEmail.setText(String.format("E-mail: %s", email));
            textIdade.setText(String.format("Idade: %s", idade));
        }
    }

    public void initViews() {
        textWelcome = findViewById(R.id.text_hello_welcome);
        textNome = findViewById(R.id.text_hello_nome);
        textEmail = findViewById(R.id.text_hello_email);
        textIdade = findViewById(R.id.text_hello_idade);
    }
}
