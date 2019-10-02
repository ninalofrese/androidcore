package com.example.revisaorecycler.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.revisaorecycler.R;
import com.example.revisaorecycler.models.Animal;

import static com.example.revisaorecycler.views.MainActivity.ANIMAL_KEY;

public class DetalheActivity extends AppCompatActivity {
    private ImageView imagem;
    private TextView especie;
    private TextView detalhes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        initViews();

        if (getIntent() != null && getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            Animal animal = bundle.getParcelable(ANIMAL_KEY);

            Drawable drawable = getResources().getDrawable(animal.getImagem());

            imagem.setImageDrawable(drawable);
            especie.setText(animal.getRaca());
            detalhes.setText(animal.getDetalhe());
        }
    }

    public void initViews() {
        imagem = findViewById(R.id.detalhe_imagem);
        especie = findViewById(R.id.detalhe_raca);
        detalhes = findViewById(R.id.detalhe_detalhes);
    }
}
