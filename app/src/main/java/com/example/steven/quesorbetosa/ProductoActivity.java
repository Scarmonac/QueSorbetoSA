package com.example.steven.quesorbetosa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProductoActivity extends AppCompatActivity implements View.OnClickListener{

    Button BTN_Registrar_Producto;
    Button BTN_Consulta_Productos;


    @Override
    public void onClick(View v) {

        Intent elIntent=null;
        switch (v.getId()) {
            case R.id.BTN_Registrar_Producto:
                elIntent = new Intent(getApplicationContext(), RegistroProductos.class);

                break;
            case R.id.BTN_Consulta_Productos:
                elIntent = new Intent(getApplicationContext(), ConsultarProductos.class);

                break;

        }
        startActivity(elIntent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);


        inicializaPantalla();
    }

    public void inicializaPantalla() {

        BTN_Registrar_Producto=(Button) findViewById(R.id.BTN_Registrar_Producto);
        BTN_Consulta_Productos=(Button) findViewById(R.id.BTN_Consulta_Productos);



        BTN_Registrar_Producto.setOnClickListener(this);
        BTN_Consulta_Productos.setOnClickListener(this);


    }

}

