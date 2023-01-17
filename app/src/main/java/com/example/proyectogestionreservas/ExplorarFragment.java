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
 * Fragment Explorar Recycler View vertical
 * Se hace array con datos de las parcelas y se pasa al adapter
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

    public ExplorarFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //view model sin factory
        //hVM=new ViewModelProvider()
        //hVM=new ViewModelProvider(this).get(HabitacionViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explorar, container, false);
        context=this;
        //Crear RecyclerView
        recyclerView=view.findViewById(R.id.recyclerView);
        recyclerViewAdapter=new RandomListAdapter(new RandomListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Habitacion habitacion) {
                Intent intent = new Intent(getActivity(), MostrarActivity.class);
                startActivity(intent);
                Toast.makeText(getContext(), "Item Clicked", Toast.LENGTH_LONG).show();
            }
        });
        recyclerView.setAdapter(recyclerViewAdapter);
        hVM=new ViewModelProvider(context).get(HabitacionViewModel.class);
        hVM.obtenerHabitaciones().observe(getViewLifecycleOwner(),actualizarListHabitacionObserver);
        return view;
    }

    Observer<List<Habitacion>> actualizarListHabitacionObserver=new Observer<List<Habitacion>>() {
        @Override
        public void onChanged(List<Habitacion> habitacions) {
            recyclerViewAdapter.actualizarListaUsuario(habitacions);
        }
    };

    public void goToAttract(View v) {
        Intent intent = new Intent(getActivity(), MostrarActivity.class);
        startActivity(intent);
    }

    public ArrayList<Parcela> datos_parcela(){
        ArrayList<Parcela> parcelas = new ArrayList<>();
        parcelas.add(new Parcela("Parela 1", R.drawable.ic_search_foreground));
        parcelas.add(new Parcela("Parela 2", R.drawable.ic_search_foreground));
        parcelas.add(new Parcela("Parela 3", R.drawable.ic_launcher_foreground));
        parcelas.add(new Parcela("Parela 4", R.drawable.ic_profile_foreground));
        parcelas.add(new Parcela("Parela 5", R.drawable.ic_task_foreground));
        parcelas.add(new Parcela("Parela 6", R.drawable.ic_task_foreground));
        return parcelas;
    }
}