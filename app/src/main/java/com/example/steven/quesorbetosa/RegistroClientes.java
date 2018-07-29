package com.example.steven.quesorbetosa;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.steven.quesorbetosa.Utilidades.Utilidades;

public class RegistroClientes extends AppCompatActivity {

    Button BTN_RegistrarCliente;
    EditText campoNombre,campoTelefono;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registro_clientes);

        campoNombre= (EditText) findViewById(R.id.TXT_Nombre);
        campoTelefono= (EditText) findViewById(R.id.TXT_Telefono);



        BTN_RegistrarCliente=(Button) findViewById(R.id.BTN_RegistrarCliente);
                BTN_RegistrarCliente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                registrarUsuarios();
            }
        });

    }
//    public void onClick(View view) {
        //registrarUsuarios();
        //registrarUsuariosSql();
    //}
/*
    private void registrarUsuariosSql() {
        ConexionSqliteHelper conn=new ConexionSqliteHelper(this,"bd_Clientes",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        //insert into Cliente (nombre,telefono) values ('Steven','89205444')

        String insert="INSERT INTO "+ Utilidades.TABLA_CLIENTE
                +" ( " +","+Utilidades.CAMPO_NOMBRE+","+Utilidades.CAMPO_TELEFONO+")" +
                " VALUES ("+", '"+campoNombre.getText().toString()+"','"
                +campoTelefono.getText().toString()+"')";

        db.execSQL(insert);


        db.close();
    }
*/

    private void registrarUsuarios() {
        ConexionSqliteHelper conn=new ConexionSqliteHelper(this,"BDQUESORBETO",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();

        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO,campoTelefono.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_CLIENTE,Utilidades.CAMPO_NOMBRE,values);

        Toast.makeText(getApplicationContext(),"Id Cliente: "+idResultante,Toast.LENGTH_SHORT).show();

        db.close();
    }
}

