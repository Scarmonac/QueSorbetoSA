package com.example.steven.quesorbetosa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClienteActivity extends AppCompatActivity implements View.OnClickListener{
    Button BTN_Registrar_Cliente;
    Button BTN_Consultar_Clientes;


    @Override
    public void onClick(View v) {

        Intent elIntent=null;
        switch (v.getId()) {
            case R.id.BTN_Registrar_Cliente:
                 elIntent = new Intent(getApplicationContext(), RegistroClientes.class);

                break;
            case R.id.BTN_Consultar_Clientes:
                 elIntent = new Intent(getApplicationContext(), ConsultarClientes.class);

                break;
        }
        startActivity(elIntent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);


        inicializaPantalla();


    }

    public void inicializaPantalla() {

        BTN_Registrar_Cliente=(Button) findViewById(R.id.BTN_Registrar_Cliente);
        BTN_Consultar_Clientes=(Button) findViewById(R.id.BTN_Consultar_Clientes);



        BTN_Registrar_Cliente.setOnClickListener(this);
        BTN_Consultar_Clientes.setOnClickListener(this);


    }

}

