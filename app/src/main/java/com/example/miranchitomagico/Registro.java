package com.example.miranchitomagico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import com.example.validaciondedatos.RegisterAccess.RegisterBuilder;
import com.example.validaciondedatos.obtenerTexto;
import com.example.validaciondedatos.RegisterAccess;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Registro extends AppCompatActivity implements loadComponents{
    private Button atras, registrar;
    private EditText nombre, correo, direccion, direccion2, cp, telefono, pass, cpass;
    private Spinner estado, municipio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        loadButtons();
        loadFields();


    }


    @Override
    public void loadLabels() {

    }

    @Override
    public void loadButtons() {
        atras = (Button) findViewById(R.id.atras);
        MainActivity.backToMainMenu(this,atras);
        registrar = (Button) findViewById(R.id.register_button);

        registrar.setOnClickListener(x -> {
            Toast.makeText(this, "Registrando, espere un momento",Toast.LENGTH_SHORT).show();
            Toast.makeText(this,obtenerTexto.editStr(nombre),Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void loadImages() {
    }

    @Override
    public void loadFields() {
        nombre = (EditText) findViewById(R.id.register_name);
        correo = (EditText) findViewById(R.id.register_password);
        direccion = (EditText) findViewById(R.id.register_address1);
        direccion2 = (EditText) findViewById(R.id.register_addres2);
        cp = (EditText) findViewById(R.id.register_pc);
        telefono = (EditText) findViewById(R.id.register_phone);
        pass = (EditText) findViewById(R.id.register_password);
        cpass = (EditText) findViewById(R.id.register_cpassword);
        estado = (Spinner) findViewById(R.id.register_state);
        municipio = (Spinner) findViewById(R.id.register_town);
        estado.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, Arrays.asList("Sin seleccionar","Queretaro","Michoacan","Jalisco","Ciudad de México")));
        municipio.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, Arrays.asList("Sin seleccionar","Queretaro","Michoacan","Jalisco","Ciudad de México")));

    }

}