package com.example.proyectogestionreservas;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectogestionreservas.data.AppDataBase;
import com.example.proyectogestionreservas.data.dao.UsuarioDao;
import com.example.proyectogestionreservas.data.entities.Usuario;
import com.example.proyectogestionreservas.databinding.ActivityRegisterBinding;
import com.example.proyectogestionreservas.viewmodel.UsuarioViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

/**
 * Activity Register
 *
 */
public class RegisterActivity extends AppCompatActivity {
    EditText user, pass, passOtra;
    Button btnRegistro;
    TextView btnRegistroToLogin;
    ActivityRegisterBinding binding;
    AppDataBase myDataBase;
    UsuarioDao usuarioDao;
    UsuarioViewModel usuarioVM;
    public static boolean isPermitido=false;

    //TODO Hacer validacion contraseña segura
    public boolean validacion(){
        boolean valid = true;
        String userName = user.getText().toString();
        String userPass = pass.getText().toString();
        String userPassOtra = passOtra.getText().toString();
        if (userName.isEmpty()){
            valid=false;
        }
        if (userPass.isEmpty() || userPass.length()<4 || userPass.length()>10){
            valid=false;
        } else if(!userPass.equals(userPassOtra)){
            valid=false;
        }
        return valid;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot()); //R.layout.activity_register


        user=findViewById(R.id.editUserRegister);
        pass=findViewById(R.id.editPasswordRegister);
        passOtra=findViewById(R.id.editPasswordAgainRegister);
        btnRegistro=findViewById(R.id.btnRegister);
        btnRegistroToLogin=findViewById(R.id.btnRegistroToLogin);

        //Forma de guardar mas de un usuario
        // VIEW MODEL PARA OBSERVAR LOS DATOS
        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        usuarioVM = new ViewModelProvider(this, (ViewModelProvider.Factory) factory).get(UsuarioViewModel.class);
        //Guarda el usuario
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarUsuario();
            }
        });
        btnRegistroToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            }
        });
    }
    //Forma de guardar mas de un usuario
    //Guardar Usuario
    //TODO Hacer validacion
    public void guardarUsuario(){
        String nombreUsuario=user.getText().toString();
        String passwordUsuario=pass.getText().toString();
        usuarioVM.guardarUsuario(new Usuario(nombreUsuario, passwordUsuario));
        Toast.makeText(this, "Usuario Registrado", Toast.LENGTH_SHORT).show();
    }
}
