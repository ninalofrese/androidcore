package com.example.revisaorecycler.adapters;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.revisaorecycler.R;
import com.example.revisaorecycler.interfaces.RecyclerViewOnClick;
import com.example.revisaorecycler.models.Animal;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {
    private List<Animal> listaAnimais;
    private RecyclerViewOnClick listener;

    public AnimalAdapter(List<Animal> listaAnimais, RecyclerViewOnClick listener) {
        this.listaAnimais = listaAnimais;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AnimalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_animal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalAdapter.ViewHolder holder, int position) {
        final Animal animal = listaAnimais.get(position);
        holder.onBind(animal);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(animal);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaAnimais.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView especie;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageView);
            especie = itemView.findViewById(R.id.textViewNome);
        }

        public void onBind(Animal animal) {

            Drawable drawable = itemView.getResources().getDrawable(animal.getImagem());

            image.setImageDrawable(drawable);
            especie.setText(animal.getRaca());
        }
    }
}
