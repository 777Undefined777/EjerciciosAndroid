package com.example.op2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    // Nombre de la base de datos
    private static final String DATABASE_NAME = "santa_rita_shop_db";
    // Versión de la base de datos
    private static final int DATABASE_VERSION = 1;

    public AdminSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Método para crear la estructura de la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear tabla de usuarios
        String createUserTableQuery = "CREATE TABLE IF NOT EXISTS users ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT,"
                + "phone TEXT,"
                + "password TEXT,"
                + "image TEXT,"
                + "address TEXT)";
        db.execSQL(createUserTableQuery);

        // Crear tabla de pedidos
        String createCommandTableQuery = "CREATE TABLE IF NOT EXISTS commands ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT,"
                + "phone TEXT,"
                + "address TEXT,"
                + "city TEXT,"
                + "state TEXT,"
                + "date TEXT,"
                + "time TEXT,"
                + "totalPrice TEXT,"
                + "user_id INTEGER,"
                + "FOREIGN KEY (user_id) REFERENCES users(id))";
        db.execSQL(createCommandTableQuery);

        // Crear tabla de productos
        String createProductTableQuery = "CREATE TABLE IF NOT EXISTS products ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "pname TEXT,"
                + "description TEXT,"
                + "price TEXT,"
                + "image TEXT,"
                + "category TEXT,"
                + "date TEXT,"
                + "time TEXT)";
        db.execSQL(createProductTableQuery);

        // Crear tabla de tarjetas
        String createCardTableQuery = "CREATE TABLE IF NOT EXISTS cards ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "pid INTEGER,"
                + "pname TEXT,"
                + "price TEXT,"
                + "discount TEXT,"
                + "quantity TEXT,"
                + "command_id INTEGER,"
                + "product_id INTEGER,"
                + "FOREIGN KEY (command_id) REFERENCES commands(id),"
                + "FOREIGN KEY (product_id) REFERENCES products(id))";
        db.execSQL(createCardTableQuery);
    }

    // Método para actualizar la estructura de la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // No se realiza ninguna acción aquí para esta versión
    }
}
