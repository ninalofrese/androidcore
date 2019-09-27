package com.example.comunicacaoentrefragments.views;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.comunicacaoentrefragments.R;
import com.example.comunicacaoentrefragments.interfaces.Comunicador;
import com.example.comunicacaoentrefragments.model.SistemaOperacional;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrimeiroFragment extends Fragment {
    private Button buttonAndroid;
    private Button buttonIos;
    private Comunicador comunicador;

    public PrimeiroFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        //Inicializa o comunicador para identificar quem é o contexto que vai sobrescrever o meu método
        try{
            comunicador = (Comunicador) context;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_primeiro, container, false);

        initView(view);

        buttonAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Instanciando um objeto
                SistemaOperacional android = new SistemaOperacional(R.drawable.jinjer, "Android Oreo");
                //Ativa a interface e passa o android para o método receberMensagem
                comunicador.receberMensagem(android);
            }
        });

        buttonIos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SistemaOperacional ios = new SistemaOperacional(R.drawable.fatchocobo, "iOS 8");
                comunicador.receberMensagem(ios);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    public void initView(View view){
        buttonAndroid = view.findViewById(R.id.btnAndroid);
        buttonIos = view.findViewById(R.id.btnIOS);
    }

}
