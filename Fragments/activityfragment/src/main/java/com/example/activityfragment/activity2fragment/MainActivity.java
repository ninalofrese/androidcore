package com.example.activityfragment.activity2fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.example.activityfragment.R;

import static com.example.activityfragment.activity2fragment.InputActivity.NOME_KEY;

public class MainActivity extends AppCompatActivity {
    public static final String MSG_KEY = "name" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        if (intent != null && intent.getExtras() != null) {
            Bundle bundle = intent.getExtras();

            String nome = bundle.getString(NOME_KEY);


            replaceFragment(R.id.container, new ShowFragment(), nome);
        }
    }

    public void replaceFragment(int container, Fragment fragment, String nome) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString(MSG_KEY, nome);
        fragment.setArguments(bundle);
        transaction.replace(container, fragment);
        transaction.commit();
    }

}
