package com.example.gerenciadordeprovasdeconcursos;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ProvasViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public Context context;
    public TextView empresa;
    public int id;

    public ProvasViewHolder(ConstraintLayout v, Context context){
        super(v);
        this.context= context;
        empresa= v.findViewById(R.id.itemName);
        v.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intent = new Intent(context, EditActivity.class);
        intent.putExtra("provaId", this.id);
        context.startActivity(intent);
    }
}
