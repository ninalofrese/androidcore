package com.example.seuimc.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.seuimc.R;
import com.example.seuimc.models.Pessoa;
import com.google.android.material.textfield.TextInputLayout;

public class SendActivity extends AppCompatActivity {
    private TextInputLayout inputNome;
    private TextInputLayout inputIdade;
    private TextInputLayout inputPeso;
    private TextInputLayout inputAltura;
    private ImageView imgProfile;
    private Button btnEnviar;

    public static final String PESSOA_KEY = "pessoa";
    public static final String IMAGEM_KEY = "imagem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        initViews();

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = inputNome.getEditText().getText().toString();
                Integer idade = Integer.parseInt(inputIdade.getEditText().getText().toString());
                Double peso = Double.parseDouble(inputPeso.getEditText().getText().toString());
                Double altura = Double.parseDouble(inputAltura.getEditText().getText().toString());

                Pessoa pessoa = new Pessoa(nome, idade, peso, altura);

                Intent intent = new Intent(SendActivity.this, ShowActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable(PESSOA_KEY, pessoa);
                bundle.putInt(IMAGEM_KEY, R.drawable.imgprofile); //passar a imagem, nao o ID do imageView
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }

    public void initViews() {
        inputNome = findViewById(R.id.input_nome);
        inputIdade = findViewById(R.id.input_idade);
        inputPeso = findViewById(R.id.input_peso);
        inputAltura = findViewById(R.id.input_altura);
        btnEnviar = findViewById(R.id.botao_enviar);
        imgProfile = findViewById(R.id.imagem_profile);
    }
}
