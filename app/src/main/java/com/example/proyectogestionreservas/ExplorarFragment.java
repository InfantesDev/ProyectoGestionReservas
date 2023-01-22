package com.example.proyectogestionreservas;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.proyectogestionreservas.data.entities.Habitacion;
import com.example.proyectogestionreservas.viewmodel.HabitacionViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Fragment Explorar Recycler View vertical con todas las habitaciones disponibles
 */
public class ExplorarFragment extends Fragment implements LifecycleOwner{
    ExplorarFragment context;
    //RecyclerView añadido
    RecyclerView recyclerView;
    //Mostrar datos
    HabitacionViewModel hVM;
    //Listado
    List<Habitacion> habitaciones;
    RandomListAdapter recyclerViewAdapter;
    //Constructor
    public ExplorarFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    //Pone el recyclerView con ayuda del adaptador en pantalla con onCLick
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explorar, container, false);
        context=this;
        //Crear RecyclerView
        recyclerView=view.findViewById(R.id.recyclerView);
        //OnClick navega hacia pantalla de MostrarActivity
        recyclerViewAdapter=new RandomListAdapter(new RandomListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Habitacion habitacion) {
                Intent intent = new Intent(getActivity(), MostrarActivity.class);
                intent.putExtra("habitacionNombre", habitacion.getNombre());
                intent.putExtra("habitacionId", habitacion.getIdHabitacion());
                startActivity(intent);
                Toast.makeText(getContext(), "Click Habitacion", Toast.LENGTH_LONG).show();
            }
        });
        recyclerView.setAdapter(recyclerViewAdapter);
        hVM=new ViewModelProvider(context).get(HabitacionViewModel.class);
        //Visualizar habitaciones
        hVM.obtenerHabitaciones().observe(getViewLifecycleOwner(),actualizarListHabitacionObserver);
        return view;
    }

    Observer<List<Habitacion>> actualizarListHabitacionObserver=new Observer<List<Habitacion>>() {
        @Override
        public void onChanged(List<Habitacion> habitacions) {
            recyclerViewAdapter.actualizarListaUsuario(habitacions);
        }
    };
}