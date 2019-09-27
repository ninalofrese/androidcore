package com.example.comfragmentscars.views;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.comfragmentscars.R;
import com.example.comfragmentscars.interfaces.Comunicator;
import com.example.comfragmentscars.model.Car;

/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonsFragment extends Fragment {
    private Button buttonImpala;
    private Button buttonFusca;
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
                    "must implement interface");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buttons, container, false);

        initViews(view);

        buttonImpala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Car carro = new Car(R.drawable.impala, "Impala", "O primeiro modelo de o Chevrolet Impala foi lançado em 1958");

                if (comunicador != null) {
                    comunicador.getMessage(carro);
                }
            }
        });

        buttonFusca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Car carro = new Car(R.drawable.fusca, "Fusca", "O primeiro modelo do Volkswagen Fusca foi lançado em 1959");

                if (comunicador != null) {
                    comunicador.getMessage(carro);
                }
            }
        });

        return view;
    }

    public void initViews(View view) {
        buttonImpala = view.findViewById(R.id.button_fragment_impala);
        buttonFusca = view.findViewById(R.id.button_fragment_fusca);
    }
}
