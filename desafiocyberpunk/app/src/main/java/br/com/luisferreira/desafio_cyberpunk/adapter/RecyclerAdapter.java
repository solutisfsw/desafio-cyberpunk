package br.com.luisferreira.desafio_cyberpunk.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.luisferreira.desafio_cyberpunk.R;
import br.com.luisferreira.desafio_cyberpunk.model.Clone;

/**
 * Created by Luis Ferreira on 24/02/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Clone> clones;

    public RecyclerAdapter(List<Clone> clones) {
        this.clones = clones;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Clone clone = clones.get(position);

        holder.textViewNomeClone.setText(clone.getNome());
        holder.textViewIdadeClone.setText(String.valueOf(clone.getIdade()));
        holder.textViewDataCriacao.setText(clone.getDataCriacao());
    }

    @Override
    public int getItemCount() {
        return clones.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewNomeClone, textViewIdadeClone, textViewDataCriacao;

        public ViewHolder(View view) {
            super(view);
            textViewNomeClone = view.findViewById(R.id.textViewNomeClone);
            textViewIdadeClone = view.findViewById(R.id.textViewIdadeClone);
            textViewDataCriacao = view.findViewById(R.id.textViewDataCriacao);
        }
    }
}