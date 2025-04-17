package com.example.maricobd.Ratul;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @javafx.fxml.FXML
    private TextField usernameTF;
    @javafx.fxml.FXML
    private ComboBox<String> selectUserCB;
    @javafx.fxml.FXML
    private PasswordField passwordPF;
    @javafx.fxml.FXML
    private Label loginErrorLabel;

    public void initialize() {
        selectUserCB.getItems().addAll("Inventory Coordinator", "Quality Control Officer");

    }

    @javafx.fxml.FXML
    public void logInOnAction(Event event) throws IOException {
        String username = usernameTF.getText();
        String password = passwordPF.getText();
        String usertype = selectUserCB.getValue();
        if (username.trim().isEmpty() || password.trim().isEmpty() || usertype == null) {
            loginErrorLabel.setText("Please select all fields");
        } else if ("ratul".equals(username.trim()) && "0000".equals(password.trim()) && "Inventory Coordinator".equals(usertype)) {
            loginErrorLabel.setText("Login Successful");
            //SceneSwitcher.switchTo("Masum/FinanceOfficerDashboard.fxml");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Masum/FinanceOfficerDashboard.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) usernameTF.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } else if ("ratul".equals(username.trim()) && "0000".equals(password.trim()) && "Quality Control Officer".equals(usertype)) {
            loginErrorLabel.setText("Login Successful");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Masum/SalesAndDistributionOfficerDashboard-view.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) usernameTF.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } else {
            loginErrorLabel.setText("Incorrect username, password, or user type. Please try again.");
        }
    }
}

