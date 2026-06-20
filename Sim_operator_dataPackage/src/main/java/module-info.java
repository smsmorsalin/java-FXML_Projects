module group.sim_operator_datapackage {
    requires javafx.controls;
    requires javafx.fxml;


    opens group.sim_operator_datapackage to javafx.fxml;
    exports group.sim_operator_datapackage;
}