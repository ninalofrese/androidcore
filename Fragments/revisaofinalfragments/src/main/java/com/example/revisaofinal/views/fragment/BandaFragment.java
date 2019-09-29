package com.example.revisaofinal.views.fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.revisao.R;
import com.example.revisaofinal.interfaces.Comunicador;

/**
 * A simple {@link Fragment} subclass.
 */
public class BandaFragment extends Fragment {
    private Button btnVerFoto;
    private Comunicador comunicador;

    //Sobreescever o método onAttach e implementar a lógica de inicialização do atributo do tipo Comunicador

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(context instanceof Comunicador){
            comunicador = (Comunicador) context;
        } else{
            throw new ClassCastException(context.toString() +
                    " precisa implementar a interface");
        }

    }

    public BandaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_banda, container, false);
        initViews(view);

        //Invocar o método da interface através do atributo comunicador
        //Implementar a lógica de ação do botão ver foto

        btnVerFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(comunicador != null){
                    comunicador.receberMensagem("Aerosmith");
                }
            }
        });

        return view;
    }

    public void initViews(View view){
        btnVerFoto = view.findViewById(R.id.btnVerFoto);
    }

}
