package com.example.gerenciadordeprovasdeconcursos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProvasAdapter extends RecyclerView.Adapter<ProvasViewHolder> {
    private Context context;
    private ArrayList<Provas> provas;
    ProvasDAO provasDAO;
    public ProvasAdapter (Context context){
        this.context= context;
        provasDAO= new ProvasDAO(context);
        update();
    }
    public void update(){
        provas=provasDAO.getList();
    }

    public ProvasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ConstraintLayout v = (ConstraintLayout) LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        ProvasViewHolder vh = new ProvasViewHolder(v, context);
        return vh;
    }
    public void onBindViewHolder(ProvasViewHolder holder, int position) {
        holder.empresa.setText(provas.get(position).getEmpresa());
        holder.id= provas.get(position).getId();
    }
    public int getItemCount() { return provas.size(); }
}
