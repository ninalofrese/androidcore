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
public class JustaFragment extends Fragment {
    private Button btnCuriosidadeJusta;

    public JustaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_justa, container, false);

        btnCuriosidadeJusta = view.findViewById(R.id.btnJusta);

        btnCuriosidadeJusta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"O acesso à comunidade da Justa se dá no km 26 da rodovia...", Snackbar.LENGTH_LONG).show();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
