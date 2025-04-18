package com.example.maricobd.Ratul;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class QMonitoringDataModelClass {

    private final StringProperty feedback;
    private final StringProperty corrective;

    public QMonitoringDataModelClass(String feedback, String corrective) {
        this.feedback = new SimpleStringProperty(feedback);
        this.corrective = new SimpleStringProperty(corrective);
    }

    public StringProperty feedbackProperty() { return feedback; }
    public StringProperty correctiveProperty() { return corrective; }
}
