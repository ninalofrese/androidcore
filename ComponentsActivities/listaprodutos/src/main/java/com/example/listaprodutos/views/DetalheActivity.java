package com.example.listaprodutos.views;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listaprodutos.R;
import com.example.listaprodutos.models.Produto;

import java.text.DecimalFormat;

import static com.example.listaprodutos.views.MainActivity.PRODUTO;

public class DetalheActivity extends AppCompatActivity {
    private ImageView detalheImagem;
    private TextView detalheNome;
    private TextView detalhePreco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        initViews();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        if (getIntent() != null && getIntent().getExtras() != null) {
            Produto produto = getIntent().getExtras().getParcelable(PRODUTO);
            if (produto != null) {
                Drawable drawable = getResources().getDrawable(produto.getImagem());
                DecimalFormat formato = new DecimalFormat("R$ #,##");

                detalheImagem.setImageDrawable(drawable);
                detalheNome.setText(produto.getNome());
                detalhePreco.setText(formato.format(produto.getPreco()));
            }
        }
    }

    public void initViews() {
        detalheImagem = findViewById(R.id.detalhe_imagem);
        detalheNome = findViewById(R.id.detalhe_nome);
        detalhePreco = findViewById(R.id.detalhe_preco);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}
