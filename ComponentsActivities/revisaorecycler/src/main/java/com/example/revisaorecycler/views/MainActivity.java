package com.example.revisaorecycler.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.revisaorecycler.adapters.AnimalAdapter;
import com.example.revisaorecycler.R;
import com.example.revisaorecycler.interfaces.RecyclerViewOnClick;
import com.example.revisaorecycler.models.Animal;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewOnClick {
    private RecyclerView recyclerView;
    private AnimalAdapter adapter;
    private List<Animal> lista = new ArrayList<>();

    public static final String ANIMAL_KEY = "animal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewAnimais);
        adapter = new AnimalAdapter(retornarLista(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public List<Animal> retornarLista() {
        lista.add(new Animal(R.drawable.cachorro, "Cachorro", "Os cachorros são os melhores"));
        lista.add(new Animal(R.drawable.gato, "Gato", "Os gatos são um legais"));
        lista.add(new Animal(R.drawable.leao, "Leão", "Os leões são os reis da selva"));

        return lista;
    }

    @Override
    public void onClick(Animal animal) {
        Intent intent = new Intent(MainActivity.this, DetalheActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(ANIMAL_KEY, animal);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
