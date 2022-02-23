package com.example.miranchitomagico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements loadComponents{

    private Button atras, login;
    private EditText user, password;
    private ImageView login_icon;
    private TextView user_label, user_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loadButtons();
        loadFields();
        loadImages();
    }


    @Override
    public void loadLabels() {}

    @Override
    public void loadButtons() {
        atras = (Button) findViewById(R.id.atras);
        MainActivity.backToMainMenu(this,atras);
        login = (Button) findViewById(R.id.login_button);
        login.setOnClickListener(x -> {
            //String output = readFieldSets.getReader(user) + " " + readFieldSets.getReader(password);
            //Toast.makeText(this, output,Toast.LENGTH_SHORT).show();
            try {
                if (readFieldSets.getReader(user).length() == 0) {
                    throw new Exception("Digite un usuario porfavor");
                }
                if (readFieldSets.getReader(password).length() == 0) {
                    throw new Exception("Porfavor digite su password");
                }
                //Si no se lanzo una excepción, entonces se procede a iniciar sesion
                pr(readFieldSets.getReader(user)+" " + readFieldSets.getReader(password));
            }catch(Exception e){
                pr(e.getMessage());
            }
        });
    }

    @Override
    public void loadImages() {
        login_icon = (ImageView) findViewById(R.id.login_image);
        login_icon.setImageResource(R.drawable.login);
    }

    @Override
    public void loadFields() {
        user = (EditText) findViewById(R.id.login_user_field);
        password = (EditText) findViewById(R.id.login_pass_field);
    }
    public void pr(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}