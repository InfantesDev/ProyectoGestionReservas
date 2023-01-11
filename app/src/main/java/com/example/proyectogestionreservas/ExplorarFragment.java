package com.example.proyectogestionreservas;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

/**
 * Fragment Explorar Recycler View vertical
 * Se hace array con datos de las parcelas y se pasa al adapter
 */
public class ExplorarFragment extends Fragment {

    //RecyclerView añadido
    private RecyclerView recyclerView;

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
        recyclerView.setAdapter(new RandomNumListAdapter(parcelas));
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
}