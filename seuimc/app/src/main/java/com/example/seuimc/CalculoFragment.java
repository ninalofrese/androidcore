package com.example.seuimc;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.example.seuimc.ShowActivity.DADOS_KEY;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculoFragment extends Fragment {
    private TextView textoResultado;

    public CalculoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculo, container, false);
        textoResultado = view.findViewById(R.id.texto_resultado);

        if (!getArguments().isEmpty()) {
            Pessoa pessoaDados = getArguments().getParcelable(DADOS_KEY);

            if (pessoaDados != null) {
                textoResultado.setText(calcularImc(pessoaDados.getPeso(), pessoaDados.getAltura()));
            }
        }

        return view;
    }

    private String calcularImc(Double peso, Double altura) {
        Double imc = peso / (altura * altura);

        if (imc < 18.5) {
            return "Seu IMC é de %.0f\nVocê está <b>abaixo do peso</b>";
        } else if (imc >= 18.5 && imc <= 24.9) {
            return "Seu IMC é de %.0f\nVocê está com o <b>peso normal</b>";
        } else if (imc >= 25.0 && imc <= 29.9) {
            return "Seu IMC é de %.0f\nVocê está com <b>sobrepeso</b>";
        } else if (imc >= 30.0 && imc <= 34.9) {
            return "Seu IMC é de %.0f\nVocê está com <b>obesidade grau 1</b>";
        } else if (imc >= 35.0 && imc <= 39.9) {
            return "Seu IMC é de %.0f\nVocê está com <b>obesidade grau 2</b>";
        } else if (imc >= 40.0) {
            return "Seu IMC é de %.0f\nVocê está com <b>obesidade grau 3</b>";
        } else {
            return "";
        }
    }
}
