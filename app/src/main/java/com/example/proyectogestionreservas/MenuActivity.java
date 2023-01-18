package com.example.proyectogestionreservas;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.proyectogestionreservas.databinding.ActivityMainBinding;
import com.example.proyectogestionreservas.databinding.ActivityMenuBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * Activity Para Navegar Entre Fragments
 */
public class MenuActivity extends AppCompatActivity {
    //Datos
    ActivityMenuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        binding=ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        String message = intent.getStringExtra("user");
        Bundle bundle = new Bundle();
        bundle.putString("usuario",message);
        replaceFragment(new ExplorarFragment());
        //Menu Bottom Nav
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.search:
                    replaceFragment(new ExplorarFragment());
                    break;
                case R.id.task:
                    replaceFragment(new ReservasFragment());
                    break;
                case R.id.profile:
                    PerfilFragment pFragment = new PerfilFragment();
                    pFragment.setArguments(bundle);
                    replaceFragment(pFragment);
                    break;
            }
            return true;
        });
    }
    //Remplazar fragment
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flFragment,fragment);
        fragmentTransaction.commit();
    }
}
