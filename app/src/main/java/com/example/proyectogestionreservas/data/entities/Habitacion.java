package com.example.proyectogestionreservas.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "habitaciones")
public class Habitacion {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name ="idhabitacion")
    public
    int idHabitacion;

    @ColumnInfo(name = "nombre")
    String nombre;

    @ColumnInfo(name ="descrip")
    String descrip;

    @ColumnInfo(name ="precio")
    double precio;

    @ColumnInfo(name ="imagen")
    int imagen;

    @ColumnInfo(name="num_camas")
    int numCamas;

    @ColumnInfo(name="suite")
    boolean suite;

    public Habitacion(String nombre, String descrip, double precio, int imagen) {
        this.nombre=nombre;
        this.descrip = descrip;
        this.precio = precio;
        this.imagen = imagen;
    }

    /*
    public Habitacion(String nombre, String descrip, double precio, int imagen, int numCamas, boolean suite) {
        this.nombre=nombre;
        this.descrip = descrip;
        this.precio = precio;
        this.imagen = imagen;
        this.numCamas=numCamas;
        this.suite=suite;
    }

     */

    @NonNull
    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(@NonNull int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getNumCamas() {
        return numCamas;
    }

    public void setNumCamas(int numCamas) {
        this.numCamas = numCamas;
    }

    public boolean isSuite() {
        return suite;
    }

    public void setSuite(boolean suite) {
        this.suite = suite;
    }
}
