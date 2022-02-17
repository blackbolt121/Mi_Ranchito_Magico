package com.example.miranchitomagico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button listaPueblosMagicos, planeaTuViaje, mapa, comentarios, ajustes, registro, login;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadComponents();
        buttonEvents();

    }
    //Metodo para cargar los componentes del layout
    private void loadComponents(){
        this.registro = (Button) findViewById(R.id.registrar);
        this.login = (Button) findViewById(R.id.login);
        this.listaPueblosMagicos = (Button) findViewById(R.id.lista);
        this.planeaTuViaje = (Button) findViewById(R.id.planea);
        this.comentarios = (Button) findViewById(R.id.comentarios);
        this.mapa = (Button) findViewById(R.id.mapa);
        this.ajustes = (Button) findViewById(R.id.ajustes);
        img = (ImageView) findViewById(R.id.ranchito);
        img.setImageResource(R.drawable.mi_ranchito_magico);
    }

    //Metodo para settear los eventos de los botones
    private void buttonEvents(){

        //Se manda al activity de registro
        registro.setOnClickListener(x -> startActivity(new Intent(this,Registro.class)));

        //Se manda al activity de inicio de sesión
        login.setOnClickListener(x -> startActivity(new Intent(this, Login.class)));

        //Se inicia el activity desplegando la lista de pueblos mágicos
        listaPueblosMagicos.setOnClickListener(x -> startActivity(new Intent(this,ListaDePueblosMagicos.class)));

        //Se inicia activity para planear tu viaje
        planeaTuViaje.setOnClickListener(x -> startActivity(new Intent(this, PlaneaTuViaje.class)));

        //Te lleva al menu de comentarios
        comentarios.setOnClickListener(x -> startActivity(new Intent(this, Comentarios.class)));

        //Te muestra el mapa ??
        mapa.setOnClickListener(x -> startActivity(new Intent(this, Comentarios.class)));

        //Muestra los ajustes de la aplicación
        ajustes.setOnClickListener(x -> startActivity(new Intent(this, Ajustes.class)));
    }

    public static void backToMainMenu(AppCompatActivity act, Button button){
        button.setOnClickListener(x -> act.startActivity(new Intent(act,MainActivity.class)));
    }


}