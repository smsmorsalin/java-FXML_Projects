module group.midterm_mock_4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens group.midterm_mock_4 to javafx.fxml;
    exports group.midterm_mock_4;
}