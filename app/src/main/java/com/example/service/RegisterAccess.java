package com.example.service;

import android.util.Patterns;
import android.widget.Toast;
import android.util.Patterns.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.function.Function;
import java.util.regex.Pattern;

public class RegisterAccess {
    private String nombre, correo, direccion, estado, municipio, codigo_postal, telefono, contraseña;
    private AppCompatActivity act;

    private RegisterAccess(){
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void setCorreo(String correo) {
        this.correo = correo;
    }

    private void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    private void setEstado(String estado) {
        this.estado = estado;
    }

    private void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    private void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    private void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    private void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    private void setContext(AppCompatActivity context){
        this.act = context;
    }

    /**
     * Metodo para registrar al usuario a través de la API
     * Require que todos los valores de la clase esten asignados
     * @returns void
     */
    private void registrar(){
        //En este método se registra los datos del usuario en la base de datos
        //Toast.makeText(act,String.format("Nombre:%s\nCorreo:%s\nDireccion:%s\nEstado:%s\nMunicipio:%s\nCodigo Postal:%s\nTeléfono:%s\nContraseña:%s",nombre,correo,direccion,estado,municipio,codigo_postal,telefono,contraseña), Toast.LENGTH_SHORT).show();
        try{

            validateForm validateForm = (a, b) -> {return a.matches(b);};
            if(!validateForm.validar(nombre,"^([A-Za-z]+\\s?)+$"))
                throw new Exception("El nombre de su cuenta no es valido");
            if(!Patterns.EMAIL_ADDRESS.matcher(correo).matches())
                throw new Exception("El correo electrónico entregado es inválido");
            if(!Patterns.PHONE.matcher(telefono).matches())
                throw new Exception("El telefono no es valido");
            if(validateForm.validar(estado,"Sin seleccionar"))
                throw new Exception("No ha seleccionado un estado");
            if(validateForm.validar(municipio,"Sin seleccionar"))
                throw new Exception("No ha seleccionado un municipio");
            if(!validateForm.validar(direccion,"^(\\w+\\s?)+$"))
                throw new Exception("Digite una dirección valida");
            if(!validateForm.validar(contraseña,"^w+$"))
                throw new Exception("Usted no ha ingresado una contraseña");
            if(!validateForm.validar(codigo_postal,"\\d{5}"))
                throw new Exception("Usted no ha ingresado un codigo postal válido");
            HashMap body = new HashMap(){
                {
                    put("name",nombre);
                    put("email",correo);
                    put("phone", telefono);
                    put("estate", estado);
                    put("municipio",municipio);
                    put("direccion",direccion);
                    put("password",contraseña);
                    put("postal",codigo_postal);
                }
            };
            String request = (new Requester(act)).requestRegister(body);
        }catch(Exception e){
            Toast.makeText(act,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
    @FunctionalInterface
    public interface validateForm{
        boolean validar(String cadena, String patron);
    }
    public static class RegisterBuilder{

        RegisterAccess build;

        public RegisterBuilder(){
            build = new RegisterAccess();
        }

        public RegisterBuilder setNombre(String nombre){
            build.setNombre(nombre);
            return this;
        }

        public RegisterBuilder passContext(AppCompatActivity act){
            build.setContext(act);
            return this;
        }

        public RegisterBuilder setCorreo(String correo){
            build.setCorreo(correo);
            return this;
        }

        public RegisterBuilder setDireccion(String direccion){
            build.setDireccion(direccion);
            return this;
        }

        public RegisterBuilder setEstado(String estado){
            build.setEstado(estado);
            return this;
        }

        public RegisterBuilder setMunicipio(String municipio){
            build.setMunicipio(municipio);
            return this;
        }

        public RegisterBuilder setCodigoPostal(String codigoPostal){
            build.setCodigo_postal(codigoPostal);
            return this;
        }

        public RegisterBuilder setTelefono(String telefono){
            build.setTelefono(telefono);
            return this;
        }

        public RegisterBuilder setContraseña(String contraseña){
            build.setContraseña(contraseña);
            return this;
        }

        public void registrar(){
            build.registrar();
        }
    }
}
