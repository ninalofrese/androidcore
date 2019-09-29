package com.example.revisaofinal.views.fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.revisao.R;
import com.example.revisaofinal.adapters.ListaMusicasAdapter;
import com.example.revisaofinal.models.Musica;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListasMusicasFragment extends Fragment {
    private RecyclerView recyclerView;
    private ListaMusicasAdapter adapter;
    private List<Musica> listaMusicas = new ArrayList<>();

    public ListasMusicasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_listas_musicas, container, false);
        recyclerView = view.findViewById(R.id.lista_recycler);
        adapter = new ListaMusicasAdapter(retornarLista());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity())); //contexto muda no fragment

        return view;
    }

    //Metodo que adiciona itens na lista
    public List<Musica> retornarLista(){
        listaMusicas.add(new Musica("Full Circle", "Nine Lives"));
        listaMusicas.add(new Musica("Nine Lives", "Nine Lives"));
        listaMusicas.add(new Musica("Ain't that a bitch", "Nine Lives"));
        listaMusicas.add(new Musica("Fallen Angels", "Nine Lives"));
        listaMusicas.add(new Musica("Crash", "Nine Lives"));
        listaMusicas.add(new Musica("Pink", "Nine Lives"));
        listaMusicas.add(new Musica("Falling in Love", "Nine Lives"));
        listaMusicas.add(new Musica("Something's Gotta Give", "Nine Lives"));
        listaMusicas.add(new Musica("Sunshine", "Just Push Play"));
        listaMusicas.add(new Musica("What it Takes", "Pump"));
        listaMusicas.add(new Musica("Dream On", "Aerosmith"));

        return listaMusicas;
    }

}
