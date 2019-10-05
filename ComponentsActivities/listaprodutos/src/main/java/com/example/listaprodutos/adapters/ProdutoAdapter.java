package com.example.listaprodutos.adapters;

import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listaprodutos.R;
import com.example.listaprodutos.interfaces.RecyclerViewOnClick;
import com.example.listaprodutos.models.Produto;

import java.text.DecimalFormat;
import java.util.List;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ViewHolder> {
    private List<Produto> listaProdutos;
    private RecyclerViewOnClick listener;

    public ProdutoAdapter(List<Produto> listaProdutos, RecyclerViewOnClick listener) {
        this.listaProdutos = listaProdutos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_produto, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Produto produto = listaProdutos.get(position);
        holder.onBind(produto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(produto);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaProdutos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView viewImagem;
        private TextView txtNome;
        private TextView txtPreco;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            viewImagem = itemView.findViewById(R.id.productImage);
            txtNome = itemView.findViewById(R.id.productName);
            txtPreco = itemView.findViewById(R.id.productPrice);
        }

        public void onBind(Produto produto) {
            Drawable drawable = itemView.getResources().getDrawable(produto.getImagem());
            DecimalFormat formato = new DecimalFormat("R$ #,##");

            viewImagem.setImageDrawable(drawable);
            txtNome.setText(produto.getNome());
            txtPreco.setText(formato.format(produto.getPreco()));
        }
    }
}
