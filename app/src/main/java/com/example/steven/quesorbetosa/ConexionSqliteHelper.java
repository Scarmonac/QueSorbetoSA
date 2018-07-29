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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_CLIENTE);
    }

    //public void AbrirDB(){
        //this.getWritableDatabase();
    //}

    //public void CerrarDB(){
        //this.close();
    //}

    public void InsertarRegistros(String nombre, int telefono  ){

        ContentValues valores= new ContentValues();
        valores.put("Nombre",nombre );
        valores.put("Telefono", telefono);

        this.getWritableDatabase().insert("Clientes", null,valores);
    }
}
