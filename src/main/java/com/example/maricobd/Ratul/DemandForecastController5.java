package com.example.maricobd.Ratul;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
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
        productCB.getItems().addAll("Chips", "Oil", "Soap", "Biscuit");
        timePeriodCB.getItems().addAll("Last Week", "Last Month", "Last 4 Months");
    }

    @FXML
    public void generateForecastOnAction() {
        String product = productCB.getValue();
        String timePeriod = timePeriodCB.getValue();

        if (product == null || timePeriod == null) {
            showAlert("Please select both product and time period.");
            return;
        }

        String forecast = "Product: " + product + "\nTime Period: " + timePeriod +
                "\nPredicted demand: " + (int) (Math.random() * 100 + 50) + " units.";
        forecastTA.setText(forecast);
    }

    @FXML
    public void saveReportOnAction() {
        String content = forecastTA.getText();
        if (content.isEmpty()) {
            showAlert("No forecast data to save.");
            return;
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Forecast Report");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(content);
                showAlert("Forecast saved successfully.");
            } catch (IOException e) {
                showAlert("Error saving file.");
            }
        }
    }

    @FXML
    public void logOutOnAction (ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setContentText(msg);
        alert.showAndWait();
    }


    @FXML
    public void backonAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InventoryCoordinatorDashboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
