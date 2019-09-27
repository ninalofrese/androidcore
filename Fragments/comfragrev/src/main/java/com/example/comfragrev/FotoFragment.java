package com.example.comfragrev;


import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.comfragrev.MainActivity.ANIMAL_KEY;


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
            Animal animal = getArguments().getParcelable(ANIMAL_KEY);

            if(animal != null){
                Drawable drawable = getResources().getDrawable(animal.getImagem());

                foto.setImageDrawable(drawable);
                nome.setText(animal.getNome());
            }

        }

        return view;
    }

    public void initViews(View view) {
        foto = view.findViewById(R.id.imageView_foto);
        nome = view.findViewById(R.id.textView_nome);
    }

}
