package com.example.moviesapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.moviesapp.R;

public class JsonViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_viewer);

        TextView jsonTextView = findViewById(R.id.json_text_view);

        // Obtén el JSON desde el Intent
        Intent intent = getIntent();
        String json = intent.getStringExtra("json_data");

        // Muestra el JSON en el TextView
        if (json != null) {
            jsonTextView.setText(json);
        }
    }
}
