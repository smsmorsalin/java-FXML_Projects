module group.sms {
    requires javafx.controls;
    requires javafx.fxml;


    opens group.sms to javafx.fxml;
    exports group.sms;
}