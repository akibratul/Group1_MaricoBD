module com.example.maricobd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    exports com.example.maricobd.Ratul;
    opens com.example.maricobd.Ratul to javafx.fxml;
}