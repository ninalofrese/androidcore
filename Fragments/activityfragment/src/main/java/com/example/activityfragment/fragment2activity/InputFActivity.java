package com.example.activityfragment.fragment2activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.example.activityfragment.R;

public class InputFActivity extends AppCompatActivity implements Comunicador {
    public static final String NOME_FRAG_KEY = "nome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_f);

        replaceFragment(R.id.container_input_fragment, new InputFragment());
    }

    public void replaceFragment(int container, Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }

    @Override
    public void deliverMessage(String mensagem) {
        Intent intent = new Intent(InputFActivity.this, FinalActivity.class);
        Bundle bundle = new Bundle();

        bundle.putString(NOME_FRAG_KEY, mensagem);
        intent.putExtras(bundle);

        startActivity(intent);
    }
}
