package com.example.miranchitomagico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class PlaneaTuViaje extends AppCompatActivity {

    private Button atras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planea_tu_viaje);
        atras = (Button) findViewById(R.id.atras);
        MainActivity.backToMainMenu(this,atras);
    }
}