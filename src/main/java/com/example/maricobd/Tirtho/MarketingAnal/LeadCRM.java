package com.example.maricobd.Tirtho.MarketingAnal;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LeadCRM {
    // TextField fields
    @FXML
    private TextField nameField, mailField, phoneField, intrestsField;

    // ComboBox for lead status
    @FXML
    private ComboBox<String> leadBox;

    // Submit button
    @FXML
    private Button submitButton;

    // TableView and TableColumns
    @FXML
    private TableView<LeadCRM> table;
    @FXML
    private TableColumn<LeadCRM, Integer> leadNoColmn;
    @FXML
    private TableColumn<LeadCRM, String> nameColm, emailColmn, phoneColmn, intrestsColmn, leadStatusColmn, crmColm;

    // Observable list to hold lead data
    private final ObservableList<LeadCRM> leads = FXCollections.observableArrayList();

    // Lead counter to automatically increment lead numbers
    private int leadCounter = 1;

    // LeadCRM properties (No separate Lead class)
    private final SimpleIntegerProperty leadNoColmnProperty;
    private final SimpleStringProperty nameProperty, emailProperty, phoneProperty, interestProperty, statusProperty, crmStatusProperty;

    public LeadCRM() {
        this.leadNoColmnProperty = new SimpleIntegerProperty();
        this.nameProperty = new SimpleStringProperty();
        this.emailProperty = new SimpleStringProperty();
        this.phoneProperty = new SimpleStringProperty();
        this.interestProperty = new SimpleStringProperty();
        this.statusProperty = new SimpleStringProperty();
        this.crmStatusProperty = new SimpleStringProperty("Synced");
    }
    // Constructor for LeadCRM
    public LeadCRM(int leadNo, String name, String email, String phone, String interest, String status) {
        this.leadNoColmnProperty = new SimpleIntegerProperty(leadNo);
        this.nameProperty = new SimpleStringProperty(name);
        this.emailProperty = new SimpleStringProperty(email);
        this.phoneProperty = new SimpleStringProperty(phone);
        this.interestProperty = new SimpleStringProperty(interest);
        this.statusProperty = new SimpleStringProperty(status);
        this.crmStatusProperty = new SimpleStringProperty("Synced");
    }

    // Getter methods for each property
    public int getLeadNoColmn() {
        return leadNoColmnProperty.get();
    }

    public String getName() {
        return nameProperty.get();
    }

    public String getEmail() {
        return emailProperty.get();
    }

    public String getPhone() {
        return phoneProperty.get();
    }

    public String getInterest() {
        return interestProperty.get();
    }

    public String getStatus() {
        return statusProperty.get();
    }

    public String getCrmStatus() {
        return crmStatusProperty.get();
    }

    // Property access methods
    public SimpleIntegerProperty leadNoColmnProperty() {
        return leadNoColmnProperty;
    }

    public SimpleStringProperty nameProperty() {
        return nameProperty;
    }

    public SimpleStringProperty emailProperty() {
        return emailProperty;
    }

    public SimpleStringProperty phoneProperty() {
        return phoneProperty;
    }

    public SimpleStringProperty interestProperty() {
        return interestProperty;
    }

    public SimpleStringProperty statusProperty() {
        return statusProperty;
    }

    public SimpleStringProperty crmStatusProperty() {
        return crmStatusProperty;
    }

    // Initialize method to setup the ComboBox and TableView
    @FXML
    public void initialize() {
        // Set the ComboBox items and default value
        leadBox.setItems(FXCollections.observableArrayList("New", "Contacted", "Qualified", "Lost"));
        leadBox.setValue("New");

        // Setup TableView columns and bind to LeadCRM properties
        leadNoColmn.setCellValueFactory(data -> data.getValue().leadNoColmnProperty().asObject());
        nameColm.setCellValueFactory(data -> data.getValue().nameProperty());
        emailColmn.setCellValueFactory(data -> data.getValue().emailProperty());
        phoneColmn.setCellValueFactory(data -> data.getValue().phoneProperty());
        intrestsColmn.setCellValueFactory(data -> data.getValue().interestProperty());
        leadStatusColmn.setCellValueFactory(data -> data.getValue().statusProperty());
        crmColm.setCellValueFactory(data -> data.getValue().crmStatusProperty());

        // Pre-fill the table with some dummy data
        leads.add(new LeadCRM(leadCounter++, "Alice", "alice@example.com", "0123456789", "Skincare", "Contacted"));
        leads.add(new LeadCRM(leadCounter++, "Bob", "bob@mail.com", "0987654321", "Haircare", "Qualified"));
        leads.add(new LeadCRM(leadCounter++, "Charlie", "charlie@xyz.com", "01711223344", "Perfume", "New"));

        table.setItems(leads);
    }

    // Handle submit button click
    @FXML
    public void onActionButtonClick(ActionEvent actionEvent) {
        String name = nameField.getText().trim();
        String email = mailField.getText().trim();
        String phone = phoneField.getText().trim();
        String interest = intrestsField.getText().trim();
        String status = leadBox.getValue();

        // Validate phone number (10-11 digits)
        if (!phone.matches("\\d{10,11}")) {
            showAlert("Invalid phone number", "Phone number must be 10–11 digits.");
            return;
        }

        // Create a new LeadCRM entry with the incremented lead number
        LeadCRM newLead = new LeadCRM(leadCounter++, name, email, phone, interest, status);
        leads.add(newLead);

        // Clear form fields after submission
        nameField.clear();
        mailField.clear();
        phoneField.clear();
        intrestsField.clear();
        leadBox.setValue("New");
    }

    // Show an alert if the phone number is invalid
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }


    }

