package com.example.activityfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.activityfragment.activity2fragment.InputActivity;
import com.example.activityfragment.fragment2activity.InputFActivity;

public class IntroActivity extends AppCompatActivity {
    private Button btnActivity;
    private Button btnFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        btnActivity = findViewById(R.id.caminho_activity);
        btnFragment = findViewById(R.id.caminho_fragmento);

        btnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntroActivity.this, InputActivity.class));
            }
        });

        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntroActivity.this, InputFActivity.class));
            }
        });
    }
}
