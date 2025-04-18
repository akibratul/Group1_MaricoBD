package com.example.maricobd.Ratul;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CheckupData {

    private final StringProperty warehouse;
    private final StringProperty temperature;
    private final StringProperty expiry;

    public CheckupData(String warehouse, String temperature, String expiry) {
        this.warehouse = new SimpleStringProperty(warehouse);
        this.temperature = new SimpleStringProperty(temperature);
        this.expiry = new SimpleStringProperty(expiry);
    }

    public String getWarehouse() {
        return warehouse.get();
    }

    public void setWarehouse(String warehouse) {
        this.warehouse.set(warehouse);
    }

    public StringProperty warehouseProperty() {
        return warehouse;
    }

    public String getTemperature() {
        return temperature.get();
    }

    public void setTemperature(String temperature) {
        this.temperature.set(temperature);
    }

    public StringProperty temperatureProperty() {
        return temperature;
    }

    public String getExpiry() {
        return expiry.get();
    }

    public void setExpiry(String expiry) {
        this.expiry.set(expiry);
    }

    public StringProperty expiryProperty() {
        return expiry;
    }
}
