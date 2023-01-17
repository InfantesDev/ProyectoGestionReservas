package com.example.proyectogestionreservas.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "reservas")
public class Reserva {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name="idreserva")
    int idReserva;

    @ColumnInfo(name="fecha_reserva")
    String fechaReserva;

    @ColumnInfo(name="fecha_entrada")
    String fechaEntrada;

    @ColumnInfo(name="fecha_salida")
    String fechaSalida;

    @ColumnInfo(name="observaciones")
    String observaciones;

    @ColumnInfo(name="cliente_id")
    int idCliente;

    @ColumnInfo(name="habitacion_id")
    int idHabitacion;

    public Reserva(String fechaEntrada, String fechaSalida, String observaciones, int idCliente, int idHabitacion) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.observaciones = observaciones;
        this.idCliente = idCliente;
        this.idHabitacion = idHabitacion;
    }

    public int getIdReserva() {
        return idReserva;
    }
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    public String getFechaReserva() {
        return fechaReserva;
    }
    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
    public String getFechaEntrada() {
        return fechaEntrada;
    }
    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
    public String getFechaSalida() {
        return fechaSalida;
    }
    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public int getIdHabitacion() {
        return idHabitacion;
    }
    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }
}
