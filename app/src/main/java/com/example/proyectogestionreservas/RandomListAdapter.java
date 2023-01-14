package com.example.proyectogestionreservas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.proyectogestionreservas.data.entities.Habitacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RandomListAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{
    ArrayList<Parcela> parcelas= new ArrayList<>();
    //List<Habitacion> habitaciones = new ArrayList<>();

    public RandomListAdapter(ArrayList<Parcela> parcelas) {
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
