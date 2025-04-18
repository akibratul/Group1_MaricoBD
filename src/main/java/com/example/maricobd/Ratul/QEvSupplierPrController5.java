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

public class QEvSupplierPrController5 {

        @FXML private TextField deliveryTF;
        @FXML private TextField defectRateTF;
        @FXML private TextField complianceScoreTF;
        @FXML private TextField ratingTF;
        @FXML private TextField feedbackTF;
        @FXML private TextField suggestionsTF;
        @FXML private Label statusLabel;

        @FXML
        public void validateEvaluationOnAction() {
            String delivery = deliveryTF.getText();
            String defectRate = defectRateTF.getText();
            String compliance = complianceScoreTF.getText();
            String rating = ratingTF.getText();
            String feedback = feedbackTF.getText();
            String suggestions = suggestionsTF.getText();

            if (delivery.isEmpty() || defectRate.isEmpty() || compliance.isEmpty() ||
                    rating.isEmpty() || feedback.isEmpty() || suggestions.isEmpty()) {
                statusLabel.setText("Please fill in all fields.");
                statusLabel.setStyle("-fx-text-fill: red;");
                return;
            }

            statusLabel.setText("Supplier evaluation recorded and validated successfully.");
            statusLabel.setStyle("-fx-text-fill: green;");

            deliveryTF.clear();
            defectRateTF.clear();
            complianceScoreTF.clear();
            ratingTF.clear();
            feedbackTF.clear();
            suggestionsTF.clear();
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
    public void backonAction (ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("QualityControlOfficerDashboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
