package com.example.steven.quesorbetosa;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.steven.quesorbetosa.Utilidades.Utilidades;

public class ConexionSqliteHelper extends SQLiteOpenHelper{


    public ConexionSqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Utilidades.CREAR_TABLA_CLIENTE);
        db.execSQL(Utilidades.CREAR_TABLA_PRODUCTO);
        db.execSQL(Utilidades.CREAR_TABLA_FACTURACION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_CLIENTE);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_PRODUCTO);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_FACTURACION);
        onCreate(db);
    }

    public void InsertarRegistros(String nombre, int telefono, String pais   ){

        ContentValues valores= new ContentValues();
        valores.put("Nombre",nombre );
        valores.put("Telefono", telefono);
        valores.put("Pais", pais);

        this.getWritableDatabase().insert("Clientes", null,valores);
    }
    public void InsertarRegistrosProducto(String nombre, int Precio_Venta  ){

        ContentValues valores= new ContentValues();
        valores.put("Nombre",nombre );
        valores.put("Precio Venta", Precio_Venta);

        this.getWritableDatabase().insert("Productos", null,valores);
    }
}
