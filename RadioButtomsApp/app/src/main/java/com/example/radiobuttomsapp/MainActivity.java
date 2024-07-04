package com.example.radiobuttomsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private EditText editx1;
    private EditText editx2;
    private TextView textvie1;
    private RadioButton radio1;
    private RadioButton radio2;
    private static final String TAG = "MainActivity";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editx1 =  findViewById(R.id.et1);
        editx2 = findViewById(R.id.et2);
        textvie1 = findViewById(R.id.tv1);
        radio1 = findViewById(R.id.rb_suma);
        radio2 = findViewById(R.id.rb_resta);


    }

    public void Calcular(View view){
        String valor1_String = editx1.getText().toString();
        String valor2_String = editx2.getText().toString();

        int valor1_Int = Integer.parseInt(valor1_String);
        int valor2_Int = Integer.parseInt(valor2_String);


        if (radio1.isChecked() == true){
            int suma = valor1_Int + valor2_Int;
            String resultado = String.valueOf(suma);
            textvie1.setText("el resultaod de la suma es: "
                    +resultado);
        }else if (radio2.isChecked() == true) {
            int resta = valor1_Int - valor2_Int;
            String resultado = String.valueOf(resta);
            textvie1.setText("el resultado de la resta es :"
                    +resultado);

        }


    }
}