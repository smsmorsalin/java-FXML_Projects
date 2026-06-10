module group.sms {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens group.sms to javafx.fxml;
    exports group.sms;
}