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

public class QMProductionProcessController2 {


        @FXML
        private TextField feedbackTF;
        @FXML private TextField correctiveActionTF;
        @FXML private TableView<QMonitoringDataModelClass> monitoringTable;
        @FXML private TableColumn<QMonitoringDataModelClass, String> feedbackCol;
        @FXML private TableColumn<QMonitoringDataModelClass, String> correctiveCol;
        @FXML private Label statusLabel;

        private ObservableList<QMonitoringDataModelClass> monitoringList = FXCollections.observableArrayList();

        @FXML
        public void initialize() {
            feedbackCol.setCellValueFactory(data -> data.getValue().feedbackProperty());
            correctiveCol.setCellValueFactory(data -> data.getValue().correctiveProperty());

            monitoringTable.setItems(monitoringList);
        }

        @FXML
        public void saveMonitoringOnAction() {
            String feedback = feedbackTF.getText();
            String corrective = correctiveActionTF.getText();

            if (feedback.isEmpty() || corrective.isEmpty()) {
                statusLabel.setText("Please fill all fields.");
                return;
            }

            monitoringList.add(new QMonitoringDataModelClass(feedback, corrective));
            statusLabel.setText("Monitoring data saved.");

            feedbackTF.clear();
            correctiveActionTF.clear();
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
    public void backonAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("QualityControlOfficerDashboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}