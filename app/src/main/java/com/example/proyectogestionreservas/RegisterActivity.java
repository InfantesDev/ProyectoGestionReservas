package com.example.proyectogestionreservas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText user, pass, passOtra;
    Button btnRegistro, btnRegistroToLogin;

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

    //Volvel Sin Datos Login
    public void mostrarActivityLoginSinDatos(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //Volver Con Datos Login MainActivity
    public void mostrarActivityLoginConDatos(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("user",user.getText().toString());
        intent.putExtra("pass",pass.getText().toString());
        intent.putExtra("passotra", passOtra.getText().toString());
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        user=findViewById(R.id.editUserRegister);
        pass=findViewById(R.id.editPasswordRegister);
        passOtra=findViewById(R.id.editPasswordAgainRegister);
        btnRegistro=findViewById(R.id.btnRegister);
        btnRegistroToLogin=findViewById(R.id.btnRegistroToLogin);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validacion()){
                    //Pasamos a una nueva vista
                    mostrarActivityLoginConDatos();
                    Toast.makeText(getApplicationContext(), "Perfecto", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    //salimos break
                    Toast.makeText(getApplicationContext(), "Error contraseña!!", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnRegistroToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarActivityLoginSinDatos();
            }
        });
    }
}
