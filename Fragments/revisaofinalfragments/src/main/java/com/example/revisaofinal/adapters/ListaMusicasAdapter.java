package com.example.revisaofinal.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.revisao.R;
import com.example.revisaofinal.interfaces.RecyclerViewOnClick;
import com.example.revisaofinal.models.Musica;

import java.util.List;

public class ListaMusicasAdapter extends RecyclerView.Adapter<ListaMusicasAdapter.ViewHolder> {
    private List<Musica> listaMusicas;
    private RecyclerViewOnClick listener;

    public ListaMusicasAdapter(List<Musica> listaMusicas, RecyclerViewOnClick listener) {
        this.listaMusicas = listaMusicas;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_music_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Musica musica = listaMusicas.get(position);
        holder.onBind(musica);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.levarParaDetalhe(musica);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaMusicas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nomeMusica;
        private TextView nomeAlbum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nomeMusica = itemView.findViewById(R.id.list_item_musica);
            nomeAlbum = itemView.findViewById(R.id.list_item_album);
        }

        public void onBind(Musica musica) {
            nomeMusica.setText(musica.getMusica());
            nomeAlbum.setText(musica.getAlbum());
        }
    }
}
