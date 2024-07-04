package com.example.promediocomplete;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private EditText et3;
    private TextView tv1;
    private SQLiteDatabase database;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.editTextNumber);
        et2 = findViewById(R.id.editTextNumber2);
        et3 = findViewById(R.id.editTextNumber3);
        tv1 = findViewById(R.id.textView);

        // Obtener la instancia de la base de datos
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        database = dbHelper.getWritableDatabase();

        // Verificar si la conexión a la base de datos fue exitosa
        if (database != null) {
            Log.d(TAG, "Conexión a la base de datos exitosa");
        } else {
            Log.e(TAG, "Error al conectar a la base de datos");
        }
    }

    public void status(View view) {
        String Quimica_String = et1.getText().toString();
        String Fisica_String = et2.getText().toString();
        String Espanol_String = et3.getText().toString();

        int Quimica_int = Integer.parseInt(Quimica_String);
        int Fisica_int = Integer.parseInt(Fisica_String);
        int Espanol_int = Integer.parseInt(Espanol_String);

        int promedio = (Quimica_int + Fisica_int + Espanol_int) / 3;

        
        String estado;
        if (promedio >= 6) {
            estado = "Aprobado";
        } else {
            estado = "Reprobado";
        }

        // Insertar datos en la base de datos sin incluir la columna id_notas
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_QUIMICA, Quimica_int);
        values.put(DatabaseHelper.COLUMN_FISICA, Fisica_int);
        values.put(DatabaseHelper.COLUMN_ESPANOL, Espanol_int);
        values.put(DatabaseHelper.COLUMN_ESTADO, estado);

        try {
            // Intenta imprimir el valor de newRowId y verifica si está devolviendo un valor distinto de -1
            long newRowId = database.insert(DatabaseHelper.TABLE_NOTAS, null, values);
            Log.d(TAG, "newRowId: " + newRowId);

            // Verificar si los datos se guardaron correctamente
            if (newRowId != -1) {
                Log.d(TAG, "Datos guardados correctamente en la base de datos");
            } else {
                Log.e(TAG, "Error al guardar los datos en la base de datos");
            }
        } catch (Exception e) {
            Log.e(TAG, "Error al guardar los datos en la base de datos", e);
        }

        // Actualizar la interfaz de usuario
        tv1.setText(estado + " con " + promedio);
        et1.setText("");
        et2.setText("");
        et3.setText("");

        // Restaurar el texto después de 6 segundos
        new Handler().postDelayed(() -> tv1.setText("Estado Del Estudiante"), 6000);
    }
}
