package com.example.miranchitomagico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.service.LoginAccess;
import com.example.service.MD5;

public class Login extends functions implements loadComponents{

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
                //Valida con el servidor
                //Recibe una sesión
                String token = LoginAccess
                        .LoginBuilder
                        .makeLogin()
                        .setContext(this)
                        .setUser(readFieldSets.getReader(user))
                        .setPassword(readFieldSets.getReader(password))
                        .login();
                if(!token.equals("")){
                    this.printf("Se ha iniciado sesión correctamente");
                }
            }catch(Exception e){
                pr(e.getMessage());
            }
        });
    }

    @Override
    public void loadImages() {
        login_icon = importImgVw(R.id.login_image);
        login_icon.setImageResource(R.drawable.login);
    }

    @Override
    public void loadFields() {
        user = importEditText(R.id.login_user_field);
        password = importEditText(R.id.login_pass_field);
    }
    public void pr(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}