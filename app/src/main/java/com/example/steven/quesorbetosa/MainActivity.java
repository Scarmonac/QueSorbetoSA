package com.example.steven.quesorbetosa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button BTN_Login;
    EditText TXT_Email;
    EditText TXT_Contrasena;


    @Override
    public void onClick(View v) {

        if (validarLogin(TXT_Email.getText().toString(),
                TXT_Contrasena.getText().toString())){

            Intent elIntent = new Intent(getApplicationContext(), MenuPrincipalActivity.class);
            startActivity(elIntent);

        }else
            Toast.makeText(getApplicationContext(),"Usuario y/o contraseña no válido",Toast.LENGTH_LONG).show();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BTN_Login=(Button)findViewById(R.id.BTN_Login);
        TXT_Email=(EditText)findViewById(R.id.TXT_Email);
        TXT_Contrasena=(EditText)findViewById(R.id.TXT_Contrasena);

        BTN_Login.setOnClickListener(this);
    }

    private boolean validarLogin(String usuario, String password){

        //todo validar que existe el usuario y contraseña

        return true;
    }

}
