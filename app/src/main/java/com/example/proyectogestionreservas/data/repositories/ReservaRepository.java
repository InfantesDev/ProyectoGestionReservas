package com.example.proyectogestionreservas.data.repositories;

import android.content.Context;

import com.example.proyectogestionreservas.data.AppDataBase;
import com.example.proyectogestionreservas.data.dao.ReservaDao;
import com.example.proyectogestionreservas.data.entities.Reserva;

import java.util.List;

import androidx.lifecycle.LiveData;

public class ReservaRepository {
    private ReservaDao reservaDao;

    private LiveData<List<Reserva>> listado_reservas;
    private Reserva mireserva;

    public ReservaRepository(Context context){
        AppDataBase db = AppDataBase.getInstance(context);
        reservaDao = db.reservaDao();
        listado_reservas=reservaDao.getAll();
    }
    //Se añade un método por cada operación del DAO que deseemos realizar
    public void insert (Reserva reserva){
        AppDataBase.dbExecutor.execute(
                ()->reservaDao.insert(reserva)
        );
    }
    public void delete(Reserva reserva){
        AppDataBase.dbExecutor.execute(
                ()->reservaDao.delete(reserva)
        );
    }
    //Todas las habitaciones
    public LiveData<List<Reserva>> getAllR(){
        return listado_reservas;
    }

    //Obtinene una habitacion
    public Reserva getOne(String miId){
        AppDataBase.dbExecutor.execute(
                ()->{mireserva=reservaDao.getOne(miId);}
        );
        return mireserva;
    }
}
