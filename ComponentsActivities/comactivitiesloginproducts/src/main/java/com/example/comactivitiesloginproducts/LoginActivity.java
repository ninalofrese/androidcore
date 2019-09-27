package com.example.comactivitiesloginproducts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    private TextInputLayout inputNome;
    private TextInputLayout inputSenha;
    private Button btnLogin;

    public static final String NOME_KEY = "nome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = inputNome.getEditText().getText().toString();
                String senha = inputSenha.getEditText().getText().toString();

                if(!nome.isEmpty() && !senha.isEmpty()){
                    //Comunicação simples entre activities - envia da tela de Login para a de Produto
                    Intent intent = new Intent(LoginActivity.this, ProductActivity.class);
                    Bundle bundle = new Bundle();

                    bundle.putString(NOME_KEY, nome);

                    intent.putExtras(bundle);

                    startActivity(intent);
                } else{
                    inputNome.setError("Nome não pode ser vazio");
                    inputSenha.setError("Senha não pode ser vazia");
                }

            }
        });
    }

    public void initViews(){
        inputNome = findViewById(R.id.inputlayout_login_name);
        inputSenha = findViewById(R.id.inputlayout_login_password);
        btnLogin = findViewById(R.id.btn_login_submit);
    }
}
