package com.example.miranchitomagico;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class functions extends AppCompatActivity {
    public functions(){
        super();
    }
    public void printf(String mensaje){
        Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
    }
    public String readEditText(EditText text){
        return text.getText().toString();
    }

    public Object readSelected(Spinner spinner){
        return spinner.getSelectedItem();
    }

    public EditText importEditText(int id){
        return (EditText) findViewById(id);
    }
    public Button importButton(int id){
        return (Button) findViewById(id);
    }

    public Spinner importSpinner(int id){
        return (Spinner) findViewById(id);
    }

    public ImageView importImgVw(int id){
        return (ImageView) findViewById(id);
    }
}
