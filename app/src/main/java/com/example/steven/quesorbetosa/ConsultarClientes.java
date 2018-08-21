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

public class ConsultarClientes extends AppCompatActivity {

    Button BTN_Consultar_Clientes;
    EditText campoId,campoNombre,campoTelefono;

    ConexionSqliteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_clientes);

        conn=new ConexionSqliteHelper(getApplicationContext(),"BDQUESORBETO",null,4);

        campoId= (EditText) findViewById(R.id.TXTidUsuario);
        campoNombre= (EditText) findViewById(R.id.TXTnombreUsuario);
        campoTelefono= (EditText) findViewById(R.id.TXTtelefonoUsuario);

        BTN_Consultar_Clientes =(Button) findViewById(R.id.BTN_Consultar_Clientes);
        BTN_Consultar_Clientes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                consultarSql();
            }
        });
    }
    /*public void onClick(View view) {

        switch (view.getId()){
            case R.id.BTN_Consultar_Clientes: consultarSql();
                break;
            case R.id.BTN_Actualizar_Clientes: actualizarUsuario();
                break;
            case R.id.BTN_Eliminar_Clientes: eliminarUsuario();
                break;
        }

    }*/

    private void eliminarUsuario() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campoId.getText().toString()};

        db.delete(Utilidades.TABLA_CLIENTE,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Se ha eliminado el usuario",Toast.LENGTH_LONG).show();
        campoId.setText("");
        limpiar();
        db.close();
    }

    private void actualizarUsuario() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campoId.getText().toString()};
        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO,campoTelefono.getText().toString());

        db.update(Utilidades.TABLA_CLIENTE,values,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se actualizó el usuario",Toast.LENGTH_LONG).show();
        db.close();

    }

    private void consultarSql() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={campoId.getText().toString()};
        try {
            String sql="SELECT "+Utilidades.CAMPO_NOMBRE+","+Utilidades.CAMPO_TELEFONO+
                    " FROM "+Utilidades.TABLA_CLIENTE+" WHERE "+Utilidades.CAMPO_ID+"=" + parametros[0];

            Cursor cursor=db.rawQuery(sql ,null);

            if (cursor.moveToNext()){
                campoNombre.setText(cursor.getString(0));
                campoTelefono.setText(cursor.getString(1));
            } else {
                Toast.makeText(getApplicationContext(), "El cliente no existe", Toast.LENGTH_LONG).show();
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
            campoTelefono.setText(cursor.getString(1));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El Cliente no existe",Toast.LENGTH_LONG).show();
            limpiar();
        }


    }

    private void limpiar() {
        campoNombre.setText("");
        campoTelefono.setText("");
    }

}

