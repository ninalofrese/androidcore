package com.example.exerciciocadastrousuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout nome;
    private TextInputLayout email;
    private FloatingActionButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeS = nome.getEditText().getText().toString();
                String emailS = email.getEditText().getText().toString();

                if(!nomeS.isEmpty() && !emailS.isEmpty()){
                    Snackbar.make(nome, "Usuário cadastrado com sucesso", Snackbar.LENGTH_LONG).show();
                } else{
                    Snackbar.make(nome, "Campo deve ser preenchido", Snackbar.LENGTH_LONG).show();
                }
            }
        });

    }

    public void initViews() {
        nome = findViewById(R.id.textInputLayoutNome);
        email = findViewById(R.id.textInputLayoutEmail);
        button = findViewById(R.id.btnAdd);
    }

}
