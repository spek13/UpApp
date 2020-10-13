package com.example.upapp.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.upapp.R;

public class main extends AppCompatActivity {
    private LoginViewModel loginViewModel;
    //inicializar componentes
    private EditText Nombre, Apellido, Telefono, Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //asignar los valores de cada componente de la interfaz a ñas variables
        Nombre = (EditText) findViewById((R.id.txtNombre));
        Apellido = (EditText) findViewById((R.id.txtApellido));
        Telefono = (EditText) findViewById((R.id.txtPhone));
        Email = (EditText) findViewById((R.id.txtEmail));
        final Button enviarButton = findViewById(R.id.Enviar);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);


        enviarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                loginViewModel.login(Nombre.getText().toString(),
                        Apellido.getText().toString());

            }
        });

    }

    //Definimos un metodo para ejecutarlo al presionar el boton
    private void Enviar (View view){
        if (Nombre.getText().toString().isEmpty()) {
            Toast.makeText(this, "nombre vacio", Toast.LENGTH_LONG).show();
        } else {
           if (Apellido.getText().toString().isEmpty()) {
               Toast.makeText(this, "Campo apellido vacio", Toast.LENGTH_LONG).show();
            }else {
               if (Telefono.getText().toString().isEmpty()){
                   Toast.makeText(this, "Campo Telefono vacio", Toast.LENGTH_LONG).show();
               } else {
                   if (Email.getText().toString().isEmpty()){
                       Toast.makeText(this, "Campo Email> vacio", Toast.LENGTH_LONG).show();
                   }
               }
           }


        }
    }

}