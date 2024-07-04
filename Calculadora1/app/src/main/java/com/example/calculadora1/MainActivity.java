package com.example.calculadora1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText et1;
    private EditText et2;
    private TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText)findViewById(R.id.edit1);
        et2 = (EditText) findViewById(R.id.edit2);
        tv1 = (TextView) findViewById(R.id.textv1);


    }
    public void Calcular(View view){
       String valor1_String = et1.getText().toString(); 
       String valor2_String = et2.getText().toString();
       int valor1_Int = Integer.parseInt(valor1_String);
       int valor2_Int = Integer.parseInt(valor2_String);

       int suma = valor1_Int + valor2_Int;


       tv1.setText("El resultado de la suma es : " + suma);


    }
}