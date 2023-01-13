package com.example.proyectogestionreservas.viewmodel;

import android.app.Application;

import com.example.proyectogestionreservas.data.entities.Habitacion;
import com.example.proyectogestionreservas.data.entities.Usuario;
import com.example.proyectogestionreservas.data.repositories.HabitacionRepository;
import com.example.proyectogestionreservas.data.repositories.UsuarioRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class UsuarioViewModel extends AndroidViewModel {
    private final UsuarioRepository usuarioRepo;
    private final LiveData<List<Usuario>> listadoUsuarios;

    public UsuarioViewModel(@NonNull Application application) {
        super(application);
        this.usuarioRepo = new UsuarioRepository(application);
        this.listadoUsuarios = usuarioRepo.getAllR();
    }

    public LiveData<List<Usuario>> obtenerUsuarios(){
        return listadoUsuarios;
    }

    public void guardarUsuario(Usuario usuario){
        usuarioRepo.insert(usuario);
    }
}
