package com.example.maricobd;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import java.io.IOException;

public class LoginController {

    @FXML
    private Button marketingButton;
    @FXML
    private Button financialButton;



    @FXML
    public void onMarketingButtonClick(ActionEvent actionEvent)throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com.example.maricobd.Tirtho/Marketing Analyst/MarketingAnalystDashboard.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Marketing Analyst Dashboard");
        stage.show();
    }

    @FXML
    public void onFinancialButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com.example.maricobd.Tirtho/Financial Exec/FinancialExecDashboard.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Financial Executive Dashboard");
        stage.show();
    }

}