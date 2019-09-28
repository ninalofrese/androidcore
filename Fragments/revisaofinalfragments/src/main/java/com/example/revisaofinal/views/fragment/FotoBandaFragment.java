package com.example.revisaofinal.views.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.revisao.R;
import com.example.revisaofinal.views.activity.StartActivity;

import static com.example.revisaofinal.views.activity.HomeActivity.BANDA_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class FotoBandaFragment extends Fragment {
    private TextView txtNomeBanda;
    private Button btnVoltar;

    public FotoBandaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_foto_banda, container, false);
        initViews(view);

        //Implementar a lógica de verificação dos dados recebidos e setar o nome da banda no textView
        if (!getArguments().isEmpty()) {
            String banda = getArguments().getString(BANDA_KEY);
            txtNomeBanda.setText(banda);
        }

        //Implementar a lógica de ação do botão voltar
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), StartActivity.class));
            }
        });
        return view;

    }

    public void initViews(View view) {
        txtNomeBanda = view.findViewById(R.id.textViewNomeBanda);
        btnVoltar = view.findViewById(R.id.btnVoltar);
    }

}
