package com.example.proyectogestionreservas.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "usuario")
public class Usuario {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name="id")
    private int id;

    @ColumnInfo(name="nombreUsuario")
    private String nombreUsuario;

    @ColumnInfo(name="password")
    private String password;

    @ColumnInfo(name = "dni")
    private String dni;

    @ColumnInfo(name = "apellido")
    private String apellido;

    @ColumnInfo(name = "telefono")
    private String telefono;

    public Usuario(String nombreUsuario, String password, String dni, String apellido, String telefono) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.dni=dni;
        this.apellido=apellido;
        this.telefono=telefono;
    }

    @NonNull
    public int getId() {
        return id;
    }
    public void setId(@NonNull int id) {
        this.id = id;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
