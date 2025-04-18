
package com.example.maricobd.Ratul;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class QInspectionDataModelClass {
    private final StringProperty product;
    private final StringProperty defects;
    private final StringProperty rating;

    public QInspectionDataModelClass(String product, String defects, String rating) {
        this.product = new SimpleStringProperty(product);
        this.defects = new SimpleStringProperty(defects);
        this.rating = new SimpleStringProperty(rating);
    }

    public StringProperty productProperty() { return product; }
    public StringProperty defectsProperty() { return defects; }
    public StringProperty ratingProperty() { return rating; }
}