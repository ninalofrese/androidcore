package com.example.comunicacaoentrefragments.views;


import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.comunicacaoentrefragments.R;
import com.example.comunicacaoentrefragments.model.SistemaOperacional;

import static com.example.comunicacaoentrefragments.views.MainActivity.SO_KEY;


/**
 * A simple {@link Fragment} subclass.
 */
public class SegundoFragment extends Fragment {
    private ImageView imagem;
    private TextView txtNome;

    public SegundoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_segundo, container, false);

        initViews(view);

        if(!getArguments().isEmpty()){
            SistemaOperacional sistemaOperacional = getArguments().getParcelable(SO_KEY);

            if(sistemaOperacional != null){

                Drawable drawable = getResources().getDrawable(sistemaOperacional.getImagem());

                imagem.setImageDrawable(drawable);
                txtNome.setText(sistemaOperacional.getNome());
            }
        }

        // Inflate the layout for this fragment
        return view;
    }

    public void initViews(View view){
        imagem = view.findViewById(R.id.image);
        txtNome = view.findViewById(R.id.texto);
    }
}
