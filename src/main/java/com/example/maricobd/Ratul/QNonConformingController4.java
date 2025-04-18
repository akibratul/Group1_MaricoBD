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

public class QNonConformingController4 {

        @FXML private TextField batchTF;
        @FXML private TextField defectTF;
        @FXML private TextField quantityTF;
        @FXML private TextField actionTF;
        @FXML private Label statusLabel;

        @FXML
        public void saveOnAction() {
            String batch = batchTF.getText();
            String defect = defectTF.getText();
            String quantity = quantityTF.getText();
            String action = actionTF.getText();

            if (batch.isEmpty() || defect.isEmpty() || quantity.isEmpty() || action.isEmpty()) {
                statusLabel.setText("Please complete all fields.");
                return;
            }

            statusLabel.setText("Recorded issue for batch " + batch + " with corrective action: " + action);

            // Clear input fields
            batchTF.clear();
            defectTF.clear();
            quantityTF.clear();
            actionTF.clear();
        }

        @FXML
        public void logoutOnAction(ActionEvent actionEvent) throws IOException {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        }

    @FXML
    public void backonAction (ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("QualityControlOfficerDashboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
