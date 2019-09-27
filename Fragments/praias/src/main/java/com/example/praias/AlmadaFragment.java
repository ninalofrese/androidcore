package com.example.praias;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlmadaFragment extends Fragment {
    private Button curiosidades;

    public AlmadaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_almada, container, false);

        curiosidades = view.findViewById(R.id.btnCuriosidades);

        curiosidades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"O acesso à comunidade da Almada se dá no km 13 da rodovia...", Snackbar.LENGTH_LONG).show();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }



}
