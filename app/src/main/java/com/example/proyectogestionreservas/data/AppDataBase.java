package com.example.proyectogestionreservas.data;

import android.content.Context;

import com.example.proyectogestionreservas.data.dao.HabitacionDao;
import com.example.proyectogestionreservas.data.dao.UsuarioDao;
import com.example.proyectogestionreservas.data.entities.Habitacion;
import com.example.proyectogestionreservas.data.entities.Usuario;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Habitacion.class, Usuario.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract HabitacionDao habitacionDao();
    public abstract UsuarioDao usuarioDao();

    private static final String DATABASE_NAME = "hoteldb";

    private static AppDataBase INSTANCE;

    private static final int THREADS = 4;
    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(THREADS);

    public static AppDataBase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(), AppDataBase.class,
                                    DATABASE_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
