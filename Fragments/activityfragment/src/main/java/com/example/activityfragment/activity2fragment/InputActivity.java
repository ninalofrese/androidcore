package com.example.activityfragment.activity2fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.activityfragment.R;
import com.google.android.material.textfield.TextInputLayout;

public class InputActivity extends AppCompatActivity {
    private TextInputLayout inputNome;
    private Button btnEnviar;

    String nome;

    public static final String NOME_KEY = "nome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        initViews();



        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nome = inputNome.getEditText().getText().toString();

                if (!nome.isEmpty()) {
                    Intent intent = new Intent(InputActivity.this, MainActivity.class);

                    Bundle bundle = new Bundle();

                    bundle.putString(NOME_KEY, nome);

                    intent.putExtras(bundle);

                    startActivity(intent);
                } else {
                    inputNome.setError("Preencha o nome");
                }
            }
        });
    }

    public void initViews() {
        inputNome = findViewById(R.id.textInputLayout_nome);
        btnEnviar = findViewById(R.id.button_enviar);
    }

}
