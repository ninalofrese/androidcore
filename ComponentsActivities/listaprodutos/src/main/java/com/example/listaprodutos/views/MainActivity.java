package com.example.listaprodutos.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.listaprodutos.R;
import com.example.listaprodutos.adapters.ProdutoAdapter;
import com.example.listaprodutos.interfaces.RecyclerViewOnClick;
import com.example.listaprodutos.models.Produto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewOnClick {
    private RecyclerView recycler;
    private ProdutoAdapter adapter;
    private List<Produto> lista = new ArrayList<>();

    public static final String PRODUTO = "produto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.recyclerView);
        adapter = new ProdutoAdapter(retornarLista(), this);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
    }

    private List<Produto> retornarLista() {
        lista.add(new Produto(R.drawable.book, "Livro", 2.50));
        lista.add(new Produto(R.drawable.book, "Livro", 2.50));
        lista.add(new Produto(R.drawable.book, "Livro", 2.50));
        lista.add(new Produto(R.drawable.book, "Livro", 2.50));
        lista.add(new Produto(R.drawable.book, "Livro", 2.50));
        lista.add(new Produto(R.drawable.book, "Livro", 2.50));
        lista.add(new Produto(R.drawable.book, "Livro", 2.50));
        lista.add(new Produto(R.drawable.book, "Livro", 2.50));
        lista.add(new Produto(R.drawable.book, "Livro", 2.50));
        lista.add(new Produto(R.drawable.book, "Livro", 2.50));
        lista.add(new Produto(R.drawable.book, "Livro", 2.50));

        return lista;
    }

    @Override
    public void onClick(Produto produto) {
        Intent intent = new Intent(MainActivity.this, DetalheActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(PRODUTO, produto);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
