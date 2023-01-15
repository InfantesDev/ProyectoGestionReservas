package com.example.proyectogestionreservas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectogestionreservas.data.AppDataBase;
import com.example.proyectogestionreservas.data.dao.UsuarioDao;
import com.example.proyectogestionreservas.databinding.ActivityMainBinding;

/**
 * Login Activity
 * De esta actividad podemos pasar a registro y a menu activity donde estan los fragments
 */
public class MainActivity extends AppCompatActivity {
    EditText user, pass;
    Button btnLogin;
    TextView btnDescLogin;
    ActivityMainBinding binding;
    AppDataBase myDb;
    UsuarioDao usuarioDao;

    public boolean validacion(){
        boolean valid = true;
        String userName = user.getText().toString();
        String userPass = pass.getText().toString();
        Intent i = getIntent();
        if (userName.isEmpty()){
            valid=false;
        }
        if (userPass.isEmpty() || userPass.length()<4 || userPass.length()>10){
            valid=false;
        } else if(!userPass.equals(i.getStringExtra("pass"))
                || !userName.equals(i.getStringExtra("user"))){
            valid=false;
            }
        return valid;
    }

    //Mostrar
    public void mostrarMenuActivity(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        finish();
    }

    //Mostrar Registrer
    public void mostrarRegisterActivity(){
        Intent intentRegister = new Intent(this, RegisterActivity.class);
        startActivity(intentRegister);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot()); //R.layout.activity_main
        myDb= Room.databaseBuilder(this, AppDataBase.class, "hoteldb")
                .allowMainThreadQueries().fallbackToDestructiveMigration().build();
        usuarioDao= myDb.usuarioDao();

        btnLogin=findViewById(R.id.btnLogin);
        btnDescLogin=findViewById(R.id.btnDescLogin);

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreUsuario=binding.editUser.getText().toString();
                String passUsuario=binding.editPassword.getText().toString();
                if (usuarioDao.login(nombreUsuario,passUsuario)){
                    startActivity(new Intent(MainActivity.this, MenuActivity.class));
                } else {
                    Toast.makeText(MainActivity.this, "Nombre Usuario o Contraseña Fallida", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.btnDescLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
    }
}