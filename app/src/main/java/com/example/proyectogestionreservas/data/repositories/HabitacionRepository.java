package com.example.proyectogestionreservas.data.repositories;

import android.content.Context;

import com.example.proyectogestionreservas.data.AppDataBase;
import com.example.proyectogestionreservas.data.dao.HabitacionDao;
import com.example.proyectogestionreservas.data.entities.Habitacion;

import java.util.List;

import androidx.lifecycle.LiveData;

public class HabitacionRepository {
    private HabitacionDao habitacionDao;

    private LiveData<List<Habitacion>> listado_habitaciones;
    private Habitacion mihabitacion;

    public HabitacionRepository(Context context){
        AppDataBase db = AppDataBase.getInstance(context);
        habitacionDao = db.habitacionDao();
        listado_habitaciones = habitacionDao.getAll();
    }
    //Se añade un método por cada operación del DAO que deseemos realizar

    public void insert (Habitacion habitacion){
        AppDataBase.dbExecutor.execute(
                ()->habitacionDao.insert(habitacion)
        );
    }
    public void delete(Habitacion habitacion){
        AppDataBase.dbExecutor.execute(
                ()->habitacionDao.delete(habitacion)
        );
    }
    public LiveData<List<Habitacion>> getAllR(){
        return listado_habitaciones;
    }

    /*public Habitacion getOne(String miId){
        AppDataBase.dbExecutor.execute(
                ()->{mihabitacion=habitacionDao.getOne(miId);}
        );
        return mihabitacion;
    }*/
}
