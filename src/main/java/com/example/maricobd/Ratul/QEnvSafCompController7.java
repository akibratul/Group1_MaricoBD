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

public class QEnvSafCompController7 {


        @FXML private TextField wasteTF;
        @FXML private TextField airTF;
    @FXML private Label statusLabel;
    @FXML
    private TextField violationsTF;
    @FXML
    private TextField safetyIncidentsTF;
    @FXML
    private TextField actionsTF;

    @FXML
        public void validateComplianceOnAction() {
            if (fieldsEmpty()) {
                statusLabel.setText("Please fill all fields for validation.");
                statusLabel.setStyle("-fx-text-fill: red;");
            } else {
                statusLabel.setText("Compliance results validated successfully.");
                statusLabel.setStyle("-fx-text-fill: green;");
            }
        }

        @FXML
        public void saveComplianceOnAction() {
            if (fieldsEmpty()) {
                statusLabel.setText("Fill in all fields before saving.");
                statusLabel.setStyle("-fx-text-fill: red;");
            } else {
                statusLabel.setText("Compliance data saved.");
                statusLabel.setStyle("-fx-text-fill: green;");
                clearFields();
            }
        }

        private boolean fieldsEmpty() {
            return wasteTF.getText().isEmpty() || airTF.getText().isEmpty() || safetyIncidentsTF.getText().isEmpty()
                    || violationsTF.getText().isEmpty() || actionsTF.getText().isEmpty();
        }

        private void clearFields() {
            wasteTF.clear();
            airTF.clear();
            safetyIncidentsTF.clear();
            violationsTF.clear();
            actionsTF.clear();
        }

        @FXML
        public void logoutOnAction (ActionEvent actionEvent) throws IOException {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }

    @FXML
    public void backonAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("QualityControlOfficerDashboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
