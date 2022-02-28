package com.example.miranchitomagico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.example.validaciondedatos.MD5;
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

            try {

                if(obtenerTexto.editStr(nombre).equals("")) //Valida el nombre del usuario
                    throw new Exception("Por favor, ingresa tu nombre");
                if(!Patterns.EMAIL_ADDRESS.matcher(correo.getText()).matches()) //Valida el correo electronico
                    throw new Exception("Por favor ingresa un correo electronico válido");
                if((TextUtils.isEmpty(direccion.getText()) && TextUtils.isEmpty(direccion2.getText()))) //Valida la dirección
                    throw new Exception("Por favor ingresa tu dirección");
                if(!Patterns.PHONE.matcher(telefono.getText()).matches()) //Valida que un telefono sea valido
                    throw new Exception("Por favor ingresa un telefono válido");
                if(!obtenerTexto.editStr(cp).matches("\\d{5}")) //Valida que el codigo postal sea valido
                    throw new Exception("Por favor digite un código postal válido");
                if((pass.getText().toString().length() == 0) || (cpass.getText().toString().length() == 0))
                    throw new Exception("La contraseña esta vacia");
                if(!obtenerTexto.editStr(cpass).equals(obtenerTexto.editStr(pass))) //Valida que la contraseña sea la misma
                    throw new Exception("Las contraseñas no coinciden");
                (new RegisterBuilder())
                        .passContext(this)
                        .setNombre(obtenerTexto.editStr(nombre))
                        .setDireccion(obtenerTexto.editStr(direccion) + " " + obtenerTexto.editStr(direccion2))
                        .setCorreo(obtenerTexto.editStr(correo))
                        .setEstado(estado.getSelectedItem().toString())
                        .setMunicipio(municipio.getSelectedItem().toString())
                        .setTelefono(obtenerTexto.editStr(telefono))
                        .setCodigoPostal(obtenerTexto.editStr(cp))
                        .setContraseña(MD5.getMd5(obtenerTexto.editStr(pass)))
                        .registrar();
            }catch(Exception e){
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void loadImages() {
    }

    @Override
    public void loadFields() {
        nombre = (EditText) findViewById(R.id.register_name);
        correo = (EditText) findViewById(R.id.register_email);
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