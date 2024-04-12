package com.example.gerenciadordeprovasdeconcursos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 4;
    public static final String DATABASE_NAME = "gerenciador.db";
    private static final String SQL_CREATE_PASS = "CREATE TABLE provas (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, empresa TEXT, orgaoPublico TEXT," +
            "estado TEXT, ano TEXT, nivel TEXT, cargo TEXT)";
    private static final String SQL_POPULATE_PASS = "INSERT INTO provas VALUES " +
        "(NULL, 'GMail', 'dovahkiin', 'Teste123', 'Nota de Teste','TESTE','Teste')";
    private static final String SQL_DELETE_PASS = "DROP TABLE IF EXISTS provas";
    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PASS);
        db.execSQL(SQL_POPULATE_PASS);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_PASS);
        onCreate(db);
    }
}
