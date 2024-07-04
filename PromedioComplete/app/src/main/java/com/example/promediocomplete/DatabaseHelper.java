package com.example.promediocomplete;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "prueba.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NOTAS = "notas";
    public static final String COLUMN_ID_NOTAS = "id_notas";
    public static final String COLUMN_QUIMICA = "quimica";
    public static final String COLUMN_FISICA = "fisica";
    public static final String COLUMN_ESPANOL = "espanol";
    public static final String COLUMN_ESTADO = "estado";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NOTAS + " (" +
                    COLUMN_ID_NOTAS + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_QUIMICA + " INTEGER, " +
                    COLUMN_FISICA + " INTEGER, " +
                    COLUMN_ESPANOL + " INTEGER, " +
                    COLUMN_ESTADO + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTAS);
        onCreate(db);
    }
}
