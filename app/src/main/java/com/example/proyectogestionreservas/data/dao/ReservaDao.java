package com.example.proyectogestionreservas.data.dao;

import com.example.proyectogestionreservas.data.entities.Habitacion;
import com.example.proyectogestionreservas.data.entities.Reserva;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ReservaDao {
    @Insert
    public void insert(Reserva reserva);

    @Update
    public void update(Reserva reserva);

    @Delete
    public void delete(Reserva reserva);

    @Query("SELECT * FROM reservas ORDER BY idreserva")
    public LiveData<List<Reserva>> getAll();

    @Query("SELECT * FROM reservas WHERE idreserva = :miId")
    public Reserva getOne(String miId);
}
