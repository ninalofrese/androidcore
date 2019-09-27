package com.example.componentsmaterialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class GoodbyeActivity extends AppCompatActivity {

    private TextInputLayout inputNome;
    private FloatingActionButton btnConfirmar;
    private TextView txtThankYou;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goodbye);

        inputNome = findViewById(R.id.textInputLayoutNome);
        btnConfirmar = findViewById(R.id.floatingActionButtonConfirm);
        txtThankYou = findViewById(R.id.thankYou);
        btnVoltar = findViewById(R.id.btnNewMusic);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = inputNome.getEditText().getText().toString();

                //isEmpty também verifica null
                if (nome.isEmpty() || nome == "") {
                    inputNome.setError("O nome precisa ser preenchido");
                } else {
                    txtThankYou.setText("Obrigado, " + nome);
                }
            }
        });

    }
}
