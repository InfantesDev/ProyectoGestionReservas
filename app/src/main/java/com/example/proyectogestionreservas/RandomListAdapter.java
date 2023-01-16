package com.example.proyectogestionreservas;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.proyectogestionreservas.data.entities.Habitacion;
import com.example.proyectogestionreservas.viewmodel.HabitacionViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class RandomListAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    List<Habitacion> habitaciones = new ArrayList<>();
    HabitacionViewModel hVM;

    public RandomListAdapter(List<Habitacion> habitaciones) {
        this.habitaciones=habitaciones;
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

    //TODO Listar Habitaciones
    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, int position) {
        //Pone texto correspondiente
        if (habitaciones!=null){
            habitaciones=hVM.obtenerHabitaciones().getValue();
            for (Habitacion habitacione : habitaciones) {
                holder.getView().setText(habitacione.getNombre());
                holder.getImageView().setImageResource(habitacione.getImagen());
            }
        }
        /*
        holder.getView().setText(habitaciones.get(1).getNombre());
        holder.getImageView().setImageResource(habitaciones.get(1).getImagen());

         */
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
        return 10;
    }
}
