package com.example.maricobd.Tirtho.MarketingAnal;

import javafx.collections.FXCollections;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;

public class WebAnal {
    @javafx.fxml.FXML
    private LineChart<String, Number> lineChart;
    @javafx.fxml.FXML
    private ComboBox rangeBox;
    @javafx.fxml.FXML
    private NumberAxis yAxis;
    @javafx.fxml.FXML
    private CategoryAxis xAxis;

    @javafx.fxml.FXML
    public void initialize() {
        rangeBox.setItems(FXCollections.observableArrayList("Daily", "Weekly", "Monthly", "Yearly"));
        rangeBox.setValue("Daily");

        lineChart.setTitle("Active Users Over Time");
        lineChart.setLegendVisible(false);
        lineChart.setCreateSymbols(true); // show data points

        rangeBox.setOnAction(e -> updateChart(rangeBox.getValue().toString()));
        updateChart("Daily");
    }

    private void updateChart(String range) {
        lineChart.getData().clear();
        XYChart.Series<String, Number> series = new XYChart.Series<>();

        String[] xLabels;
        int[] yValues;

        switch (range) {
            case "Daily" -> {
                xLabels = generateHours();
                yValues = generateRandomValues(24, 50, 500);
                xAxis.setLabel("Hour");
            }
            case "Weekly" -> {
                xLabels = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
                yValues = generateRandomValues(7, 100, 1000);
                xAxis.setLabel("Day");
            }
            case "Monthly" -> {
                xLabels = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
                yValues = generateRandomValues(12, 500, 3000);
                xAxis.setLabel("Month");
            }
            case "Yearly" -> {
                xLabels = generateYears(2010, 2025);
                yValues = generateRandomValues(xLabels.length, 1000, 8000);
                xAxis.setLabel("Year");
            }
            default -> {
                xLabels = new String[]{};
                yValues = new int[]{};
            }
        }

        for (int i = 0; i < xLabels.length; i++) {
            series.getData().add(new XYChart.Data<>(xLabels[i], yValues[i]));
        }

        lineChart.getData().add(series);
    }

    private String[] generateHours() {
        String[] hours = new String[24];
        for (int i = 0; i < 24; i++) {
            hours[i] = String.format("%02d:00", i);
        }
        return hours;
    }

    private String[] generateYears(int start, int end) {
        int length = end - start + 1;
        String[] years = new String[length];
        for (int i = 0; i < length; i++) {
            years[i] = String.valueOf(start + i);
        }
        return years;
    }

    private int[] generateRandomValues(int size, int min, int max) {
        int[] values = new int[size];
        for (int i = 0; i < size; i++) {
            values[i] = (int) (Math.random() * (max - min + 1)) + min;
        }
        return values;
    }


}

