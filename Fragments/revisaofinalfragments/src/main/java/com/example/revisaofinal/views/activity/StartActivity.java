package com.example.revisaofinal.views.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.revisao.R;
import com.google.android.material.textfield.TextInputLayout;

public class StartActivity extends AppCompatActivity {

    private TextInputLayout inputNome;
    private Button btnEnviar;

    public static final String NOME_KEY = "nome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        initView();

        //Implementar a lógica de ação do botão enviar

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = inputNome.getEditText().getText().toString();

                enviaNomeActivity(nome);
            }
        });

    }

    private void initView() {
        inputNome = findViewById(R.id.textInputLayoutNome);
        btnEnviar = findViewById(R.id.btnEnviar);
    }

    //Implementaro a lógica do método de envio de dados para activity
    private void enviaNomeActivity(String nome) {
        Intent intent = new Intent(StartActivity.this, WelcomeActivity.class);
        Bundle bundle = new Bundle();

        bundle.putString(NOME_KEY, nome);
        intent.putExtras(bundle);

        startActivity(intent);
    }

}
