package com.example.comfragrevsemobjetos;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.comfragrevsemobjetos.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class BotoesFragment extends Fragment {
    private Button botaoCachorro;
    private Button botaoGato;
    private Comunicador comunicador;

    public BotoesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Comunicador){
            comunicador = (Comunicador) context;
        } else{
            throw new ClassCastException(context.toString() +
                    "must implement interface");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_botoes, container, false);

        initViews(view);

        botaoCachorro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(comunicador != null){
                    comunicador.recebeMensagem(R.drawable.labrador, "Chocolate");
                }

            }
        });

        botaoGato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(comunicador != null){
                    comunicador.recebeMensagem(R.drawable.cat, "Frajola");
                }

            }
        });



        return view;
    }

    public void initViews(View view){
        botaoCachorro = view.findViewById(R.id.button_cachorro);
        botaoGato = view.findViewById(R.id.button_gato);
    }

}
