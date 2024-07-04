package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private TextView vertext;
    private EditText editx1, editx2;
    private RadioButton radio1,radio2,radio3,radio4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editx1 = findViewById(R.id.et1);
        editx2 = findViewById(R.id.et2);
        vertext = findViewById(R.id.tv1);
        radio1 = findViewById(R.id.rb_suma);
        radio2 = findViewById(R.id.rb_resta);
        radio3 = findViewById(R.id.rb_mult);
        radio4 = findViewById(R.id.rb_division);


    }
    public void Calcular(View view){

        String valor1_String = editx1.getText().toString();
        String valor2_String = editx2.getText().toString();

        int valor1_int = Integer.parseInt(valor1_String);
        int valor2_int = Integer.parseInt(valor2_String);


        if (radio1.isChecked() == true){

            int suma = valor1_int + valor2_int;
            String resultado = String.valueOf(suma);
            vertext.setText("el resultado es : "+resultado);




        } else if (radio2.isChecked() == true) {
            int resta = valor1_int - valor2_int;
            String resultado = String.valueOf(resta);
            vertext.setText("el resultado es : "+resultado);

        } else if (radio3.isChecked() == true) {
            int multiplicacion = valor1_int * valor2_int;
            String resultado = String.valueOf(multiplicacion);
            vertext.setText("el resultado es : " + resultado);


        } else if (radio4.isChecked() == true) {


            if (valor2_int != 0 ){
                int division = valor1_int / valor2_int;
                String resultado = String.valueOf(division);
                vertext.setText("el resultado de la division es "+ resultado);



            } else{
                Toast.makeText(this,"el segundo valor debe ser diferente de 0", Toast.LENGTH_LONG).show();// que se muestre en esta activity con el this
            }


        }

    }
}