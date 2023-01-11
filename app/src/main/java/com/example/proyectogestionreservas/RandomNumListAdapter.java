package com.example.proyectogestionreservas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RandomNumListAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{
    ArrayList<Parcela> parcelas= new ArrayList<>();
    //Refactor
    private Random random;

    public RandomNumListAdapter(ArrayList<Parcela> parcelas) {
        this.parcelas=parcelas;
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.parcela_frame_card;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        //Pone texto correspondiente
        holder.getView().setText(parcelas.get(position).titulo);
        holder.getImageView().setImageResource(parcelas.get(position).imageId);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO Pasar a nueva pantalla Activity
                Toast.makeText(view.getContext(), "CLICK!!", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return parcelas.size();
    }
}
