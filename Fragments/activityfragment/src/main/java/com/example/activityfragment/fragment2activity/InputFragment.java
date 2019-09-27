package com.example.activityfragment.fragment2activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.activityfragment.R;
import com.google.android.material.textfield.TextInputLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment extends Fragment {
    private TextInputLayout inputNome;
    private Button btnEnviar;
    private Comunicador comunicador;

    public InputFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(context instanceof Comunicador){
            comunicador = (Comunicador) context;
        } else{
            throw new ClassCastException(context.toString() +
                    " must have interface implemented");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        initViews(view);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = inputNome.getEditText().getText().toString();

                comunicador.deliverMessage(nome);
            }
        });

        return view;
    }

    public void initViews(View view){
        inputNome = view.findViewById(R.id.input_frag_nome);
        btnEnviar = view.findViewById(R.id.button_frag_enviar);
    }
}
