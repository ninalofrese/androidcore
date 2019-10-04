package com.example.revisaofinal.views.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.revisao.R;
import com.example.revisaofinal.models.Musica;
import com.google.android.material.snackbar.Snackbar;

import static com.example.revisaofinal.views.fragment.ListasMusicasFragment.MUSICA_KEY;

public class DetalheMusicaActivity extends AppCompatActivity {
    private TextView txtMusica;
    private TextView txtAlbum;
    private TextView txtLetra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_musica);

        initViews();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button
        }

        if (getIntent() != null && getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            Musica musica = bundle.getParcelable(MUSICA_KEY);

            if (musica != null) {
                txtMusica.setText(musica.getMusica());
                txtAlbum.setText(musica.getAlbum());
                txtLetra.setText(musica.getLetra());
            } else {
                Snackbar.make(txtAlbum, "Mensagem", Snackbar.LENGTH_SHORT).show();
            }
        }
    }

    public void initViews() {
        txtMusica = findViewById(R.id.musica_nome);
        txtAlbum = findViewById(R.id.musica_album);
        txtLetra = findViewById(R.id.musica_letra);
    }

    //Set action on back button
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
