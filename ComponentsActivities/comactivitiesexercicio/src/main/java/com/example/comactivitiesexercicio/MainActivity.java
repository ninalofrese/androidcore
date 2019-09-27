package com.example.comactivitiesexercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout inputNome;
    private TextInputLayout inputEmail;
    private TextInputLayout inputIdade;
    private Button btnSend;

    public static final String NOME_KEY = "nome";
    public static final String EMAIL_KEY = "email";
    public static final String IDADE_KEY = "idade";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = inputNome.getEditText().getText().toString();
                String email = inputEmail.getEditText().getText().toString();
                String idade = inputIdade.getEditText().getText().toString();

                if(!nome.isEmpty() && !email.isEmpty() && !idade.isEmpty()){
                    Intent intent = new Intent(MainActivity.this, HelloActivity.class);
                    Bundle bundle = new Bundle();

                    bundle.putString("nome", nome);
                    bundle.putString("email", email);
                    bundle.putString("idade", idade);

                    intent.putExtras(bundle);
                    startActivity(intent);
                } else{
                    inputNome.setError("Preencha o nome");
                    inputEmail.setError("Preencha o e-mail");
                    inputIdade.setError("Preencha a idade");
                }

            }
        });
    }

    private void initViews(){
        inputNome = findViewById(R.id.inputlayout_main_nome);
        inputEmail = findViewById(R.id.inputlayout_main_email);
        inputIdade = findViewById(R.id.inputlayout_main_idade);
        btnSend = findViewById(R.id.button_main_send);
    }
}
