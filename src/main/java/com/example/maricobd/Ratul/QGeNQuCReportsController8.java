package com.example.maricobd.Ratul;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class QGeNQuCReportsController8 {

        @FXML
        private TextField rawMaterialTF, productionTF, finishedProductTF;
        @FXML
        private TextField dateRangeTF, productTypeTF, defectTypeTF;
        @FXML
        private Label statusLabel;

        @FXML
        public void validateReportOnAction() {
            if (fieldsEmpty()) {
                statusLabel.setText("Please fill in all fields for validation.");
                statusLabel.setStyle("-fx-text-fill: red;");
            } else {
                statusLabel.setText("Report parameters validated successfully.");
                statusLabel.setStyle("-fx-text-fill: green;");
            }
        }

        @FXML
        public void generateReportOnAction() {
            if (fieldsEmpty()) {
                statusLabel.setText("Fill in all fields before generating.");
                statusLabel.setStyle("-fx-text-fill: red;");
            } else {
                statusLabel.setText("Quality Control Report generated.");
                statusLabel.setStyle("-fx-text-fill: green;");
                clearFields();
            }
        }

        private boolean fieldsEmpty() {
            return rawMaterialTF.getText().isEmpty() || productionTF.getText().isEmpty() ||
                    finishedProductTF.getText().isEmpty() || dateRangeTF.getText().isEmpty() ||
                    productTypeTF.getText().isEmpty() || defectTypeTF.getText().isEmpty();
        }

        private void clearFields() {
            rawMaterialTF.clear();
            productionTF.clear();
            finishedProductTF.clear();
            dateRangeTF.clear();
            productTypeTF.clear();
            defectTypeTF.clear();
        }

        @FXML
        public void backonAction(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("QualityControlOfficerDashboard.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }

        @FXML
        public void logoutOnAction(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }


