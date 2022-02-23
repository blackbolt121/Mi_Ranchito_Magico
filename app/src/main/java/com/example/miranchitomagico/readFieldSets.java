package com.example.miranchitomagico;

import android.widget.EditText;
public class readFieldSets {
    private EditText input;
    private static readFieldSets read = new readFieldSets();
    private readFieldSets(){}
    public static String getReader(EditText text){
        try {
            return read.setInput(text);
        }catch(Exception e){
            e.printStackTrace();
            return "";
        }
    }
    public String setInput(EditText text){
        return text.getText().toString();
    }
    public boolean securePassword(EditText input){
        //Expresion regular para validar una contraseña segura de longitud minima de 8 caracteres,
        //con al menos un caracter de letra mayuscula, minuscula, un numero y un caracter especial
        //"^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$"
        return setInput(input).matches("\"^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$\"");
    }
}
