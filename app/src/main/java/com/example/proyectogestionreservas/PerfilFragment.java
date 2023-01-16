package com.example.proyectogestionreservas;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.proyectogestionreservas.data.entities.Habitacion;
import com.example.proyectogestionreservas.viewmodel.HabitacionViewModel;

public class PerfilFragment extends Fragment {

    Button btnAnyadir, btnLlamada, btnMapa;
    HabitacionViewModel habitacionVM;
    public PerfilFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_perfil, container, false);
        btnAnyadir=view.findViewById(R.id.btnHabitaciones);
        btnLlamada=view.findViewById(R.id.btnRealizarLlamadas);
        btnMapa=view.findViewById(R.id.btnAbrirMapa);
        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication());
        habitacionVM = new ViewModelProvider(this, (ViewModelProvider.Factory) factory).get(HabitacionViewModel.class);
        btnAnyadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarHabitacion();
                Toast.makeText(getActivity().getApplication(), "Habitaciones Creadas", Toast.LENGTH_SHORT).show();
            }
        });
        btnLlamada.setOnClickListener(view1-> realizarLlamada());
        btnMapa.setOnClickListener(view1-> mostrarLocalizacion());
        return view;
    }
    //Realizar Llamada
    public void realizarLlamada(){
        Uri number= Uri.parse("tel:666666666");
        Intent callIntent = new Intent(Intent.ACTION_DIAL,number);
        startActivity(callIntent);
    }
    //Localizacion Hotel
    public void mostrarLocalizacion(){
        //TODO Coger un localizacion de un hotel
        Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        try {
            startActivity(mapIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getActivity().getApplication(), "NO SE PUEDE MOSTRAR EL MAPA", Toast.LENGTH_SHORT).show();
        }
    }
    //Guardar Habitacion
    public void guardarHabitacion(){
        habitacionVM.guardarHabitacion(new Habitacion("Habitacion Pequeña 1",
                "Descripcion",20.3, R.drawable.ic_search_foreground));
        habitacionVM.guardarHabitacion(new Habitacion("Habitacion Pequeña 2",
                "Descripcion",20.3, R.drawable.ic_profile_foreground));
        habitacionVM.guardarHabitacion(new Habitacion("Habitacion Mediana 1",
                "Descripcion",30.3, R.drawable.ic_search_foreground));
        habitacionVM.guardarHabitacion(new Habitacion("Habitacion Mediana 2",
                "Descripcion",30.3, R.drawable.ic_task_foreground));
        habitacionVM.guardarHabitacion(new Habitacion("Habitacion Grande 1",
                "Descripcion",40.3, R.drawable.ic_search_foreground));
        habitacionVM.guardarHabitacion(new Habitacion("Habitacion Grande 2",
                "Descripcion",40.3, R.drawable.ic_task_foreground));
    }
}