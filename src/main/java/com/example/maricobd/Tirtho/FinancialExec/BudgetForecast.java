package com.example.maricobd.Tirtho.FinancialExec;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.scene.control.*;

import java.awt.event.ActionEvent;

public class BudgetForecast {
    @javafx.fxml.FXML
    private TextField marketingTextField;
    @javafx.fxml.FXML
    private NumberAxis yAxis;
    @javafx.fxml.FXML
    private CategoryAxis xAxis;
    @javafx.fxml.FXML
    private TextField RDTextField;
    @javafx.fxml.FXML
    private TextField salesTextField;
    @javafx.fxml.FXML
    private TextField itTextField;
    @javafx.fxml.FXML
    private LineChart<String, Number> linechart;
    @FXML
    private Button setButton;

    @FXML
    public void initialize() {
        // Populate the line chart with dummy data
        XYChart.Series<String, Number> revenueSeries = new XYChart.Series<>();
        revenueSeries.setName("Revenue");

        // Simulated past 10 years + next 2 years
        String[] years = {
                "2014", "2015", "2016", "2017", "2018",
                "2019", "2020", "2021", "2022", "2023",
                "2024*", "2025*"
        };

        double[] revenueData = {
                2.5, 3.1, 3.8, 4.0, 4.7,
                5.0, 5.5, 6.1, 6.8, 7.4,
                8.0, 8.6
        };

        for (int i = 0; i < years.length; i++) {
            revenueSeries.getData().add(new XYChart.Data<>(years[i], revenueData[i]));
        }

        linechart.getData().add(revenueSeries);
    }

    @FXML
    public void onActionButtonClick(javafx.event.ActionEvent actionEvent) {
        try {
            double it = Double.parseDouble(itTextField.getText());
            double sales = Double.parseDouble(salesTextField.getText());
            double pr = Double.parseDouble(RDTextField.getText());
            double marketing = Double.parseDouble(marketingTextField.getText());

            // Check for non-negative
            if (it < 0 || sales < 0 || pr < 0 || marketing < 0) {
                showError("All values must be non-negative.");
                return;
            }

            // Show budget summary
            String msg = String.format(
                    "IT: %.2f%%\nSales: %.2f%%\nPR: %.2f%%\nMarketing: %.2f%%",
                    it, sales, pr, marketing
            );

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Budget Allocation");
            alert.setHeaderText("Budget Allocation");
            alert.setContentText(msg);
            alert.showAndWait();

        } catch (NumberFormatException e) {
            showError("Please enter valid numeric values in all fields.");
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Input");
        alert.setHeaderText("Input Error");
        alert.setContentText(message);
        alert.showAndWait();
    }

    }

