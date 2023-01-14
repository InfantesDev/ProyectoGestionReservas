package com.example.proyectogestionreservas;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectogestionreservas.viewmodel.HabitacionViewModel;

import java.util.ArrayList;

/**
 * Fragment Explorar Recycler View vertical
 * Se hace array con datos de las parcelas y se pasa al adapter
 */
public class ExplorarFragment extends Fragment {

    //RecyclerView añadido
    private RecyclerView recyclerView;
    //Mostrar datos
    HabitacionViewModel hVM;

    public ExplorarFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explorar, container, false);

        //Crear Arraylist
        ArrayList<Parcela> parcelas = datos_parcela();
        //Crear RecyclerView
        recyclerView=view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new RandomListAdapter(parcelas));
        return view;
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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //view model sin factory
        //hVM=new ViewModelProvider()
        hVM=new ViewModelProvider(this).get(HabitacionViewModel.class);
    }
}