package com.example.seuimc;


import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

import static com.example.seuimc.MainActivity.OPCAO_KEY;
import static com.example.seuimc.MainActivity.PA_KEY;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculoFragment extends Fragment {
    private TextView textoResultado;
    private ImageView imgFragment;

    public CalculoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculo, container, false);
        textoResultado = view.findViewById(R.id.texto_resultado);
        imgFragment = view.findViewById(R.id.imagem_fragment);

        if (!getArguments().isEmpty()) {
            Pessoa pessoaDados = getArguments().getParcelable(PA_KEY);
            Opcao opcao = getArguments().getParcelable(OPCAO_KEY);

            if (opcao != null) {

                Drawable drawable = getResources().getDrawable(opcao.getImagem());
                imgFragment.setImageDrawable(drawable);

                //Se o texto do objeto opcao for "calculo", ele sera desconsiderado para o setText e sera inserido o calculo do IMC
                if (opcao.getTexto() == "calculo") {
                    textoResultado.setText(calcularImc(pessoaDados.getPeso(), pessoaDados.getAltura()));
                } else {
                    //O botao de informacao cai aqui, ele vai setar o que foi passado no objeto
                    textoResultado.setText(opcao.getTexto());
                }

            } else {
                Snackbar.make(container, "Não há dados!", Snackbar.LENGTH_LONG).show();
            }
        }

        return view;
    }

    public String calcularImc(Double peso, Double altura) {
        Double imc = peso / (altura * altura);

        if (imc < 18.5) {
            return String.format(Locale.US, "Seu IMC é de %.1f\nVocê está ABAIXO DO PESO", imc);
        } else if (imc >= 18.5 && imc <= 24.9) {
            return String.format(Locale.US, "Seu IMC é de %.1f\nVocê está com o PESO NORMAL", imc);
        } else if (imc >= 25.0 && imc <= 29.9) {
            return String.format(Locale.US, "Seu IMC é de %.1f\nVocê está com SOBREPESO", imc);
        } else if (imc >= 30.0 && imc <= 34.9) {
            return String.format(Locale.US, "Seu IMC é de %.1f\nVocê está com OBESIDADE GRAU 1", imc);
        } else if (imc >= 35.0 && imc <= 39.9) {
            return String.format(Locale.US, "Seu IMC é de %.1f\nVocê está com OBESIDADE GRAU 2", imc);
        } else if (imc >= 40.0) {
            return String.format(Locale.US, "Seu IMC é de %.1f\nVocê está com OBESIDADE GRAU 3", imc);
        } else {
            return "";
        }
    }
}
