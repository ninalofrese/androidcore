package com.example.listaalunos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AlunoAdapter extends RecyclerView.Adapter<AlunoAdapter.ViewHolder> {
    private List<Aluno> listaAluno;

    public AlunoAdapter(List<Aluno> listaAluno) {
        this.listaAluno = listaAluno;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_aluno, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Aluno aluno = listaAluno.get(position);
        holder.onBind(aluno);
    }

    @Override
    public int getItemCount() {
        return listaAluno.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNome;
        private TextView txtTelefone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNome = itemView.findViewById(R.id.aluno_nome);
            txtTelefone = itemView.findViewById(R.id.aluno_telefone);
        }

        public void onBind(Aluno aluno) {
            txtNome.setText(aluno.getNome());
            txtTelefone.setText(aluno.getTelefone());
        }
    }
}
