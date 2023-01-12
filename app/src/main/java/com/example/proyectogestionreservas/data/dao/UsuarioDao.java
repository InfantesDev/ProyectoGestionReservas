package com.example.proyectogestionreservas.data.dao;

import com.example.proyectogestionreservas.data.entities.Usuario;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UsuarioDao {
    @Insert
    void insertUsuario(Usuario usuario);

    @Query("SELECT EXISTS (SELECT * from usuario where nombreUsuario=:nombreUsuario)")
    boolean is_taken(String nombreUsuario);

    @Query("SELECT EXISTS (SELECT * from usuario where nombreUsuario=:nombreUsuario AND password=:password)")
    boolean login(String nombreUsuario,String password);
}
