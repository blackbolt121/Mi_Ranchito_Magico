package com.example.miranchitomagico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

public class ListaDePueblosMagicos extends AppCompatActivity {
    Button atras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_pueblos_magicos);
        atras = (Button)findViewById(R.id.atras);
        MainActivity.backToMainMenu(this,atras);
    }
}