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

public class DamageGoodsController7 {

    @FXML
    private TextField reasonTF;
    @FXML
    private TextField productTF;
    @FXML
    private TextField quantityTF;
    @FXML
    private Label statusLabel;

    @FXML
    public void updateInventoryOnAction() {
        String reason = reasonTF.getText().trim();
        String product = productTF.getText().trim();
        String qtyText = quantityTF.getText().trim();

        if (reason.isEmpty() || product.isEmpty() || qtyText.isEmpty()) {
            showAlert("Please fill in all fields.");
            return;
        }

        try {
            int quantity = Integer.parseInt(qtyText);

            statusLabel.setText("Inventory updated for product: " + product + " (" + quantity + ")");
            showAlert("Return/damage recorded successfully.");
            reasonTF.clear();
            productTF.clear();
            quantityTF.clear();
        } catch (NumberFormatException e) {
            showAlert("Quantity must be a number.");
        }
    }

    @FXML
    public void logout() {
        System.out.println("Logged out."); // Replace with scene switch if needed
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @FXML
    public void logOutOnAction(ActionEvent actionEvent)  throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
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

