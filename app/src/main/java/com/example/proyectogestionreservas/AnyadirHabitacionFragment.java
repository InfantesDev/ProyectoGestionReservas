package com.example.proyectogestionreservas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.proyectogestionreservas.data.entities.Habitacion;
import com.example.proyectogestionreservas.viewmodel.HabitacionViewModel;

public class AnyadirHabitacionFragment extends Fragment {

    Button btnAnyadir;
    HabitacionViewModel habitacionVM;
    public AnyadirHabitacionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_anyadir_habitacion, container, false);
        btnAnyadir=view.findViewById(R.id.button2);
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
        return view;
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