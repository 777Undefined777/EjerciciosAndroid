import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistroActivity extends AppCompatActivity {

    private SQLiteDatabase database;
    private EditText editTextNombre, editTextCorreo, editTextContrasena, editTextTipoUsuario;
    private Button buttonRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        dbHelper.copyDatabase();

        // Abre la base de datos después de copiarla desde assets
        database = dbHelper.getWritableDatabase();

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextCorreo = findViewById(R.id.editTextCorreo);
        editTextContrasena = findViewById(R.id.editTextContrasena);
        editTextTipoUsuario = findViewById(R.id.editTextTipoUsuario);
        buttonRegistrar = findViewById(R.id.buttonRegistrar);

        buttonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuario();
            }
        });
    }

    private void registrarUsuario() {
        String nombre = editTextNombre.getText().toString().trim();
        String correo = editTextCorreo.getText().toString().trim();
        String contrasena = editTextContrasena.getText().toString().trim();
        String tipoUsuario = editTextTipoUsuario.getText().toString().trim();

        // Resto del código para registrar un nuevo usuario en la base de datos
        // ...

        // Ejemplo de cómo mostrar un mensaje de éxito
        Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        // Cierra la base de datos al destruir la actividad
        if (database != null) {
            database.close();
        }

        super.onDestroy();
    }
}
}