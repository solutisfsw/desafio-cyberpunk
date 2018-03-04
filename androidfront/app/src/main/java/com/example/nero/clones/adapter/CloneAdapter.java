package com.example.nero.clones.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nero.clones.AlterarClone;
import com.example.nero.clones.DeleteClone;
import com.example.nero.clones.R;
import com.example.nero.clones.model.Clone;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Nero on 25/02/2018.
 */

public class CloneAdapter extends ArrayAdapter {

    private final ArrayList<Clone> clones;
    private final Context context;

    public CloneAdapter(@NonNull Context context, ArrayList<Clone> clones) {
        super(context,R.layout.linha_clone, clones);
        this.context = context;
        this.clones = clones;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable final View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View linha = layoutInflater.inflate(R.layout.linha_clone, parent, false);


        TextView txtNome = linha.findViewById(R.id.clone_nome);
        TextView txtDt = linha.findViewById(R.id.clone_dt_criacao);

        ImageView edit = linha.findViewById(R.id.btn_edit_clone);
        ImageView delete = linha.findViewById(R.id.btn_delete_clone);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Clone clone = clones.get(position);
                Intent intent = new Intent(getContext(), AlterarClone.class);
                intent.putExtra("clone", clone);
                intent.putExtra("adicionais", (Serializable) clone.getAdicionais());
                getContext().startActivity(intent);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Clone clone = clones.get(position);
                Intent intent = new Intent(getContext(), DeleteClone.class);
                intent.putExtra("clone", clone.getId());
                getContext().startActivity(intent);
            }
        });

        txtNome.setText(clones.get(position).getNome());
        txtDt.setText(clones.get(position).getDataCriacao().toString());
        return linha;
    }
}
