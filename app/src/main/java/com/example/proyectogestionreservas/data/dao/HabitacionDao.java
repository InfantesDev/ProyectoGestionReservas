package com.example.proyectogestionreservas.data.dao;

import com.example.proyectogestionreservas.data.entities.Habitacion;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface HabitacionDao {
    @Insert
    public void insert(Habitacion habitacion);

    @Update
    public void update(Habitacion habitacion);

    @Delete
    public void delete(Habitacion habitacion);

    @Query("SELECT * FROM habitaciones ORDER BY idhabitacion")
    public LiveData<List<Habitacion>> getAll();

    @Query("SELECT * FROM habitaciones WHERE idhabitacion = :miId")
    public Habitacion getOne(String miId);

    @Query("SELECT * FROM habitaciones WHERE precio BETWEEN :minPrecio AND :maxPrecio")
    public LiveData<List<Habitacion>> getAllPrices(int minPrecio, int maxPrecio);

    @Query("SELECT * FROM habitaciones WHERE descrip LIKE :search ")
    public LiveData<List<Habitacion>> findHabitacion(String search);
}
