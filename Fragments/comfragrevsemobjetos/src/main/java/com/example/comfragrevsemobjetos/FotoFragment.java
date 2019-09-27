package com.example.comfragrevsemobjetos;


import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.comfragrevsemobjetos.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FotoFragment extends Fragment {
    private ImageView foto;
    private TextView nome;

    public FotoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_foto, container, false);

        initViews(view);

        if (!getArguments().isEmpty()) {
            String incomingName = getArguments().getString(MainActivity.NOME_KEY);
            int incomingImage = getArguments().getInt(MainActivity.IMG_KEY);

            if(incomingName != null){
                Drawable drawable = getResources().getDrawable(incomingImage);

                foto.setImageDrawable(drawable);
                nome.setText(incomingName);
            }

        }

        return view;
    }

    public void initViews(View view) {
        foto = view.findViewById(R.id.imageView_foto);
        nome = view.findViewById(R.id.textView_nome);
    }

}
