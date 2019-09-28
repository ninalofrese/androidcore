package com.example.seuimc;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static com.example.seuimc.MainActivity.PA_KEY;


/**
 * A simple {@link Fragment} subclass.
 */
public class BotoesFragment extends Fragment {
    private Button btnCalcular;
    private Button btnInformacao;
    private Comunicador comunicador;
    private Pessoa pessoa;

    public BotoesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof Comunicador) {
            comunicador = (Comunicador) context;
        } else {
            throw new ClassCastException(context.toString() +
                    "must implement interface");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_botoes, container, false);
        initView(view);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!getArguments().isEmpty()) {
                    pessoa = getArguments().getParcelable(PA_KEY);

                    if (pessoa != null) {

                        if (comunicador != null) {
                            comunicador.recebeMensagem(pessoa);
                        }
                    }
                }
            }
        });




        return view;
    }

    public void initView(View view) {
        btnCalcular = view.findViewById(R.id.botao_calcular);
        btnInformacao = view.findViewById(R.id.botao_informacao);
    }

}
