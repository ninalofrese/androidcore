package com.example.comfragmentscars.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.comfragmentscars.R;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {
    private TextInputLayout inputName;
    private TextInputLayout inputEmail;
    private TextInputLayout inputPassword;
    private Button buttonLogin;

    public static final String NAME_KEY = "nome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = inputName.getEditText().getText().toString();
                String email = inputEmail.getEditText().getText().toString().trim();
                String password = inputPassword.getEditText().getText().toString().trim();

                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                    Intent intent = new Intent(RegisterActivity.this, WelcomeActivity.class);

                    Bundle bundle = new Bundle();

                    bundle.putString(NAME_KEY, name);

                    intent.putExtras(bundle);

                    startActivity(intent);
                } else {
                    inputName.setError("Nome não pode ser vazio");
                    inputEmail.setError("E-mail não pode ser vazio");
                    inputPassword.setError("Senha não pode ser vazio");
                }

            }
        });
    }

    public void initViews() {
        inputName = findViewById(R.id.inputlayout_register_nome);
        inputEmail = findViewById(R.id.inputlayout_register_email);
        inputPassword = findViewById(R.id.inputlayout_register_senha);
        buttonLogin = findViewById(R.id.button_register_login);
    }
}
