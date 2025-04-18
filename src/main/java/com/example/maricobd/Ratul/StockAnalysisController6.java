package com.example.maricobd.Ratul;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class StockAnalysisController6 {

    @FXML private TextField missingStockTF;
    @FXML private TextField overstockTF;
    @FXML private TextField notesTF;
    @FXML private Label statusLabel;

    @FXML
    public void resolveIssueOnAction() {
        String missing = missingStockTF.getText().trim();
        String over = overstockTF.getText().trim();
        String notes = notesTF.getText().trim();

        if (missing.isEmpty() && over.isEmpty()) {
            showAlert("Please enter either missing stock or overstock values.");
            return;
        }

        statusLabel.setText("Inventory adjusted. Notes: " + notes);
        showAlert("Issue resolved successfully!");


        missingStockTF.clear();
        overstockTF.clear();
        notesTF.clear();
    }

    @FXML
    public void logoutonAction (ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @FXML
    public void backonAction (ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InventoryCoordinatorDashboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
