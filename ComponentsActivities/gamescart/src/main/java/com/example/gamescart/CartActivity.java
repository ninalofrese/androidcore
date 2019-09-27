package com.example.gamescart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class CartActivity extends AppCompatActivity {

    private Button finish;
    private TextView totalValue;
    private ImageView imagemProduto1;
    private ImageView imagemProduto2;
    private ImageView imagemProduto3;
    private TextView campoPreco1;
    private TextView campoPreco2;
    private TextView campoPreco3;
    private Double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        totalValue = findViewById(R.id.valor_total);
        finish = findViewById(R.id.button_finish);
        imagemProduto1 = findViewById(R.id.foto_produto1);
        imagemProduto2 = findViewById(R.id.foto_produto2);
        imagemProduto3 = findViewById(R.id.foto_produto3);
        campoPreco1 = findViewById(R.id.preco_produto1);
        campoPreco2 = findViewById(R.id.preco_produto2);
        campoPreco3 = findViewById(R.id.preco_produto3);

        total = 0.0;

        imagemProduto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double precoProduto1 = formatPrice(campoPreco1);
                total += precoProduto1;
                Toast.makeText(CartActivity.this, String.format(Locale.GERMANY, "Valor selecionado R$ %.2f", precoProduto1), Toast.LENGTH_SHORT).show();
                totalValue.setText(String.format(Locale.GERMANY, "Valor total: R$ %.2f", total));
            }
        });

        imagemProduto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double precoProduto2 = formatPrice(campoPreco2);
                total += precoProduto2;
                Toast.makeText(CartActivity.this, String.format(Locale.GERMANY,"Valor selecionado R$ %.2f", precoProduto2), Toast.LENGTH_SHORT).show();
                totalValue.setText(String.format(Locale.GERMANY, "Valor total: R$ %.2f", total));
            }
        });

        imagemProduto3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double precoProduto3 = formatPrice(campoPreco3);
                total += precoProduto3;
                Toast.makeText(CartActivity.this, String.format(Locale.GERMANY,"Valor selecionado R$ %.2f", precoProduto3), Toast.LENGTH_SHORT).show();
                totalValue.setText(String.format(Locale.GERMANY, "Valor total: R$ %.2f", total));
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartActivity.this, FinalActivity.class));
            }
        });
    }

    public Double formatPrice(TextView campo) {
        String campoEmTexto = campo.getText().toString();
        campoEmTexto = campoEmTexto.replaceAll("[^0-9.,]", "");
        campoEmTexto = campoEmTexto.replaceAll(",", ".");
        Double campoDouble = Double.valueOf(campoEmTexto);

        return campoDouble;
    }

}
