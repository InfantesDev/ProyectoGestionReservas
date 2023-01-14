package com.example.proyectogestionreservas.data.repositories;

import android.content.Context;

import com.example.proyectogestionreservas.data.AppDataBase;
import com.example.proyectogestionreservas.data.dao.UsuarioDao;
import com.example.proyectogestionreservas.data.entities.Usuario;

import java.util.List;

import androidx.lifecycle.LiveData;

public class UsuarioRepository {
    private UsuarioDao usuarioDao;

    private LiveData<List<Usuario>> listado_usuarios;
    private Usuario miUsuario;

    public UsuarioRepository(Context context){
        AppDataBase db = AppDataBase.getInstance(context);
        usuarioDao = db.usuarioDao();
        listado_usuarios = usuarioDao.getAll();
    }

    public void insert (Usuario usuario){
        AppDataBase.dbExecutor.execute(
                ()->usuarioDao.insertUsuario(usuario)
        );
    }
    public void delete(Usuario usuario){
        AppDataBase.dbExecutor.execute(
                ()->usuarioDao.delete(usuario)
        );
    }
    public LiveData<List<Usuario>> getAllR(){
        return listado_usuarios;
    }
}
