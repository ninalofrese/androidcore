package com.example.comfragmentscars.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.comfragmentscars.R;

import static com.example.comfragmentscars.views.RegisterActivity.NAME_KEY;

public class WelcomeActivity extends AppCompatActivity {
    private TextView textHello;
    private TextView textDescription;
    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        initViews();

        Intent intent = getIntent();

        if(intent != null && intent.getExtras() != null){
            Bundle bundle = intent.getExtras();

            String name = bundle.getString(NAME_KEY);

            textHello.setText("Olá " + name);
            textDescription.setText(R.string.welcome_description);

            buttonNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(WelcomeActivity.this, CarsActivity.class));
                }
            });
        }
    }

    public void initViews(){
        textHello = findViewById(R.id.textView_welcome_hello);
        textDescription = findViewById(R.id.textView_welcome_description);
        buttonNext = findViewById(R.id.button_welcome_next);
    }
}
