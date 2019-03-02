package br.com.luisferreira.desafiocyberpunk.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

import br.com.luisferreira.desafiocyberpunk.Interface.ItemClickListener;
import br.com.luisferreira.desafiocyberpunk.R;
import br.com.luisferreira.desafiocyberpunk.activities.CloneActivity;
import br.com.luisferreira.desafiocyberpunk.model.Clone;

/**
 * Created by Luis Ferreira on 04/03/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Clone> cloneList;
    private Context context;
    private FirebaseFirestore firebaseFirestore;

    public RecyclerAdapter(List<Clone> cloneList, Context context, FirebaseFirestore firebaseFirestore) {
        this.cloneList = cloneList;
        this.context = context;
        this.firebaseFirestore = firebaseFirestore;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final int itemPosition = position;
        final Clone clone = cloneList.get(itemPosition);

        holder.textViewNomeClone.setText(clone.getNome());
        holder.textViewIdadeClone.setText(String.valueOf(clone.getIdade()) + " Anos");
        holder.textViewDataCriacao.setText(clone.getDataCriacao());

        if (clone.getAdicionais().isEmpty()) {
            holder.textViewAdicionais.setText("Este clone não possui itens adicionais!");
        } else {
            holder.textViewAdicionais.setText(TextUtils.join(", ", clone.getAdicionais()));
        }

        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(view.getContext(), CloneActivity.class);
                intent.putExtra("isUpdating", true);
                intent.putExtra("idClone", clone.getId());
                intent.putExtra("textViewNomeClone", holder.textViewNomeClone.getText());
                intent.putExtra("textViewIdadeClone", holder.textViewIdadeClone.getText());
                intent.putExtra("textViewAdicionais", holder.textViewAdicionais.getText());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cloneList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewNomeClone, textViewIdadeClone, textViewDataCriacao, textViewAdicionais;
        private ItemClickListener clickListener;

        public ViewHolder(View view) {
            super(view);
            textViewNomeClone = view.findViewById(R.id.textViewNomeClone);
            textViewIdadeClone = view.findViewById(R.id.textViewIdadeClone);
            textViewDataCriacao = view.findViewById(R.id.textViewDataCriacao);
            textViewAdicionais = view.findViewById(R.id.textViewAdicionais);

            view.setOnClickListener(this);
        }

        public void setClickListener(ItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getAdapterPosition());
        }
    }

    public void deleteClone(String id, final int position) {
        firebaseFirestore.collection("clones")
                .document(id)
                .delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        cloneList.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, cloneList.size());
                        Toast.makeText(context, "O clone foi deletado!", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}