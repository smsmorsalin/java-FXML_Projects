module group.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens group.calculator to javafx.fxml;
    exports group.calculator;
}