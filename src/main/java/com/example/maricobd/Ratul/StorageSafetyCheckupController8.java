
package com.example.maricobd.Ratul;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class StorageSafetyCheckupController8 {

    @FXML private ComboBox<String> warehouseCB;
    @FXML private TextField temperatureTF;
    @FXML private TextField expiryDateTF;
    @FXML private TableView<CheckupData> complianceTable;
    @FXML private TableColumn<CheckupData, String> warehouseClmn;
    @FXML private TableColumn<CheckupData, String> temperatureClmn;
    @FXML private TableColumn<CheckupData, String> expiryClmn;

    private final ObservableList<CheckupData> dataList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        warehouseCB.getItems().addAll("Warehouse A", "Warehouse B", "Storage Room 1");

        warehouseClmn.setCellValueFactory(cellData -> cellData.getValue().warehouseProperty());
        temperatureClmn.setCellValueFactory(cellData -> cellData.getValue().temperatureProperty());
        expiryClmn.setCellValueFactory(cellData -> cellData.getValue().expiryProperty());

        complianceTable.setItems(dataList);
    }

    @FXML
    public void updateOnAction() {
        String warehouse = warehouseCB.getValue();
        String temp = temperatureTF.getText();
        String expiry = expiryDateTF.getText();

        if (warehouse == null || temp.isEmpty() || expiry.isEmpty()) {
            showAlert("Please fill in all fields.");
            return;
        }

        dataList.add(new CheckupData(warehouse, temp, expiry));

        warehouseCB.getSelectionModel().clearSelection();
        temperatureTF.clear();
        expiryDateTF.clear();
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
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText(null);
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
