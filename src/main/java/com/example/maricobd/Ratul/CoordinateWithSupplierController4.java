package com.example.maricobd.Ratul;

import javafx.collections.FXCollections;
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

public class CoordinateWithSupplierController4 {

    @FXML
    private ComboBox<String> supplierCB;

    @FXML
    private TextField productTF;

    @FXML
    private TextField quantityTF;

    @FXML
    private TextField dueDateTF;

    @FXML
    private Label statusLabel;

    @FXML
    public void initialize() {

        supplierCB.setItems(FXCollections.observableArrayList(
                "A", "B", "C", "D"
        ));
    }

    @FXML
    public void sendRequestOnAction() {
        String supplier = supplierCB.getValue();
        String product = productTF.getText().trim();
        String qty = quantityTF.getText().trim();
        String dueDate = dueDateTF.getText().trim();

        if (supplier == null || product.isEmpty() || qty.isEmpty() || dueDate.isEmpty()) {
            showAlert("Please fill in all fields.");
            return;
        }

        // Simulate sending request
        System.out.println("Request sent to " + supplier + " for " + qty + " units of " + product + " (Due: " + dueDate + ")");
        statusLabel.setText("Request sent successfully to " + supplier + ".");

        productTF.clear();
        quantityTF.clear();
        dueDateTF.clear();
    }

    @FXML
    public void logoutOnAction (ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @Deprecated
    public void buttononAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InventoryCoordinatorDashboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void backonAction(ActionEvent actionEvent)  throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InventoryCoordinatorDashboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
