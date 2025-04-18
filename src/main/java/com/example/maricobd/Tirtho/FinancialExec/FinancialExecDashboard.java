package com.example.maricobd.Tirtho.FinancialExec;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FinancialExecDashboard {
    @javafx.fxml.FXML
    private Button CompetitorBenchmarkingButton;
    @javafx.fxml.FXML
    private Button ValidatePaymentsButton;
    @javafx.fxml.FXML
    private Button GenerateFinancialReportsButton;
    @javafx.fxml.FXML
    private Button TrackROIButton;
    @javafx.fxml.FXML
    private Button RegulatoryComplianceCheckButton;
    @javafx.fxml.FXML
    private Button MonitorPricingDiscountsButton;
    @javafx.fxml.FXML
    private Button BudgetForecastingButton;

    @javafx.fxml.FXML
    private void handleNavigation(ActionEvent event, String fxmlFile) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void onCompetitorBenchmarkingButtonClick(ActionEvent event) {
        handleNavigation(event, "/com/example/maricobd/Tirtho/FinancialExec/CompetitorBenchmarking.fxml");
    }

    @FXML
    private void onValidatePaymentsButtonClick(ActionEvent event) {
        handleNavigation(event, "/com/example/maricobd/Tirtho/FinancialExec/ValidatePayments.fxml");
    }

    @FXML
    private void onGenerateFinancialReportsButtonClick(ActionEvent event) {
        handleNavigation(event, "/com/example/maricobd/Tirtho/FinancialExec/GenerateFinancialReports.fxml");
    }

    @FXML
    private void onTrackROIButtonClick(ActionEvent event) {
        handleNavigation(event, "/com/example/maricobd/Tirtho/FinancialExec/TrackROI.fxml");
    }

    @FXML
    private void onRegulatoryComplianceCheckButtonClick(ActionEvent event) {
        handleNavigation(event, "/com/example/maricobd/Tirtho/FinancialExec/RegulatoryComplianceCheck.fxml");
    }

    @FXML
    private void onMonitorPricingDiscountsButtonClick(ActionEvent event) {
        handleNavigation(event, "/com/example/maricobd/Tirtho/FinancialExec/MonitorPricingDiscounts.fxml");
    }

    @FXML
    private void onBudgetForecastingButtonClick(ActionEvent event) {
        handleNavigation(event, "/com/example/maricobd/Tirtho/FinancialExec/BudgetForecasting.fxml");
    }
}

