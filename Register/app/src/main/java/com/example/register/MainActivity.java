package com.example.register;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log; // Añade esta importación
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Agregar el código para manejar el clic del botón de registro
        Button registerLinkButton = findViewById(R.id.registerLinkButton);

        registerLinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MainActivity", "Clic en el botón de registro"); // Añade este mensaje de registro
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
