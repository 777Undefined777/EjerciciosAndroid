package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView ls1;
    private String [] nombres = {"jorge","andres","stiven","jose"};
    private String [] edades = {"15","18","30","45"};
    private TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.textv_1);
        ls1 = (ListView) findViewById(R.id.lv1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_prueba, nombres);
        ls1.setAdapter(adapter);
        ls1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                tv1.setText("La edad del usuario es : "+ ls1.getItemAtPosition(i) + "es" + edades[i] + " años");

            }
        });


    }
}