package com.example.maricobd.Tirtho.FinancialExec;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.awt.event.ActionEvent;

public class CompetitorBenchmarking {
    @FXML
    private ComboBox<String> metricBox;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private Button ExportButton;

    @FXML
    private PieChart pieChart;

    @FXML
    private TextArea TextArea;

    private final String[] companies = {
            "Marico", "Unilever", "Johnson & Johnson", "Abul Khair", "Hamdard"
    };

    @FXML
    public void initialize() {
        // Initialize ComboBox with metric options
        metricBox.setItems(FXCollections.observableArrayList(
                "Revenue", "Profit Margin", "Pricing"
        ));
        metricBox.setValue("Revenue"); // Default selection

        // Set PieChart data
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
                new PieChart.Data("Marico", 25),
                new PieChart.Data("Unilever", 40),
                new PieChart.Data("Johnson & Johnson", 15),
                new PieChart.Data("Abul Khair", 10),
                new PieChart.Data("Hamdard", 10)
        );
        pieChart.setData(pieData);
        pieChart.setTitle("Market Share Distribution");

        // Set listener for ComboBox selection
        metricBox.setOnAction(e -> onMetricSelected());

        // Load default data into BarChart
        onMetricSelected();
    }

    @FXML
    public void onMetricSelected() {
        String selected = metricBox.getValue();
        if (selected == null) return;

        barChart.getData().clear();
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName(selected);

        switch (selected) {
            case "Revenue" -> series.getData().addAll(
                    new XYChart.Data<>("Marico", 800),
                    new XYChart.Data<>("Unilever", 1500),
                    new XYChart.Data<>("Johnson & Johnson", 1200),
                    new XYChart.Data<>("Abul Khair", 700),
                    new XYChart.Data<>("Hamdard", 500)
            );
            case "Profit Margin" -> series.getData().addAll(
                    new XYChart.Data<>("Marico", 18),
                    new XYChart.Data<>("Unilever", 20),
                    new XYChart.Data<>("Johnson & Johnson", 25),
                    new XYChart.Data<>("Abul Khair", 15),
                    new XYChart.Data<>("Hamdard", 10)
            );
            case "Pricing" -> series.getData().addAll(
                    new XYChart.Data<>("Marico", 90),
                    new XYChart.Data<>("Unilever", 100),
                    new XYChart.Data<>("Johnson & Johnson", 120),
                    new XYChart.Data<>("Abul Khair", 85),
                    new XYChart.Data<>("Hamdard", 70)
            );
        }

        barChart.getData().add(series);
    }

    @FXML
    public void onActionButtonClick(javafx.event.ActionEvent actionEvent) {
        String notes = TextArea.getText().trim();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Export Summary");
        alert.setHeaderText("Export Successful!");

        if (!notes.isEmpty()) {
            alert.setContentText("Analysis/Notes:\n\n" + notes);
        } else {
            alert.setContentText("Exported successfully. No additional notes were provided.");
        }

        alert.showAndWait();
    }
}
