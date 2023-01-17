package com.example.proyectogestionreservas.viewmodel;

import android.app.Application;

import com.example.proyectogestionreservas.data.entities.Reserva;
import com.example.proyectogestionreservas.data.repositories.ReservaRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ReservaViewModel extends AndroidViewModel {
    private final ReservaRepository rRepo;
    private final LiveData<List<Reserva>> listadoReservas;

    public ReservaViewModel(@NonNull Application application) {
        super(application);
        this.rRepo = new ReservaRepository(application);
        this.listadoReservas = rRepo.getAllR();
    }

    public LiveData<List<Reserva>> obtenerReservas(){
        return listadoReservas;
    }

    public void guardarHabitacion(Reserva reserva){
        rRepo.insert(reserva);
    }
    public void eleminarHabitacion(Reserva reserva){
        rRepo.delete(reserva);
    }
}
