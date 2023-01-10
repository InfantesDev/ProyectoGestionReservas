package com.example.proyectogestionreservas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Login Activit
 * De esta actividad podemos pasar a registro y a menu activity donde estan los fragments
 */
public class MainActivity extends AppCompatActivity {
    EditText user, pass;
    Button btnLogin, btnDescLogin;

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
        setContentView(R.layout.activity_main);

        user=findViewById(R.id.editUser);
        pass=findViewById(R.id.editPassword);
        btnLogin=findViewById(R.id.btnLogin);
        btnDescLogin=findViewById(R.id.btnDescLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validacion()){
                    //Pasamos a la actividad menu
                    mostrarMenuActivity();
                } else {
                    //TODO saltar error
                    //Si error
                    mostrarMenuActivity();
                    Toast.makeText(getApplicationContext(), "Error contraseña!!", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnDescLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarRegisterActivity();
            }
        });
    }
}