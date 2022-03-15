package com.example.miranchitomagico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends functions {

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
        this.registro = importButton(R.id.registrar);
        this.login = importButton(R.id.login);
        this.listaPueblosMagicos = importButton(R.id.lista);
        this.planeaTuViaje = importButton(R.id.planea);
        this.comentarios = importButton(R.id.comentarios);
        this.mapa = importButton(R.id.mapa);
        this.ajustes = importButton(R.id.ajustes);
        img = importImgVw(R.id.ranchito);
        img.setImageResource(R.drawable.mi_ranchito_magico);
    }

    //Metodo para settear los eventos de los botones
    private void buttonEvents(){

        //Se manda al activity de registro
        registro.setOnClickListener(x ->{ startActivity(new Intent(this,Registro.class)); finish(); });

        //Se manda al activity de inicio de sesión
        login.setOnClickListener(x -> {startActivity(new Intent(this, Login.class)); finish();});

        //Se inicia el activity desplegando la lista de pueblos mágicos
        listaPueblosMagicos.setOnClickListener(x -> {
            startActivity(new Intent(this,ListaDePueblosMagicos.class));
            this.finish();
        });

        //Se inicia activity para planear tu viaje
        planeaTuViaje.setOnClickListener(x -> {startActivity(new Intent(this, PlaneaTuViaje.class)); finish();});

        //Te lleva al menu de comentarios
        comentarios.setOnClickListener(x -> {startActivity(new Intent(this, Comentarios.class)); finish();});

        //Te muestra el mapa ??
        mapa.setOnClickListener(x -> {startActivity(new Intent(this, Comentarios.class)); finish();});

        //Muestra los ajustes de la aplicación
        ajustes.setOnClickListener(x -> {startActivity(new Intent(this, Ajustes.class)); finish();});
    }

    public static void backToMainMenu(AppCompatActivity act, Button button){
        button.setOnClickListener(x -> {
            act.startActivity(new Intent(act,MainActivity.class));
            act.finish();
        });
    }


}