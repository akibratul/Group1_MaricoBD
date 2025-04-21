
package com.example.maricobd.Ratul;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class TrackStockMovementsController2 {

        @FXML
        private ComboBox<String> movementTypeCB;

        @FXML
        private TextField shipmentIdTF;

        @FXML
        private TextField quantityTF;

        @FXML
        private Label statusLabel;

        @FXML
        public void initialize() {
            movementTypeCB.getItems().addAll("Incoming Stock", "Outgoing Stock");
        }


        @FXML
        public void SaveMovementOnAction() {
            String type = movementTypeCB.getValue();
            String id = shipmentIdTF.getText();
            String qtyText = quantityTF.getText();

            if (type == null || id.isEmpty() || qtyText.isEmpty()) {
                statusLabel.setText("Please fill all fields.");
                return;
            }

            try {
                int qty = Integer.parseInt(qtyText);
                // Save logic here
                statusLabel.setText("Stock movement saved successfully!");
            } catch (NumberFormatException e) {
                statusLabel.setText("Quantity must be a number.");
            }
        }

        @FXML
        public void LogoutOnAction (ActionEvent actionEvent) throws IOException {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();


        }

    @FXML
    public void backonAction(ActionEvent actionEvent)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InventoryCoordinatorDashboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}

