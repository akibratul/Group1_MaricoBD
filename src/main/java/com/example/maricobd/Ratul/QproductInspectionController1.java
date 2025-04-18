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

public class QproductInspectionController1 {


        @FXML
        private ComboBox<String> productCB;
        @FXML
        private TextField defectsTF;
        @FXML
        private TextField ratingTF;
        @FXML
        private Label statusLabel;

        @FXML
        private TableView<QInspectionDataModelClass> inspectionTable;
        @FXML
        private TableColumn<QInspectionDataModelClass, String> productCol;
        @FXML
        private TableColumn<QInspectionDataModelClass, String> defectsCol;
        @FXML
        private TableColumn<QInspectionDataModelClass, String> ratingCol;

        private final ObservableList<QInspectionDataModelClass> inspectionList = FXCollections.observableArrayList();
    @FXML
    private Button backonAction;
    @FXML
    private Button saveButton;

    @FXML
        public void initialize() {
            productCB.setItems(FXCollections.observableArrayList("Product A", "Product B", "Product C"));

            productCol.setCellValueFactory(cellData -> cellData.getValue().productProperty());
            defectsCol.setCellValueFactory(cellData -> cellData.getValue().defectsProperty());
            ratingCol.setCellValueFactory(cellData -> cellData.getValue().ratingProperty());

            inspectionTable.setItems(inspectionList);
        }

        @FXML
        public void saveInspectionOnAction() {
            String product = productCB.getValue();
            String defects = defectsTF.getText();
            String rating = ratingTF.getText();

            if (product == null || defects.isEmpty() || rating.isEmpty()) {
                statusLabel.setText("Please complete all fields.");
                return;
            }

            inspectionList.add(new QInspectionDataModelClass(product, defects, rating));
            statusLabel.setText("Inspection saved for " + product);

            productCB.getSelectionModel().clearSelection();
            defectsTF.clear();
            ratingTF.clear();
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
