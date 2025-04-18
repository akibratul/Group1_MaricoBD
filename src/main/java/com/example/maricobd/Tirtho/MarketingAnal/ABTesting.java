package com.example.maricobd.Tirtho.MarketingAnal;

import javafx.collections.FXCollections;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class ABTesting {

    @javafx.fxml.FXML
    private NumberAxis yAxis;
    @javafx.fxml.FXML
    private CategoryAxis xAxis;

    @javafx.fxml.FXML
    private Button BackButton;
    @javafx.fxml.FXML
    private ComboBox<String> TestBox;

    @javafx.fxml.FXML
    private BarChart<String, Number> barchart;

    // Method to initialize and handle ComboBox selection
    @javafx.fxml.FXML
    public void initialize() {
        // Set ComboBox default value and items
        TestBox.setItems(FXCollections.observableArrayList(
                "ClickThroughRate (A v B)",
                "Conversion Rate (A v B)",
                "Engagement Rate (A v B)"
        ));
        TestBox.setValue("ClickThroughRate (A v B)");  // Default selection

        // Set initial BarChart data for the default selection
        updateChartData(TestBox.getValue());

        // Add listener to update chart based on ComboBox selection
        TestBox.valueProperty().addListener((obs, oldValue, newValue) -> {
            updateChartData(newValue);
        });
    }

    // Method to update the BarChart based on ComboBox selection
    private void updateChartData(String testType) {
        // Clear existing chart data
        barchart.getData().clear();

        XYChart.Series<String, Number> seriesA = new XYChart.Series<>();
        XYChart.Series<String, Number> seriesB = new XYChart.Series<>();

        switch (testType) {
            case "ClickThroughRate (A v B)":
                seriesA.setName("Version A");
                seriesA.getData().add(new XYChart.Data<>("Page 1", 50));  // Example data
                seriesA.getData().add(new XYChart.Data<>("Page 2", 70));

                seriesB.setName("Version B");
                seriesB.getData().add(new XYChart.Data<>("Page 1", 60));  // Example data
                seriesB.getData().add(new XYChart.Data<>("Page 2", 80));
                break;

            case "Conversion Rate (A v B)":
                seriesA.setName("Version A");
                seriesA.getData().add(new XYChart.Data<>("Page 1", 30));  // Example data
                seriesA.getData().add(new XYChart.Data<>("Page 2", 40));

                seriesB.setName("Version B");
                seriesB.getData().add(new XYChart.Data<>("Page 1", 50));  // Example data
                seriesB.getData().add(new XYChart.Data<>("Page 2", 60));
                break;

            case "Engagement Rate (A v B)":
                seriesA.setName("Version A");
                seriesA.getData().add(new XYChart.Data<>("Page 1", 80));  // Example data
                seriesA.getData().add(new XYChart.Data<>("Page 2", 90));

                seriesB.setName("Version B");
                seriesB.getData().add(new XYChart.Data<>("Page 1", 85));  // Example data
                seriesB.getData().add(new XYChart.Data<>("Page 2", 95));
                break;
        }

        // Add data to BarChart
        barchart.getData().addAll(seriesA, seriesB);
    }
}

