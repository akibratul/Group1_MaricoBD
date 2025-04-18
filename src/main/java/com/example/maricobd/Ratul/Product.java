package com.example.maricobd.Ratul;

import javafx.beans.property.*;

public class Product {
    private final StringProperty category;
    private final StringProperty brand;
    private final DoubleProperty price;
    private final IntegerProperty quantity;

    public Product(String category, String brand, double price, int quantity) {
        this.category = new SimpleStringProperty(category);
        this.brand = new SimpleStringProperty(brand);
        this.price = new SimpleDoubleProperty(price);
        this.quantity = new SimpleIntegerProperty(quantity);
    }


    public String getCategory() { return category.get(); }
    public void setCategory(String value) { category.set(value); }
    public StringProperty categoryProperty() { return category; }

    public String getBrand() { return brand.get(); }
    public void setBrand(String value) { brand.set(value); }
    public StringProperty brandProperty() { return brand; }

    public double getPrice() { return price.get(); }
    public void setPrice(double value) { price.set(value); }
    public DoubleProperty priceProperty() { return price; }

    public int getQuantity() { return quantity.get(); }
    public void setQuantity(int value) { quantity.set(value); }
    public IntegerProperty quantityProperty() { return quantity; }


}