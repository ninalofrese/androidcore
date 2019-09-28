package com.example.listaalunos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AlunoAdapter adapter;
    private RecyclerView recyclerView;
    private List<Aluno> listaAlunos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_alunos);

        adapter = new AlunoAdapter(retornarLista());

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public List<Aluno> retornarLista(){
        listaAlunos.add(new Aluno("Deivid", "1111111"));
        listaAlunos.add(new Aluno("Luiz", "1111111"));
        listaAlunos.add(new Aluno("Deivid", "1111111"));
        listaAlunos.add(new Aluno("Deivid", "1111111"));
        listaAlunos.add(new Aluno("Deivid", "1111111"));
        listaAlunos.add(new Aluno("Luiz", "1111111"));
        listaAlunos.add(new Aluno("Luiz", "1111111"));
        listaAlunos.add(new Aluno("Luiz", "1111111"));
        listaAlunos.add(new Aluno("Luiz", "1111111"));
        listaAlunos.add(new Aluno("Luiz", "1111111"));
        listaAlunos.add(new Aluno("Luiz", "1111111"));
        listaAlunos.add(new Aluno("Luiz", "1111111"));
        listaAlunos.add(new Aluno("Luiz", "1111111"));

        return listaAlunos;
    }
}
