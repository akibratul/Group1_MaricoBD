package com.example.maricobd.Ratul;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class QProductTestDataMClass {

    private final StringProperty batch;
    private final StringProperty productionDate;
    private final StringProperty expiryDate;
    private final StringProperty result;

    public QProductTestDataMClass(String batch, String productionDate, String expiryDate, String result) {
        this.batch = new SimpleStringProperty(batch);
        this.productionDate = new SimpleStringProperty(productionDate);
        this.expiryDate = new SimpleStringProperty(expiryDate);
        this.result = new SimpleStringProperty(result);
    }

    public StringProperty batchProperty() { return batch; }
    public StringProperty productionDateProperty() { return productionDate; }
    public StringProperty expiryDateProperty() { return expiryDate; }
    public StringProperty resultProperty() { return result; }
}
