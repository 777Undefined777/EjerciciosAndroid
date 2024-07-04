package com.example.spinnervector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Spinner spinnerone;
    private EditText et1, et2;

    private TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.edit1);
        et2 = (EditText) findViewById(R.id.edit2);
        tv1 = (TextView) findViewById(R.id.text1);
        spinnerone = (Spinner) findViewById(R.id.spinner);



        String [] opciones = {"sumar","restar","multiplicar","dividir"};

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_prueba, opciones);
        spinnerone.setAdapter(adapter);
    }
    public void calcular(View view){
        String valor1_String = et1.getText().toString();
        String valor2_String = et2.getText().toString();

        int valor1_Int = Integer.parseInt(valor1_String);
        int valor2_Int = Integer.parseInt(valor2_String);

        String seleccion = spinnerone.getSelectedItem().toString();
        if(seleccion.equals("sumar")){
            int suma = valor1_Int + valor1_Int;
            String resultado = String.valueOf(suma);
            tv1.setText("El resultado de la suma es " + resultado);
        }else if (seleccion.equals("restar")){
            int resta = valor1_Int - valor2_Int;
            String resultado = String.valueOf(resta);
            tv1.setText("El resultado de la resta es " + resta);


        } else if (seleccion.equals("multiplicar")) {
            int multi = valor1_Int * valor2_Int;
            String resultado = String.valueOf(multi);
            tv1.setText("El resultado de la multiplicacion es :"+resultado);

        } else if (seleccion.equals("dividir")) {
            if (valor2_Int != 0){
                int div = valor1_Int / valor2_Int;
                String resultado = String.valueOf(div);
                tv1.setText("El resultado de la division es " + resultado);

            }else{
                Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_LONG).show();

            }

        }

    }
}