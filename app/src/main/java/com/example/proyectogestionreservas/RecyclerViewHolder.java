package com.example.proyectogestionreservas;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    private TextView view;
    private ImageView imageView;
    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView.findViewById(R.id.randomText);
        imageView=itemView.findViewById(R.id.imagen);
    }
    public TextView getView(){
        return view;
    }
    public ImageView getImageView(){
        return imageView;
    }
}
