package com.example.exercicioproduto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText inputNome;
    private EditText inputPreco;
    private EditText inputDesconto;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNome = findViewById(R.id.input_nome);
        inputPreco = findViewById(R.id.input_preco);
        inputDesconto = findViewById(R.id.input_porcentagem);
        btnCalcular = findViewById(R.id.button_total);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = inputNome.getText().toString();
                String precoTemp = inputPreco.getText().toString();
                String porcentagemTemp = inputDesconto.getText().toString();

                if (nome.equals("")) {
                    Toast.makeText(MainActivity.this, "Nome do produto não pode ser vazio", Toast.LENGTH_SHORT).show();
                } else if (precoTemp.equals("")) {
                    Toast.makeText(MainActivity.this, "Preço não pode ser vazio", Toast.LENGTH_SHORT).show();
                } else if (porcentagemTemp.equals("")) {
                    Toast.makeText(MainActivity.this, "Porcentagem não pode ser vazia", Toast.LENGTH_SHORT).show();
                } else {
                    Double preco = Double.parseDouble(precoTemp);
                    Double porcentagem = Double.parseDouble(porcentagemTemp);

                    Double totalDesconto = preco - (porcentagem * preco / 100);

                    Toast.makeText(getApplicationContext(), String.format(Locale.US, "Valor a pagar em %s: R$ %.2f", nome, totalDesconto), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
