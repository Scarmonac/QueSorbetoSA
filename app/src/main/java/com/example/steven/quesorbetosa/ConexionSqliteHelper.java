package com.example.steven.quesorbetosa;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionSqliteHelper extends SQLiteOpenHelper{

    public ConexionSqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    String query="create table clientes(_id integer primary key autoincrement, " + "Nombre decimal, telefono int)";
    db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void AbrirDB(){
        this.getWritableDatabase();
    }

    public void CerrarDB(){

        this.close();
    }
    public void InsertarRegistros(String nombre, int telefono  ){

        ContentValues valores= new ContentValues();
        valores.put("Nombre",nombre );
        valores.put("Telefono", telefono);

        this.getWritableDatabase().insert("Clientes", null,valores);
    }
}
