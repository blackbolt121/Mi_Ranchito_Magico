package com.example.validaciondedatos;

public class RegisterAccess {
    public String nombre, correo, direccion, estado, municipio, codigo_postal, telefono, contraseña;
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

    private void registrar(){
        //En este método se registra los datos del usuario en la base de datos
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

        }
    }
}
