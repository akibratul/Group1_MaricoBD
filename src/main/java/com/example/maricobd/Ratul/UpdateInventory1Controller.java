package com.example.maricobd.Ratul;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateInventory1Controller {

    @FXML
    private TableView<ProductModelClass> productTable;

    @FXML
    private TableColumn<ProductModelClass, String> categoryColumn;

    @FXML
    private TableColumn<ProductModelClass, String> brandColumn;

    @FXML
    private TableColumn<ProductModelClass, Double> priceColumn;

    @FXML
    private TableColumn<ProductModelClass, Integer> quantityColumn;

    @FXML
    private Label totalProductsLabel;

    @FXML
    private Label lowStockLabel;

    @FXML
    private Label outOfStockLabel;

    @FXML
    private Label zeroStockLabel;

    @FXML
    private Label mostStockLabel;

    // Sample data
    private ObservableList<ProductModelClass> products = FXCollections.observableArrayList();
    @FXML
    private TextField enterRestockQuantityTF;
    @FXML
    private Button handleLowStock;


    public void initialize() {
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        loadProducts();
        updateSummary();
    }

    private void loadProducts() {
        products.add(new ProductModelClass(" Hair Care", "Parachute Coconut Oil", 155.0, 10000));
        products.add(new ProductModelClass("Hair Care", "Parachute Advansed ", 150.0, 50000));
        products.add(new ProductModelClass("Hair Care", "Nihar Naturals", 100.0, 0));
        products.add(new ProductModelClass("Hair Care", "RED King Men’s Cooling Oil", 200.0, 40000));
        products.add(new ProductModelClass("Hair Care", "Livon", 180.0, 30000));
        products.add(new ProductModelClass("Skin Care", "Parachute SkinPure", .0, 50));
        products.add(new ProductModelClass("Skin Care", "Glo-On ", 90.0, 0));
        products.add(new ProductModelClass("Male Grooming", "Studio X", 100.0, 9000));
        products.add(new ProductModelClass("Baby Care", "Parachute Just for Baby", 300.0, 0));
        products.add(new ProductModelClass("Foods", "Saffola", 500.0, 8000));
        productTable.setItems(products);
    }


    private void updateSummary() {
        int total = products.size();
        long lowStock = products.stream().filter(p -> p.getQuantity() < 10 && p.getQuantity() > 0).count();
        long outOfStock = products.stream().filter(p -> p.getQuantity() == 0).count();
        long zeroStock = outOfStock; // same in this case
        ProductModelClass mostStock = products.stream().max((a, b) -> a.getQuantity() - b.getQuantity()).orElse(null);

        totalProductsLabel.setText("Total: " + total);
        lowStockLabel.setText("Low: " + lowStock);
        outOfStockLabel.setText("Out: " + outOfStock);
        zeroStockLabel.setText("Zero: " + zeroStock);
        mostStockLabel.setText("Most: " + (mostStock != null ? mostStock.getBrand() : "-"));
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Inventory Info");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void logoutoNaction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void saveChangeTF(ActionEvent actionEvent) {
        showAlert("Changes saved to database.");
    }

    @FXML
    public void outOfStockProductOnAction(ActionEvent actionEvent) {
        ObservableList<ProductModelClass> filtered = products.filtered(p -> p.getQuantity() == 0);
        productTable.setItems(filtered);
    }

    @FXML
    public void lowStockProductOnAction(ActionEvent actionEvent) {
        ObservableList<ProductModelClass> filtered = products.filtered(p -> p.getQuantity() < 10 && p.getQuantity() > 0);
        productTable.setItems(filtered);
    }

    @FXML
    public void enterRestockQuantityTF(ActionEvent actionEvent) {
    }

    @FXML
    public void UpdateStockOnAction(ActionEvent actionEvent) {
        ProductModelClass selected = productTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try {
                int addQty = Integer.parseInt(enterRestockQuantityTF.getText().trim());
                selected.setQuantity(selected.getQuantity() + addQty);
                productTable.refresh();
                updateSummary();
            } catch (NumberFormatException e) {
                showAlert("Please enter a valid number for restocking.");
            }
        } else {
            showAlert("Please select a product to update.");
        }
    }

    @FXML
    public void backonAction(ActionEvent actionEvent)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InventoryCoordinatorDashboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
