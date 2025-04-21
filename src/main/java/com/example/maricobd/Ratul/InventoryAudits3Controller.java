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

public class InventoryAudits3Controller {

    @FXML
    private ComboBox<String> departmentCB;

    @FXML
    private ComboBox<String> categoryCB;

    @FXML
    private TextArea qualityDataTA;

    @FXML
    private TextField nonConformitiesTF;

    @FXML
    private TextField correctiveActionsTF;

    @FXML
    private Label statusLabel;

    @FXML
    public void initialize() {

        departmentCB.setItems(FXCollections.observableArrayList("Warehouse", "Production", "Logistics"));
        categoryCB.setItems(FXCollections.observableArrayList("Hair Care", "Skin Care", "Baby Care", "Health & Hygiene", "Foods"));

        departmentCB.setOnAction(event -> loadQualityData());
        categoryCB.setOnAction(event -> loadQualityData());
    }

    private void loadQualityData() {
        String dept = departmentCB.getValue();
        String cat = categoryCB.getValue();

        if (dept != null && cat != null) {
            qualityDataTA.setText("Audit Report for " + dept + " - " + cat + ":\n" + "- Stock matched: Yes\n" + "- Damaged items: 2\n" + "- Expired products: 0\n");
        }
    }

    @FXML
    public void resolveIssueOnAction() {
        String nonConformity = nonConformitiesTF.getText().trim();
        String correctiveAction = correctiveActionsTF.getText().trim();

        if (nonConformity.isEmpty() || correctiveAction.isEmpty()) {
            showAlert("Please fill in both Non-Conformities and Corrective Actions.");
            return;
        }
        statusLabel.setText("Audit issues resolved successfully.");

        nonConformitiesTF.clear();
        correctiveActionsTF.clear();
    }

    @FXML
    public void LogoutOnAction (ActionEvent actionEvent) throws IOException {
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

    @FXML
    public void backonAction(ActionEvent actionEvent)throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("InventoryCoordinatorDashboard.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }
