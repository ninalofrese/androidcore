package com.example.comactivitiesloginproducts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.example.comactivitiesloginproducts.ProductActivity.NAME_ARRAY_KEY;
import static com.example.comactivitiesloginproducts.ProductActivity.QTTY_ARRAY_KEY;
import static com.example.comactivitiesloginproducts.ProductActivity.VALUE_ARRAY_KEY;

public class ListaActivity extends AppCompatActivity {

    private TextView nomeProduto1;
    private TextView qtdeProduto1;
    private TextView valorProduto1;
    private TextView totalProduto1;
    private TextView nomeProduto2;
    private TextView qtdeProduto2;
    private TextView valorProduto2;
    private TextView totalProduto2;
    private TextView nomeProduto3;
    private TextView qtdeProduto3;
    private TextView valorProduto3;
    private TextView totalProduto3;
    private TextView total;
    private Button btnVoltar;
    private Double soma = 0.0;

    List<TextView> listaIdNomes = new ArrayList<>();
    List<TextView> listaIdQtdes = new ArrayList<>();
    List<TextView> listaIdPrecos = new ArrayList<>();
    List<TextView> listaIdTotal = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        initViews();

        Intent intent = getIntent();

        if (intent != null && intent.getExtras() != null) {
            Bundle bundle = intent.getExtras();

            ArrayList<String> listaNome = new ArrayList<String>();
            ArrayList<Integer> listaQuantidade = new ArrayList<Integer>();
            ArrayList<String> listaPreco = new ArrayList<String>();

            if(bundle != null){
                listaNome = bundle.getStringArrayList(NAME_ARRAY_KEY);
                listaQuantidade = bundle.getIntegerArrayList(QTTY_ARRAY_KEY);
                listaPreco = bundle.getStringArrayList(VALUE_ARRAY_KEY);

               for (int i = 0; i < listaNome.size(); i++) {
                    listaIdNomes.get(i).setText(listaNome.get(i));
                    listaIdQtdes.get(i).setText(String.format(Locale.GERMANY, "%d", listaQuantidade.get(i)));
                    listaIdPrecos.get(i).setText(String.format(Locale.GERMANY, "R$ %.2f", Double.parseDouble(listaPreco.get(i))));
                    listaIdTotal.get(i).setText(String.format(Locale.GERMANY, "R$ %.2f", calcularProduto(listaQuantidade.get(i), Double.parseDouble(listaPreco.get(i)))));
                    soma += calcularProduto(listaQuantidade.get(i), Double.parseDouble(listaPreco.get(i)));
                }
            }

        } else {
            Toast.makeText(getApplicationContext(), "Não há dados!", Toast.LENGTH_SHORT).show();
        }
        total.setText(String.format(Locale.GERMANY, "R$ %.2f", soma));

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListaActivity.this, ProductActivity.class));
            }
        });
    }

    public void initViews() {
        nomeProduto1 = findViewById(R.id.product1_nome);
        qtdeProduto1 = findViewById(R.id.product1_qtty);
        valorProduto1 = findViewById(R.id.product1_value);
        totalProduto1 = findViewById(R.id.product1_total);
        nomeProduto2 = findViewById(R.id.product2_nome);
        qtdeProduto2 = findViewById(R.id.product2_qtty);
        valorProduto2 = findViewById(R.id.product2_value);
        totalProduto2 = findViewById(R.id.product2_total);
        nomeProduto3 = findViewById(R.id.product3_nome);
        qtdeProduto3 = findViewById(R.id.product3_qtty);
        valorProduto3 = findViewById(R.id.product3_value);
        totalProduto3 = findViewById(R.id.product3_total);
        total = findViewById(R.id.products_total);
        btnVoltar = findViewById(R.id.btn_voltar);

        listaIdNomes.add(nomeProduto1);
        listaIdNomes.add(nomeProduto2);
        listaIdNomes.add(nomeProduto3);
        listaIdQtdes.add(qtdeProduto1);
        listaIdQtdes.add(qtdeProduto2);
        listaIdQtdes.add(qtdeProduto3);
        listaIdPrecos.add(valorProduto1);
        listaIdPrecos.add(valorProduto2);
        listaIdPrecos.add(valorProduto3);
        listaIdTotal.add(totalProduto1);
        listaIdTotal.add(totalProduto2);
        listaIdTotal.add(totalProduto3);
    }

    public Double calcularProduto(Integer quantidade, Double preco) {
        return quantidade * preco;
    }

}
