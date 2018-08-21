package com.example.steven.quesorbetosa;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.steven.quesorbetosa.entidades.Producto;
import com.example.steven.quesorbetosa.Utilidades.Utilidades;

import java.util.ArrayList;

public class FacturacionActivity extends AppCompatActivity {

    Button BTN_Consultar_ClientesFacturacion;
    Button BTN_AgregarProductos_Facturacion;
    EditText campoIdFacturacion,campoNombreFacturacion;
    Spinner spinner_Productos;

    ArrayList<String> listaProductos;
    ArrayList<Producto> ProductosList;

    ConexionSqliteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facturacion);

        conn=new ConexionSqliteHelper(getApplicationContext(),"BDQUESORBETO",null,4);

        campoIdFacturacion= (EditText) findViewById(R.id.TXTidUsuarioFacturacion);
        campoNombreFacturacion= (EditText) findViewById(R.id.TXTnombreUsuarioFacturacion);
        spinner_Productos= (Spinner) findViewById(R.id.spinner_Productos);

            consultarListaProductos();

            ArrayAdapter<CharSequence> adaptador=new ArrayAdapter
                    (this,android.R.layout.simple_spinner_item,listaProductos);

        spinner_Productos.setAdapter(adaptador);

        spinner_Productos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long idl) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        BTN_Consultar_ClientesFacturacion =(Button) findViewById(R.id.BTN_Consultar_ClientesFacturacion);
        BTN_Consultar_ClientesFacturacion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                consultarSql();
            }
        });

    }

    //Buscar los clientes
    private void consultarSql() {
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {campoIdFacturacion.getText().toString()};
        try {
            String sql = "SELECT " + Utilidades.CAMPO_NOMBRE + "," + Utilidades.CAMPO_TELEFONO +
                    " FROM " + Utilidades.TABLA_CLIENTE + " WHERE " + Utilidades.CAMPO_ID + "=" + parametros[0];

            Cursor cursor = db.rawQuery(sql, null);

            if (cursor.moveToNext()) {
                campoNombreFacturacion.setText(cursor.getString(0));

            } else {
                Toast.makeText(getApplicationContext(), "El cliente no existe", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Error: ", Toast.LENGTH_LONG).show();
            limpiar();
        }
    }
        private void limpiar() {
            campoNombreFacturacion.setText("");

        }

    private void consultarListaProductos() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Producto persona=null;
        ProductosList =new ArrayList<Producto>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_PRODUCTO,null);

        while (cursor.moveToNext()){
            persona=new Producto();
            persona.setId(cursor.getInt(0));
            persona.setNombre(cursor.getString(1));
            persona.setTelefono(cursor.getInt(2));

            Log.i("id",persona.getId().toString());
            Log.i("Nombre",persona.getNombre().toString());
            Log.i("Precio",persona.getPrecio_venta().toString());

            ProductosList.add(persona);

        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaProductos=new ArrayList<String>();
        listaProductos.add("Seleccione");

        for(int i=0;i<ProductosList.size();i++){
            listaProductos.add(ProductosList.get(i).getId()+" - "+ProductosList.get(i).getNombre());
        }

    }
}
