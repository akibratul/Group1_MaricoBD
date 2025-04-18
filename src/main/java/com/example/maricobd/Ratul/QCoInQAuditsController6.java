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

public class QCoInQAuditsController6 {

        @FXML
        private TextField processTF;
        @FXML private TextField documentationTF;
        @FXML private TextField safetyTF;
        @FXML private TextField nonComplianceTF;
        @FXML private TextField observationsTF;
        @FXML private TextField recommendationsTF;
        @FXML private Label statusLabel;

        @FXML
        public void validateAuditOnAction() {
            String process = processTF.getText();
            String docs = documentationTF.getText();
            String safety = safetyTF.getText();
            String nonCompliance = nonComplianceTF.getText();
            String observations = observationsTF.getText();
            String recommendations = recommendationsTF.getText();

            if (process.isEmpty() || docs.isEmpty() || safety.isEmpty() ||
                    nonCompliance.isEmpty() || observations.isEmpty() || recommendations.isEmpty()) {
                statusLabel.setText("Please fill in all fields.");
                statusLabel.setStyle("-fx-text-fill: red;");
                return;
            }


            statusLabel.setText("Audit findings validated successfully.");
            statusLabel.setStyle("-fx-text-fill: green;");


            processTF.clear();
            documentationTF.clear();
            safetyTF.clear();
            nonComplianceTF.clear();
            observationsTF.clear();
            recommendationsTF.clear();
        }

        @FXML
        public void logoutOnAction  (ActionEvent actionEvent) throws IOException {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }


    @FXML
    public void buttononAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("QualityControlOfficerDashboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
