package com.example.maricobd.Tirtho.MarketingAnal;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;

public class ProductPerformance {
    @javafx.fxml.FXML
    private ComboBox<String> metricBox;
    @javafx.fxml.FXML
    private NumberAxis score;
    @javafx.fxml.FXML
    private BarChart<String, Number> barChart;

    private final String[] products = {"Facewash", "Hair Oil", "Perfume", "Lotion", "Soap"};
    private final double[] profitMargins = {25.0, 18.5, 35.0, 22.0, 15.0};
    private final double[] satisfactionScores = {4.2, 4.5, 3.8, 4.0, 4.7};

    @javafx.fxml.FXML
    public void initialize() {
        metricBox.setItems(FXCollections.observableArrayList("Profit Margin", "Customer Satisfaction"));
        metricBox.setValue("Profit Margin");

        // Set bar chart title and disable legend
        barChart.setTitle("Product Metrics");
        barChart.setLegendVisible(false);

        updateChart("Profit Margin");

        metricBox.setOnAction(e -> updateChart(metricBox.getValue()));
    }

    private void updateChart(String metric) {
        barChart.getData().clear();
        XYChart.Series<String, Number> series = new XYChart.Series<>();

        if (metric.equals("Profit Margin")) {
            barChart.getYAxis().setLabel("Profit (%)");
            for (int i = 0; i < products.length; i++) {
                series.getData().add(new XYChart.Data<>(products[i], profitMargins[i]));
            }
        } else {
            barChart.getYAxis().setLabel("Satisfaction (1–5)");
            for (int i = 0; i < products.length; i++) {
                series.getData().add(new XYChart.Data<>(products[i], satisfactionScores[i]));
            }
        }

        barChart.getData().add(series);
    }
}