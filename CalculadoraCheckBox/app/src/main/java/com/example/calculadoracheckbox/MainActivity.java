package com.example.calculadoracheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv1,tv2;
    private CheckBox cb1, cb2;
    private EditText et1, et2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText)findViewById(R.id.et_n1);
        et2 = (EditText)findViewById(R.id.et_n2);
        tv1 = (TextView)findViewById(R.id.tv_resultado);
        tv2 = (TextView)findViewById(R.id.tv_result2);
        cb1 = (CheckBox)findViewById(R.id.cb_sumar);
        cb2 = (CheckBox)findViewById(R.id.cb_restar);


    }
    public void Calcular(View view) {
        String valor1_String = et1.getText().toString();
        String valor2_String = et2.getText().toString();

        int valor1_Int = Integer.parseInt(valor1_String);
        int valor2_Int = Integer.parseInt(valor2_String);

        if (cb1.isChecked() == true){
            int suma = valor1_Int + valor2_Int;
            int resultado = suma;
            tv1.setText("el resultado de la suma es :"+resultado);




        } if (cb2.isChecked() == true) {
            int resta = valor1_Int - valor2_Int;
            int resultado = resta;

            tv2.setText("el resultado de la resta es "+resultado);




        }



    }


}