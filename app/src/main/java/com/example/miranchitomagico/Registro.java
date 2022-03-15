package com.example.miranchitomagico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.example.service.MD5;
import com.example.service.RegisterAccess.RegisterBuilder;

import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;

public class Registro extends functions implements loadComponents{
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
        atras = importButton(R.id.atras);
        MainActivity.backToMainMenu(this,atras);
        registrar = importButton(R.id.register_button);
        registrar.setOnClickListener(x -> {
            try {

                (new RegisterBuilder())
                        .passContext(this)
                        .setNombre(getNombre())
                        .setDireccion(getDireccion())
                        .setCorreo(getCorreoElectronico())
                        .setEstado(getEstado())
                        .setMunicipio(getMunicipio())
                        .setTelefono(getTelefono())
                        .setCodigoPostal(getCodigoPostal())
                        .setContraseña(getPassword())
                        .registrar();
            }catch(Exception e){
                printf(e.getMessage());
            }
        });
    }


    /*
        METODOS DE VALIDACIÓN EN EL FORMULARIO DE REGISTRO
     */
    private String getNombre() throws Exception{
        if(readEditText(nombre).equals("")) //Valida el nombre del usuario
            throw new Exception("Por favor, ingresa tu nombre");
        return readEditText(nombre);
    }
    private String getCorreoElectronico() throws Exception{
        if(!Patterns.EMAIL_ADDRESS.matcher(readEditText(correo)).matches()) //Valida el correo electronico
            throw new Exception("Por favor ingresa un correo electronico válido");
        return readEditText(correo);
    }
    private String getTelefono() throws Exception{
        if(!Patterns.PHONE.matcher(telefono.getText()).matches()) //Valida que un telefono sea valido
            throw new Exception("Por favor ingresa un telefono válido");
        return readEditText(telefono);
    }
    private String getDireccion() throws Exception{
        if((TextUtils.isEmpty(direccion.getText()) && TextUtils.isEmpty(direccion2.getText()))) //Valida la dirección
            throw new Exception("Por favor ingresa tu dirección");
        return (readEditText(direccion) + " " +readEditText(direccion2)).trim();
    }
    private String getCodigoPostal() throws Exception{
        if(!readEditText(cp).matches("\\d{5}")) //Valida que el codigo postal sea valido
            throw new Exception("Por favor digite un código postal válido");
        return readEditText(cp);
    }
    private String getPassword() throws Exception{
        if((pass.getText().toString().length() == 0))
            throw new Exception("Escriba una contraseña");
        if((cpass.getText().toString().length() == 0))
            throw new Exception("Por favor, confirme su contraseña");
        if(!readEditText(cpass).equals(readEditText(pass))) //Valida que la contraseña sea la misma
            throw new Exception("Las contraseñas no coinciden");
        return MD5.getMd5(readEditText(pass));
    }
    private String getEstado() throws Exception{
        if(readSelected(estado).toString().equals(""))
            throw new Exception("No ha seleccionado un estado");
        return readSelected(estado).toString();
    }
    private String getMunicipio() throws Exception{
        if(readSelected(municipio).toString().equals(""))
            throw new Exception("No ha seleccionado un municipio");
        return readSelected(municipio).toString();
    }

    @Override
    public void loadImages() {
    }

    @Override
    public void loadFields() {
        nombre = importEditText(R.id.register_name);
        correo = importEditText(R.id.register_email);
        direccion = importEditText(R.id.register_address1);
        direccion2 = importEditText(R.id.register_addres2);
        cp = importEditText(R.id.register_pc);
        telefono = importEditText(R.id.register_phone);
        pass = importEditText(R.id.register_password);
        cpass = importEditText(R.id.register_cpassword);
        estado = importSpinner(R.id.register_state);
        municipio = importSpinner(R.id.register_town);
        estado.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, Arrays.asList("Sin seleccionar","Queretaro","Michoacan","Jalisco","Ciudad de México")));
        municipio.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, Arrays.asList("Sin seleccionar","Queretaro","Michoacan","Jalisco","Ciudad de México")));

    }

}