package com.example.maricobd.Tirtho.MarketingAnal;


import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CustomerSegmentation {

    @FXML private ListView<String> listView;
    @FXML private TableView<Customer> custTable;
    @FXML private TableColumn<Customer, String> custNameColm;
    @FXML private TableColumn<Customer, String> orderColm;
    @FXML private TableColumn<Customer, String> avgCartValColm;
    @FXML private TableColumn<Customer, String> lastPurColm;

    public static class Customer {
        private final SimpleStringProperty name;
        private final SimpleStringProperty orders;
        private final SimpleStringProperty avgCartValue;
        private final SimpleStringProperty lastPurchase;

        public Customer(String name, String orders, String avgCartValue, String lastPurchase) {
            this.name = new SimpleStringProperty(name);
            this.orders = new SimpleStringProperty(orders);
            this.avgCartValue = new SimpleStringProperty(avgCartValue);
            this.lastPurchase = new SimpleStringProperty(lastPurchase);
        }

        public String getName() { return name.get(); }
        public String getOrders() { return orders.get(); }
        public String getAvgCartValue() { return avgCartValue.get(); }
        public String getLastPurchase() { return lastPurchase.get(); }
    }

    @FXML
    public void initialize() {
        listView.getItems().addAll(
                "High-value customers",
                "Frequent buyers",
                "First-time visitors",
                "Abandoned cart users"
        );

        custNameColm.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
        orderColm.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getOrders()));
        avgCartValColm.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAvgCartValue()));
        lastPurColm.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLastPurchase()));

        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, selectedSegment) -> {
            if (selectedSegment != null) {
                custTable.setItems(getCustomerData(selectedSegment));
            }
        });
    }

    private ObservableList<Customer> getCustomerData(String segment) {
        return switch (segment) {
            case "High-value customers" -> FXCollections.observableArrayList(
                    new Customer("Alice", "15", "$320", "2025-04-15"),
                    new Customer("David", "10", "$290", "2025-04-12")
            );
            case "Frequent buyers" -> FXCollections.observableArrayList(
                    new Customer("Bob", "25", "$90", "2025-04-16"),
                    new Customer("Eva", "22", "$85", "2025-04-14")
            );
            case "First-time visitors" -> FXCollections.observableArrayList(
                    new Customer("Charlie", "1", "$60", "2025-04-17"),
                    new Customer("Sophie", "1", "$75", "2025-04-17")
            );
            case "Abandoned cart users" -> FXCollections.observableArrayList(
                    new Customer("Tom", "0", "$0", "N/A"),
                    new Customer("Lucy", "0", "$0", "N/A")
            );
            default -> FXCollections.observableArrayList();
        };
    }
}
