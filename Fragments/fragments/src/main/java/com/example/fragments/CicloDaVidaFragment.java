package com.example.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CicloDaVidaFragment extends Fragment {


    public CicloDaVidaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i("Ciclo", "Fragment: método onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Ciclo", "Fragment: método onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("Ciclo", "Fragment: método onCreateView()");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ciclo_da_vida, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("Ciclo", "Fragment: método onActivityCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("Ciclo", "Fragment: método onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("Ciclo", "Fragment: método onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("Ciclo","Fragment: método onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("Ciclo", "Fragment: método onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("Ciclo", "Fragment: método onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo", "Fragment: método onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("Ciclo", "Fragment: método onDetach()");
    }
}
