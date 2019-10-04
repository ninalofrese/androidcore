package com.example.bandatabview.views.fragments;


import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bandatabview.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FotoFragment extends Fragment {
    private static final String NOME = "nome";
    private static final String IMAGEM = "imagem";
    private TextView txtNomeAlbum;
    private ImageView imgAlbum;

    public FotoFragment() {
        // Required empty public constructor
    }

    //static não precisa de instancia pra ser chamado
    public static Fragment novaInstancia(int imagem, String nomeAlbum) {
        FotoFragment fotoFragment = new FotoFragment();
        Bundle bundle = new Bundle();

        //as chaves sao privadas, entao esse metodo vai ser usado aqui
        bundle.putInt(IMAGEM, imagem);
        bundle.putString(NOME, nomeAlbum);

        fotoFragment.setArguments(bundle);

        return fotoFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_foto, container, false);
        initViews(view);

        if (getArguments() != null) {

            int imagemRecebida = getArguments().getInt(IMAGEM);
            String nomeRecebido = getArguments().getString(NOME);

            Drawable drawable = getResources().getDrawable(imagemRecebida);

            txtNomeAlbum.setText(nomeRecebido);
            imgAlbum.setImageDrawable(drawable);
        }

        return view;
    }

    public void initViews(View view) {
        txtNomeAlbum = view.findViewById(R.id.text_nome_album);
        imgAlbum = view.findViewById(R.id.imageView);
    }

}
