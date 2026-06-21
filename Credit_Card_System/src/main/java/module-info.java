module com.example.credit_card_system {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.credit_card_system to javafx.fxml;
    exports com.example.credit_card_system;
}