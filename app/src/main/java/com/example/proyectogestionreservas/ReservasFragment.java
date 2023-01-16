package com.example.proyectogestionreservas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectogestionreservas.data.entities.Habitacion;
import com.example.proyectogestionreservas.viewmodel.HabitacionViewModel;

import java.util.ArrayList;
import java.util.List;

public class ReservasFragment extends Fragment {

    //RecyclerView añadido
    private RecyclerView recyclerView;

    //ViewModel Habitaciones
    private HabitacionViewModel hVM;

    public ReservasFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reservas, container, false);

        //Crear Arraylist
        //ArrayList<Parcela> parcelas = datos_parcela();
        //Crear List
        List<Habitacion> habitaciones=datosListHabitacion();
        //Estructura RecyclerView
        recyclerView=view.findViewById(R.id.recyclerViewMisReservas);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        //Pasar datos al adapter
        recyclerView.setAdapter(new RandomListAdapter(habitaciones));
        return view;
    }

    //TODO Recycle con todas la habitaciones
    public List<Habitacion> datosListHabitacion(){
        List<Habitacion> listadoHabitaciones= new ArrayList<>();
        listadoHabitaciones=hVM.obtenerHabitaciones().getValue();
        return listadoHabitaciones;
    }
    public ArrayList<Parcela> datos_parcela(){
        ArrayList<Parcela> parcelas = new ArrayList<>();
        parcelas.add(new Parcela("Parela 1", R.drawable.ic_search_foreground));
        parcelas.add(new Parcela("Parela 2", R.drawable.ic_search_foreground));
        parcelas.add(new Parcela("Parela 3", R.drawable.ic_launcher_foreground));
        parcelas.add(new Parcela("Parela 4", R.drawable.ic_profile_foreground));
        return parcelas;
    }
}