package com.example.proyectogestionreservas.data.dao;

import com.example.proyectogestionreservas.data.entities.Habitacion;
import com.example.proyectogestionreservas.data.entities.Usuario;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UsuarioDao {
    @Insert
    void insertUsuario(Usuario usuario);

    @Delete
    public void delete(Usuario usuario);

    @Query("SELECT EXISTS (SELECT * from usuario where nombreUsuario=:nombreUsuario AND password=:password)")
    boolean login(String nombreUsuario,String password);

    @Query("SELECT * FROM usuario ORDER BY id")
    public LiveData<List<Usuario>> getAll();
}
