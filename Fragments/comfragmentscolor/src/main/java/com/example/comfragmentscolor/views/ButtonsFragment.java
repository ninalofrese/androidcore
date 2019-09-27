package com.example.comfragmentscolor.views;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.comfragmentscolor.R;
import com.example.comfragmentscolor.interfaces.Comunicator;
import com.example.comfragmentscolor.models.Cor;


/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonsFragment extends Fragment {
    private Button btnVerde;
    private Button btnVermelho;
    private Comunicator comunicador;

    public ButtonsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof Comunicator) {
            comunicador = (Comunicator) context;
        } else {
            throw new ClassCastException(context.toString() +
                    "must implement listener interface");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buttons, container, false);

        initViews(view);

        btnVerde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //o que vai ser passado?
                Cor corVerde = new Cor(R.color.verde, "Verde");

                comunicador.getMessage(corVerde);
            }
        });

        btnVermelho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //o que vai ser passado?
                Cor corVermelha = new Cor(R.color.vermelho, "Vermelho");

                comunicador.getMessage(corVermelha);
            }
        });

        return view;
    }

    public void initViews(View view) {
        btnVerde = view.findViewById(R.id.btnVerde);
        btnVermelho = view.findViewById(R.id.btnVermelho);
    }

}
