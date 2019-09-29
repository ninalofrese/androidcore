package com.example.seuimc.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.seuimc.R;
import com.example.seuimc.models.Pessoa;

import java.util.Locale;

import static com.example.seuimc.views.SendActivity.IMAGEM_KEY;
import static com.example.seuimc.views.SendActivity.PESSOA_KEY;

public class ShowActivity extends AppCompatActivity {
    private TextView displayNome;
    private TextView displayIdade;
    private TextView displayPeso;
    private TextView displayAltura;
    private ImageView displayImage;
    private Button btnVamosLa;
    private Pessoa pessoa;

    public static final String DADOS_KEY = "dados";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        initViews();

        Intent intent = getIntent();

        if (intent != null && intent.getExtras() != null) {
            Bundle bundle = intent.getExtras();

            pessoa = bundle.getParcelable(PESSOA_KEY);
            Integer imagem = bundle.getInt(IMAGEM_KEY);
            String boasVindas = "Seja bem-vindo(a), %s!\nEsse é um aplicativo que te ajuda a saber e calcular o seu Índice de Massa Corporal";

            if (pessoa != null) {
                displayNome.setText(String.format(Locale.US, boasVindas, pessoa.getNome()));
                displayIdade.setText(String.format(Locale.US, "Idade: %d anos", pessoa.getIdade()));
                displayPeso.setText(String.format(Locale.US, "Peso: %.1f", pessoa.getPeso()));
                displayAltura.setText(String.format(Locale.US, "Altura: %.2f", pessoa.getAltura()));
                displayImage.setImageResource(imagem); //puxa da imagem, não do ID da ImageView
            }

            btnVamosLa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Envia o objeto Pessoa para a MainActivity
                    Intent intent = new Intent(ShowActivity.this, MainActivity.class);
                    Bundle bundle = new Bundle();

                    Pessoa pessoaDados = new Pessoa(pessoa.getPeso(), pessoa.getAltura());

                    bundle.putParcelable(DADOS_KEY, pessoaDados);
                    intent.putExtras(bundle);

                    startActivity(intent);
                }
            });
        }
    }

    public void initViews() {
        displayNome = findViewById(R.id.display_msg_nome);
        displayIdade = findViewById(R.id.display_idade);
        displayPeso = findViewById(R.id.display_peso);
        displayAltura = findViewById(R.id.display_altura);
        displayImage = findViewById(R.id.show_profile_image);
        btnVamosLa = findViewById(R.id.botao_vamosla);
    }
}
