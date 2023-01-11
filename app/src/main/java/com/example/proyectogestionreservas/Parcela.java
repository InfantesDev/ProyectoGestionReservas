package com.example.proyectogestionreservas;

import android.widget.ImageView;

public class Parcela {
    public String titulo;
    public int imageId;

    public Parcela(String titulo, int imageId) {
        this.titulo = titulo;
        this.imageId = imageId;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getImageView() {
        return imageId;
    }
    public void setImageView(int imageId) {
        this.imageId = imageId;
    }
}
