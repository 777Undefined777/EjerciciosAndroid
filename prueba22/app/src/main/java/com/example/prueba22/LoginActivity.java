package com.example.prueba22;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText input_phone, input_password;
    private ProgressDialog loadingBar;
    private AdminSQLiteOpenHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper = new AdminSQLiteOpenHelper(this);

        input_phone = findViewById(R.id.login_phone_number_input);
        input_password = findViewById(R.id.login_password_input);
        loadingBar = new ProgressDialog(this);

        Button btn_login = findViewById(R.id.login_btn);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }

    private void loginUser() {
        String phone = input_phone.getText().toString();
        String password = input_password.getText().toString();

        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Por favor, llene todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Verificar las credenciales en la base de datos
        if (checkCredentials(phone, password)) {
            // Si las credenciales son válidas, iniciar sesión
            Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            // Aquí puedes iniciar una nueva actividad o realizar otras acciones después del inicio de sesión
        } else {
            // Si las credenciales son inválidas, mostrar un mensaje de error
            Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkCredentials(String phone, String password) {
        // Obtener una instancia de la base de datos en modo lectura
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Especificar las columnas que deseas recuperar
        String[] projection = {
                "name",
                "phone",
                "password"
        };

        // Especificar la cláusula WHERE
        String selection = "phone = ? AND password = ?";
        String[] selectionArgs = {phone, password};

        // Realizar la consulta
        Cursor cursor = db.query(
                "users",
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        // Verificar si se encontró algún resultado
        boolean found = cursor.moveToFirst();

        // Cerrar el cursor y la conexión de la base de datos
        cursor.close();
        db.close();

        return found;
    }
}
