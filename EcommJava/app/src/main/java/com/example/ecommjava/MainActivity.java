package com.example.ecommjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Crear una lista de productos de ejemplo
        List<Product> productList = getSampleProductList();

        // Inicializar y configurar el adaptador
        productAdapter = new ProductAdapter(productList, this);
        recyclerView.setAdapter(productAdapter);
    }

    private List<Product> getSampleProductList() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Producto 1", R.drawable.product1, "Descripción del Producto 1"));
        productList.add(new Product("Producto 2", R.drawable.product2, "Descripción del Producto 2"));
        // Agrega más productos según sea necesario

        return productList;
    }
}
