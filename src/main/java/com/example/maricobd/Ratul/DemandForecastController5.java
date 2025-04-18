package com.example.maricobd.Ratul;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class DemandForecastController5 {

    @FXML
    private ComboBox<String> productCB;
    @FXML
    private ComboBox<String> timePeriodCB;
    @FXML
    private TextArea forecastTA;

    @FXML
    public void initialize() {
        productCB.getItems().addAll("Hair Care", "Skin Care", "Baby Care", "Health & Hygiene", "Foods");
        timePeriodCB.getItems().addAll("Last Week", "Last Month", "Last 4 Months");
    }

    @FXML
    public void generateForecastOnAction() {
        String product = productCB.getValue();
        String timePeriod = timePeriodCB.getValue();

        if (product == null || timePeriod == null) {
            forecastTA.setText("Please select both product and time period.");
            return;
        }

        int predictedDemand = (int) (Math.random() * 100 + 50);
        String forecast = "Product: " + product + "\nTime Period: " + timePeriod +
                "\nPredicted Demand: " + predictedDemand + " units";
        forecastTA.setText(forecast);
    }

    @FXML
    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void backonAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("InventoryCoordinatorDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}

