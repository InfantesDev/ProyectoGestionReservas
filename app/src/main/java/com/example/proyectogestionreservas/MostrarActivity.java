package com.example.proyectogestionreservas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MostrarActivity extends AppCompatActivity {

    private EditText dateEdtEntrada,dateEdtSalida;
    private Button btnRealizarReserva,btnRealizarLlamada,btnAbrirMapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        dateEdtEntrada=findViewById(R.id.editDateEntrada);
        dateEdtSalida=findViewById(R.id.editDateSalida);
        btnRealizarReserva=findViewById(R.id.btnRealizarReserva);
        btnRealizarLlamada=findViewById(R.id.btnRealizarLlamadasHabi);
        btnAbrirMapa=findViewById(R.id.btnAbrirMapaHabi);
        //Boton Realizar Llamada
        btnRealizarLlamada.setOnClickListener(view -> realizarLlamada());
        //Boton Abrir Mapa
        btnAbrirMapa.setOnClickListener(view -> mostrarLocalizacion());
        //Boton Realizar Reserva
        btnRealizarReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MostrarActivity.this,
                        "Datos Reserva: "+dateEdtEntrada.getText()+" "+dateEdtSalida.getText(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        //DatePicker entrada
        dateEdtEntrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int year=c.get(Calendar.YEAR);
                int mes=c.get(Calendar.MONTH);
                int dia=c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MostrarActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int mesDeYear, int diaDeMes) {
                                dateEdtEntrada.setText(diaDeMes+"-"+(mesDeYear+1)+"-"+year);
                            }
                        },
                year,mes,dia);
                datePickerDialog.show();
            }
        });
        //DatePicker salida
        dateEdtSalida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int year=c.get(Calendar.YEAR);
                int mes=c.get(Calendar.MONTH);
                int dia=c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MostrarActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int mesDeYear, int diaDeMes) {
                                dateEdtSalida.setText(diaDeMes+"-"+(mesDeYear+1)+"-"+year);
                            }
                        },
                        year,mes,dia);
                datePickerDialog.show();
            }
        });

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
            Toast.makeText(MostrarActivity.this, "NO SE PUEDE MOSTRAR EL MAPA", Toast.LENGTH_SHORT).show();
        }
    }
}