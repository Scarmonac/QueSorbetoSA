package com.example.steven.quesorbetosa;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.steven.quesorbetosa.Utilidades.Utilidades;

public class ConsultarProductos extends AppCompatActivity {

    Button BTN_Consultar_Productos,BTN_Actualizar_Clientes_Productos,BTN_Eliminar_Productos;
    EditText campoId,campoNombre,campoPrecioVenta;

    ConexionSqliteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_productos);
        conn=new ConexionSqliteHelper(getApplicationContext(),"BDQUESORBETO",null,5);

        campoId= (EditText) findViewById(R.id.TXTidProducto);
        campoNombre= (EditText) findViewById(R.id.TXTnombreProducto);
        campoPrecioVenta= (EditText) findViewById(R.id.TXTprecioVenta);

        BTN_Consultar_Productos =(Button) findViewById(R.id.BTN_Consultar_Productos);
        BTN_Consultar_Productos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                consultarSql();
            }
        });

        /*******************************NUEVO CODIGO ACTUALIZAR USURIO*******************************************/
        BTN_Actualizar_Clientes_Productos =(Button) findViewById(R.id.BTN_Actualizar_Clientes_Productos);
        BTN_Actualizar_Clientes_Productos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                actualizarProducto();
            }
        });

        /*******************************NUEVO CODIGO ACTUALIZAR PRODUCTO*******************************************/
        BTN_Eliminar_Productos =(Button) findViewById(R.id.BTN_Eliminar_Productos);
        BTN_Eliminar_Productos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                eliminarProducto();
            }
        });

    }

    private void eliminarProducto() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campoId.getText().toString()};

        db.delete(Utilidades.TABLA_PRODUCTO,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Se ha eliminado el producto",Toast.LENGTH_LONG).show();
        campoId.setText("");
        limpiar();
        db.close();
    }

    private void actualizarProducto() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campoId.getText().toString()};
        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE_PRODUCTO,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_PRECIO_VENTA,campoPrecioVenta.getText().toString());

        db.update(Utilidades.TABLA_PRODUCTO,values,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se actualizó el Producto",Toast.LENGTH_LONG).show();
        db.close();

    }

    private void consultarSql() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={campoId.getText().toString()};
        try {
            String sql="SELECT "+Utilidades.CAMPO_NOMBRE_PRODUCTO+","+Utilidades.CAMPO_PRECIO_VENTA+
                    " FROM "+Utilidades.TABLA_PRODUCTO+" WHERE "+Utilidades.CAMPO_ID+"=" + parametros[0];

            Cursor cursor=db.rawQuery(sql ,null);

            if (cursor.moveToNext()){
                campoNombre.setText(cursor.getString(0));
                campoPrecioVenta.setText(cursor.getString(1));
            } else {
                Toast.makeText(getApplicationContext(), "El producto no existe", Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Error: " ,Toast.LENGTH_LONG).show();
            limpiar();
        }
    }
    private void consultar() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={campoId.getText().toString()};
        String[] campos={Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_TELEFONO};

        try {
            Cursor cursor =db.query(Utilidades.TABLA_CLIENTE,campos,Utilidades.CAMPO_ID+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            campoNombre.setText(cursor.getString(0));
            campoPrecioVenta.setText(cursor.getString(1));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El Cliente no existe",Toast.LENGTH_LONG).show();
            limpiar();
        }

    }

    private void limpiar() {
        campoNombre.setText("");
        campoPrecioVenta.setText("");
    }

}

