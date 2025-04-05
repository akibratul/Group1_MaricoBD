module com.example.maricobd {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.maricobd to javafx.fxml;
    exports com.example.maricobd;
}