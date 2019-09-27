package com.example.activityfragment.activity2fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.activityfragment.R;

import static com.example.activityfragment.activity2fragment.MainActivity.MSG_KEY;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowFragment extends Fragment {
    private TextView displayNome;

    public ShowFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show, container, false);

        displayNome = view.findViewById(R.id.display_nome);

        if(!getArguments().isEmpty()){
            String nome = getArguments().getString(MSG_KEY);
            displayNome.setText(nome);
        }

        return view;
    }

}
