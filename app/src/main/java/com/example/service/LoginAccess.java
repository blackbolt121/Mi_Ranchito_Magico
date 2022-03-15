package com.example.service;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;

public class LoginAccess {
    private String password, user;
    private LoginAccess(){}
    private String login(Context context) throws Exception{
        if(user.length() == 0)
            throw new Exception("No user captured");
        if(password.length()==0)
            throw new Exception("No password captured");
        Requester requester = new Requester(context);
        return ""; //Aquí hacemos la petición a nuestro servidor para validar las credenciales
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private void setUser(String user) {
        this.user = user;
    }

    private boolean disconnect(String token){
        return true; //Confirma si el token ha sido removido con exito, esto lo conseguimos a través de una petición a nuestro servidor
    }

    //We are using singleton pattern
    public static class LoginBuilder{

        private LoginAccess log;
        private static LoginBuilder login = new LoginBuilder();
        private Context context;
        private LoginBuilder(){
            log = new LoginAccess();
        }

        public static LoginBuilder makeLogin(){
            return login;
        }

        public LoginBuilder setUser(String user){
            log.setUser(user);
            return this;
        }

        public LoginBuilder setPassword(String password){
            log.setPassword(password);
            return this;
        }
        public LoginBuilder setContext(Context activity){
            context = activity;
            return this;
        }
        //Obtenemos el token de sesión
        public String login() throws Exception{
            return log.login(context);
        }

    }

}
