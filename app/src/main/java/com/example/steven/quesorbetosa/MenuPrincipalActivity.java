package com.example.steven.quesorbetosa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MenuPrincipalActivity extends AppCompatActivity implements View.OnClickListener{

    Button BTN_Clientes;
    Button BTN_Productos;
     Button BTN_Facturacion;

    @Override
    public void onClick(View v){


        switch (v.getId()){
            case R.id.BTN_Clientes:
                Intent elIntent= new Intent(getApplicationContext(),ClienteActivity.class);
                startActivity(elIntent);
                break;
            case R.id.BTN_Productos:
                Intent elIntent2= new Intent(getApplicationContext(),ProductoActivity.class);
                startActivity(elIntent2);
                break;
            case R.id.BTN_Facturacion:
                Intent elIntent3= new Intent(getApplicationContext(),FacturacionActivity.class);
                startActivity(elIntent3);
                break;
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        inicializaPantalla();
        BTN_Clientes.setOnClickListener(this);
        BTN_Productos.setOnClickListener(this);
        BTN_Facturacion.setOnClickListener(this);
    }

    public void inicializaPantalla(){

        BTN_Clientes=(Button) findViewById(R.id.BTN_Clientes);
        BTN_Productos=(Button) findViewById(R.id.BTN_Productos);
        BTN_Facturacion=(Button) findViewById(R.id.BTN_Facturacion);




    }
}