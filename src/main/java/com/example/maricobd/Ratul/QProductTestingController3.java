package com.example.maricobd.Ratul;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class QProductTestingController3
{


        @FXML
        private TextField batchTF;
        @FXML private TextField productionTF;
        @FXML private TextField expiryTF;
        @FXML private TextField resultTF;
        @FXML private Label statusLabel;

        @FXML private TableView<QProductTestDataMClass> testingTable;
        @FXML private TableColumn<QProductTestDataMClass, String> batchCol;
        @FXML private TableColumn<QProductTestDataMClass, String> prodCol;
        @FXML private TableColumn<QProductTestDataMClass, String> expCol;
        @FXML private TableColumn<QProductTestDataMClass, String> resultCol;

        private ObservableList<QProductTestDataMClass> testDataList = FXCollections.observableArrayList();

        @FXML
        public void initialize() {
            batchCol.setCellValueFactory(data -> data.getValue().batchProperty());
            prodCol.setCellValueFactory(data -> data.getValue().productionDateProperty());
            expCol.setCellValueFactory(data -> data.getValue().expiryDateProperty());
            resultCol.setCellValueFactory(data -> data.getValue().resultProperty());

            testingTable.setItems(testDataList);
        }

        @FXML
        public void saveTestingOnAction() {
            String batch = batchTF.getText();
            String prod = productionTF.getText();
            String exp = expiryTF.getText();
            String result = resultTF.getText();

            if (batch.isEmpty() || prod.isEmpty() || exp.isEmpty() || result.isEmpty()) {
                statusLabel.setText("Please fill in all fields.");
                return;
            }

            testDataList.add(new QProductTestDataMClass(batch, prod, exp, result));
            statusLabel.setText("Product test saved.");

            batchTF.clear();
            productionTF.clear();
            expiryTF.clear();
            resultTF.clear();
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
