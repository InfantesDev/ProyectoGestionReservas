package com.example.proyectogestionreservas;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.proyectogestionreservas.data.entities.Habitacion;
import com.example.proyectogestionreservas.data.entities.Reserva;
import com.example.proyectogestionreservas.viewmodel.HabitacionViewModel;
import com.example.proyectogestionreservas.viewmodel.ReservaViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Fragment Reservas con recyclerView de las reservas creadas
 */
public class ReservasFragment extends Fragment implements LifecycleOwner {
    //Fragment context this
    ReservasFragment context;
    //RecyclerView añadido
    RecyclerView recyclerView;
    //ViewModel Habitaciones
    ReservaViewModel rVM;
    //Listado
    List<Reserva> reservas;
    ReservaListAdapter recyclerViewAdapter;
    //Constructor
    public ReservasFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    //Pone el recyclerView con ayuda del adaptador en pantalla con onCLick
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reservas, container, false);
        context=this;
        recyclerView=view.findViewById(R.id.recyclerViewMisReservas);
        //OnClick
        recyclerViewAdapter=new ReservaListAdapter(new ReservaListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Reserva reserva) {
                Log.i("Info Click","Item Click");
                Toast.makeText(getActivity(), "Click Reserva", Toast.LENGTH_LONG).show();
            }
        });
        recyclerView.setAdapter(recyclerViewAdapter);
        //ViewModel reservas
        rVM=new ViewModelProvider(context).get(ReservaViewModel.class);
        rVM.obtenerReservas().observe(getViewLifecycleOwner(),actualizarListReservaObserver);
        return view;
    }
    //Observer para actualizar la lista y insertar las reservas
    Observer<List<Reserva>> actualizarListReservaObserver=new Observer<List<Reserva>>() {
        @Override
        public void onChanged(List<Reserva> reservas) {
            recyclerViewAdapter.actualizarListaUsuarioReserva(reservas);
        }
    };

}