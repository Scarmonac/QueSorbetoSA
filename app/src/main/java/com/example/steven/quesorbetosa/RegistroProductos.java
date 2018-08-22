package com.example.steven.quesorbetosa;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.steven.quesorbetosa.Utilidades.Utilidades;

public class RegistroProductos extends AppCompatActivity {

  Button BTN_Registrar_Productos;
    EditText campoNombreProducto,campoPrecioVenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_productos);

        campoNombreProducto= (EditText) findViewById(R.id.TXT_Nombre_Producto);
        campoPrecioVenta= (EditText) findViewById(R.id.TXT_Precio_Venta);

        BTN_Registrar_Productos=(Button) findViewById(R.id.BTN_Registrar_Productos);
        BTN_Registrar_Productos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                registrarProductos();
                limpiar();
            }
        });
    }
    private void registrarProductos() {
        try {

            ConexionSqliteHelper conn=new ConexionSqliteHelper(this,"BDQUESORBETO",null,5);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();

        values.put(Utilidades.CAMPO_NOMBRE_PRODUCTO,campoNombreProducto.getText().toString());
        values.put(Utilidades.CAMPO_PRECIO_VENTA,campoPrecioVenta.getText().toString());

        long idResultante=db.insert(Utilidades.TABLA_PRODUCTO,Utilidades.CAMPO_NOMBRE_PRODUCTO,values);

        Toast.makeText(getApplicationContext(),"Id Producto: "+idResultante,Toast.LENGTH_SHORT).show();

        db.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Error: " ,Toast.LENGTH_LONG).show();
            limpiar();
        }
    }
    private void limpiar() {
        campoNombreProducto.setText("");
        campoPrecioVenta.setText("");
    }
}
