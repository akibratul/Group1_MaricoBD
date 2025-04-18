package com.example.maricobd.Tirtho.MarketingAnal;

import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class CampaignPerformance implements Initializable {
    @javafx.fxml.FXML
    private LineChart chartline;


    @javafx.fxml.FXML
    private CategoryAxis xAxis;
    @javafx.fxml.FXML
    private NumberAxis yaxis;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        XYChart.Series<String, Integer> seriesHigh = new XYChart.Series<>();
        seriesHigh.setName("Net Revenue");
        seriesHigh.getData().add(new XYChart.Data<>("Jan", -60));
        seriesHigh.getData().add(new XYChart.Data<>("Feb", -50));
        seriesHigh.getData().add(new XYChart.Data<>("Mar", -40));
        seriesHigh.getData().add(new XYChart.Data<>("Apr", -30));
        seriesHigh.getData().add(new XYChart.Data<>("May", -20));
        seriesHigh.getData().add(new XYChart.Data<>("Jun", -10));
        seriesHigh.getData().add(new XYChart.Data<>("Jul", 0));
        seriesHigh.getData().add(new XYChart.Data<>("Aug", 10));
        seriesHigh.getData().add(new XYChart.Data<>("Sep", 20));
        seriesHigh.getData().add(new XYChart.Data<>("Oct", 40));
        seriesHigh.getData().add(new XYChart.Data<>("Dec", 60));

        XYChart.Series<String, Integer> serieslOW = new XYChart.Series<>();
        serieslOW.setName("Break Even Point");
        serieslOW.getData().add(new XYChart.Data<>("Jul", 0));


        chartline.getData().addAll(seriesHigh, serieslOW);
    }
}
