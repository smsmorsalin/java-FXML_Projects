package group.sms;

import javafx.scene.control.*;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.ArrayList;

public class AdController
{
    @javafx.fxml.FXML
    private ComboBox<String> adTypefield;
    @javafx.fxml.FXML
    private TextField searchClientid;
    @javafx.fxml.FXML
    private TableColumn<advertisement, Integer> clientidTableColumn;
    @javafx.fxml.FXML
    private Label charityCountLabel;
    @javafx.fxml.FXML
    private TableColumn<advertisement, String> advtypeTableColumn;
    @javafx.fxml.FXML
    private TextField billidTextField;
    @javafx.fxml.FXML
    private TableColumn<advertisement, Float> billTableColumn;
    @javafx.fxml.FXML
    private TableColumn<advertisement, LocalDate> dateTableColumn;
    @javafx.fxml.FXML
    private TextField clienIDTextField;
    @javafx.fxml.FXML
    private TextField VatidTextField;
    @javafx.fxml.FXML
    private TableView<advertisement> advTable;
    @javafx.fxml.FXML
    private TableColumn charityTableColumn;
    @javafx.fxml.FXML
    private TableColumn vatTableColumn;
    @javafx.fxml.FXML
    private TableColumn advidTableColumn;
    @javafx.fxml.FXML
    private DatePicker datePickerField;
    @javafx.fxml.FXML
    private TextField advIDTextField;
    @javafx.fxml.FXML
    private ComboBox searchAdvType;
    @javafx.fxml.FXML
    private CheckBox charityCheckBox;


    ArrayList<advertisement> advList = new ArrayList<advertisement>()

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void addNewAdButton(ActionEvent actionEvent) {
    }

    advList.add(
            new advertisement(Integer.parseInt(advIDTextField.getText()),adTypefield.getValue())
            )
    @javafx.fxml.FXML
    public void FilterLoadAdButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void charityAddButton(ActionEvent actionEvent) {
    }

    public ComboBox getSearchAdvType() {
        return searchAdvType;
    }
}