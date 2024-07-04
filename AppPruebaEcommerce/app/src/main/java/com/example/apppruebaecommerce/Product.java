package com.example.apppruebaecommerce;

public class Product {
    private String productName;
    private int productImageResource; // Recurso de la imagen
    private String productDescription;

    public Product(String productName, int productImageResource, String productDescription) {
        this.productName = productName;
        this.productImageResource = productImageResource;
        this.productDescription = productDescription;
    }

    // Getter methods para acceder a los atributos
    public String getProductName() {
        return productName;
    }

    public int getProductImageResource() {
        return productImageResource;
    }

    public String getProductDescription() {
        return productDescription;
    }
}
