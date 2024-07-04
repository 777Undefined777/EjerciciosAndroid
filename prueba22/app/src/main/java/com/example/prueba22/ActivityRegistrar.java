package com.example.prueba22;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityRegistrar extends AppCompatActivity {

    private EditText input_name, input_phone, input_password;
    private ProgressDialog loadingBar;
    private AdminSQLiteOpenHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        dbHelper = new AdminSQLiteOpenHelper(this);

        input_name = findViewById(R.id.register_username_input);
        input_phone = findViewById(R.id.register_phone_number_input);
        input_password = findViewById(R.id.register_password_input);
        loadingBar = new ProgressDialog(this);

        Button btn_create_account = findViewById(R.id.btn_register);
        btn_create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
            }
        });
    }

    private void createAccount() {
        String name = input_name.getText().toString();
        String phone = input_phone.getText().toString();
        String password = input_password.getText().toString();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Por favor, llene todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Registro en la base de datos
        registerUser(name, phone, password);
    }

    private void registerUser(String name, String phone, String password) {
        loadingBar.setTitle("Creando su usuario");
        loadingBar.setMessage("Por favor, espere un momento...");
        loadingBar.setCanceledOnTouchOutside(false);
        loadingBar.show();

        // Obtener una instancia de la base de datos
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Preparar los valores para la inserción
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("phone", phone);
        values.put("password", password);

        // Insertar en la base de datos
        long newRowId = db.insert("users", null, values);

        loadingBar.dismiss();

        // Mostrar mensaje de éxito o error
        if (newRowId != -1) {
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
            // Redirigir a la actividad de inicio de sesión
            startActivity(new Intent(this, LoginActivity.class));
            finish(); // Finalizar esta actividad para que el usuario no pueda volver atrás
        } else {
            Toast.makeText(this, "Error al registrar el usuario", Toast.LENGTH_SHORT).show();
        }

        // Limpiar los campos después del registro
        input_name.setText("");
        input_phone.setText("");
        input_password.setText("");

        // Cerrar la conexión de la base de datos
        db.close();
    }
}
