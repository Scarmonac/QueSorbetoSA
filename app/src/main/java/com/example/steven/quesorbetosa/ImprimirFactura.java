package com.example.steven.quesorbetosa;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.steven.quesorbetosa.Utilidades.Utilidades;

public class ImprimirFactura extends AppCompatActivity {

    Button BTN_Consultar_Facturas;
    EditText campoId,campoNombre,CampoCantidadProductos,campoPrecioVenta,campoTotalPagar;

    ConexionSqliteHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imprimir_factura);

        conn = new ConexionSqliteHelper(getApplicationContext(), "BDQUESORBETO", null, 5);

        campoId = (EditText) findViewById(R.id.TXT_Id_Factura);
        campoNombre = (EditText) findViewById(R.id.TXT_Nombre_Cliente);
        CampoCantidadProductos = (EditText) findViewById(R.id.TXTCantidadProductos);
        campoPrecioVenta = (EditText) findViewById(R.id.TXTPrecioProducto);
        campoTotalPagar = (EditText) findViewById(R.id.TXTtotal);

        BTN_Consultar_Facturas = (Button) findViewById(R.id.BTN_Consultar_Facturas);
        BTN_Consultar_Facturas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                consultarSql();
            }
        });
    }

        private void consultarSql() {
            SQLiteDatabase db=conn.getReadableDatabase();
            String[] parametros={campoId.getText().toString()};
            try {
                String sql="SELECT "+ Utilidades.CAMPO_NOMBRE_CLIENTE+","+Utilidades.CAMPO_CANTIDAD_PRODUCTO+ Utilidades.CAMPO_PRECIO_VENTA +  Utilidades.CAMPO_TOTAL +
                        " FROM "+Utilidades.TABLA_FACTURACION+" WHERE "+Utilidades.CAMPO_ID+"=" + parametros[0];

                Cursor cursor=db.rawQuery(sql ,null);

                if (cursor.moveToNext()){
                    campoNombre.setText(cursor.getString(0));
                    CampoCantidadProductos.setText(cursor.getString(1));
                    campoPrecioVenta.setText(cursor.getString(2));
                    campoTotalPagar.setText(cursor.getString(3));

                } else {
                    Toast.makeText(getApplicationContext(), "El producto no existe", Toast.LENGTH_LONG).show();
                }
            }catch (Exception e){
                Toast.makeText(getApplicationContext(),"Error: " ,Toast.LENGTH_LONG).show();
                limpiar();
            }

        }
        private void limpiar() {
            campoNombre.setText("");
            campoPrecioVenta.setText("");
        }

    }


