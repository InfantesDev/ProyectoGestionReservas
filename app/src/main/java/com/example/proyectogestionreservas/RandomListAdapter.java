package com.example.proyectogestionreservas;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectogestionreservas.data.entities.Habitacion;
import com.example.proyectogestionreservas.viewmodel.HabitacionViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RandomListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Habitacion habitacion);
    }
    private final OnItemClickListener listener;
    private List<Habitacion> habitaciones;

    HabitacionViewModel hVM;

    public RandomListAdapter(OnItemClickListener listener) {
        this.habitaciones=new ArrayList<Habitacion>();
        this.listener=listener;
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.parcela_frame_card;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType,parent,false);
        return new RecyclerViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Habitacion habitacion = habitaciones.get(position);
        RecyclerViewViewHolder viewHolder=(RecyclerViewViewHolder) holder;
        viewHolder.getView().setText(habitacion.getNombre());
        viewHolder.getImageView().setImageResource(habitacion.getImagen());
        viewHolder.bind(habitacion, listener);
    }

    @Override
    public int getItemCount() {
        return habitaciones.size();
    }

    public void actualizarListaUsuario(final List<Habitacion> habitacionListado){
        this.habitaciones.clear();
        this.habitaciones=habitacionListado;
        notifyDataSetChanged();
    }

    static class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imagen);
            textView = itemView.findViewById(R.id.randomText);
        }
        public void bind(final Habitacion habitacion, final OnItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(habitacion);
                }
            });
        }
        public TextView getView(){
            return textView;
        }
        public ImageView getImageView(){
            return imageView;
        }
    }
}

