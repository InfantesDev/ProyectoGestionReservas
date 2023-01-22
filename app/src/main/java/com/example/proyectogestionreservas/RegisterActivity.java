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
 * Activity Register Registra Usuarios
 */
public class RegisterActivity extends AppCompatActivity {
    //Datos
    EditText user, pass, passOtra, dni, apellido, telefono;
    Button btnRegistro;
    TextView btnRegistroToLogin;
    ActivityRegisterBinding binding;
    UsuarioViewModel usuarioVM;
    //Valicadion para contraseña
    public boolean validacion(){
        boolean valid = true;
        String userName = user.getText().toString();
        String userPass = pass.getText().toString();
        String userPassOtra = passOtra.getText().toString();
        String userDni=dni.getText().toString();
        String userApellido=apellido.getText().toString();
        String userTelefono=telefono.getText().toString();
        if (userName.isEmpty()&&userDni.isEmpty()&&userApellido.isEmpty()&&userTelefono.isEmpty()){
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
        //Inicializar datos
        user=findViewById(R.id.editUserRegister);
        pass=findViewById(R.id.editPasswordRegister);
        passOtra=findViewById(R.id.editPasswordAgainRegister);
        dni=findViewById(R.id.editDniRegister);
        apellido=findViewById(R.id.editApellidoRegister);
        telefono=findViewById(R.id.editTelefonoRegister);
        btnRegistro=findViewById(R.id.btnRegister);
        btnRegistroToLogin=findViewById(R.id.btnRegistroToLogin);
        //Nos traemos los datos con el viewModel
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
    public void guardarUsuario(){
        if (validacion()){
            String nombreUsuario=user.getText().toString();
            String passwordUsuario=pass.getText().toString();
            String dniUsuario=dni.getText().toString();
            String apellidoUsuario=apellido.getText().toString();
            String telefonoUsuario=telefono.getText().toString();
            usuarioVM.guardarUsuario(new Usuario(nombreUsuario, passwordUsuario,dniUsuario,apellidoUsuario,telefonoUsuario));
            Toast.makeText(this, "Usuario Registrado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Usuario No Registrado", Toast.LENGTH_LONG).show();
        }
    }
}
