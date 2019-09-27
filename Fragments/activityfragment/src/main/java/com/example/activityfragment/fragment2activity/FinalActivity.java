package com.example.activityfragment.fragment2activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.activityfragment.R;

import static com.example.activityfragment.fragment2activity.InputFActivity.NOME_FRAG_KEY;

public class FinalActivity extends AppCompatActivity{
    private TextView displayNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        displayNome = findViewById(R.id.display_frag_nome);

        Intent intent = getIntent();

        if(intent != null && intent.getExtras() != null){
            Bundle bundle = intent.getExtras();

            String nome = bundle.getString(NOME_FRAG_KEY);

            displayNome.setText(nome);
        }

    }

//    @Override
//    public void deliverMessage(String mensagem) {
//        displayNome.setText(mensagem);
//    }
}
