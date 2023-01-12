package com.example.proyectogestionreservas.viewmodel;

import android.app.Application;

import com.example.proyectogestionreservas.data.entities.Habitacion;
import com.example.proyectogestionreservas.data.repositories.HabitacionRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class HabitacionViewModel extends AndroidViewModel {
    private final HabitacionRepository hRepo;
    private final LiveData<List<Habitacion>> listadoHabitaciones;

    public HabitacionViewModel(@NonNull Application application) {
        super(application);
        this.hRepo = new HabitacionRepository(application);
        this.listadoHabitaciones = hRepo.getAllR();
    }

    public LiveData<List<Habitacion>> obtenerHabitaciones(){
        return listadoHabitaciones;
    }

    public void guardarHabitacion(Habitacion habitacion){
        hRepo.insert(habitacion);
    }
    public void eleminarHabitacion(Habitacion habitacion){
        hRepo.delete(habitacion);
    }
}
