package com.example.comfragmentscolor.views;


import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.comfragmentscolor.R;
import com.example.comfragmentscolor.models.Cor;

import static com.example.comfragmentscolor.views.MainActivity.COLOR_KEY;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {
    private FrameLayout frame;
    private TextView text;

    public ColorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_color, container, false);

        initViews(view);

        //se os argumentos passados pelo comunicador não são vazios
        if(!getArguments().isEmpty()){
            Cor color = getArguments().getParcelable(COLOR_KEY);

            if(color != null){
                int corEscolhida = ContextCompat.getColor(getContext(),color.getColor());

                frame.setBackgroundColor(corEscolhida);
                text.setText(color.getNomeDaCor());
            }
        }

        return view;
    }

    public void initViews(View view){
        frame = view.findViewById(R.id.frame_background);
        text = view.findViewById(R.id.frame_textview);
    }
}
