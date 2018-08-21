package com.example.steven.quesorbetosa;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.steven.quesorbetosa.Utilidades.Utilidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class RegistroClientes extends AppCompatActivity {

    Button BTN_RegistrarCliente, BTN_Obtener_Lista_Paises;
    EditText campoNombre,campoTelefono;
    Spinner spinner_Paises;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_clientes);

        spinner_Paises=(Spinner) findViewById(R.id.spinner_Paises) ;
        BTN_Obtener_Lista_Paises=(Button) findViewById(R.id.button);

        campoNombre= (EditText) findViewById(R.id.TXT_Nombre);
        campoTelefono= (EditText) findViewById(R.id.TXT_Telefono);




        BTN_RegistrarCliente=(Button) findViewById(R.id.BTN_RegistrarCliente);
        BTN_RegistrarCliente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                registrarUsuarios();
                limpiar();
            }
        });



        /*****************************************************/

        BTN_Obtener_Lista_Paises=(Button) findViewById(R.id.button);
        BTN_Obtener_Lista_Paises.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                GetListaPaises();
                limpiar();
            }
        });
    }

    private void registrarUsuarios() {
        ConexionSqliteHelper conn=new ConexionSqliteHelper(this,"BDQUESORBETO",null,5);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();

        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO,campoTelefono.getText().toString());


        Long idResultante=db.insert(Utilidades.TABLA_CLIENTE,Utilidades.CAMPO_NOMBRE,values);

        Toast.makeText(getApplicationContext(),"Id Cliente: "+idResultante,Toast.LENGTH_SHORT).show();

        db.close();
    }
    private void limpiar() {
        campoNombre.setText("");
        campoTelefono.setText("");
    }

    public void GetListaPaises(){

        Locale[] locale = Locale.getAvailableLocales();
        ArrayList<String> paises = new ArrayList<>();
        String Pais;

        for (Locale loc : locale){
            Pais = loc.getDisplayCountry();
            if (Pais.length()>0&& !paises.contains(Pais)){
                paises.add(Pais);
            }
        }
        Collections.sort(paises, String.CASE_INSENSITIVE_ORDER);

        ArrayAdapter<String> adapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, paises);
        spinner_Paises.setAdapter(adapter);


    }
}


