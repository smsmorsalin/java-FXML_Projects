package group.sms;

import javafx.event.ActionEvent;
import javafx.scene.control.*;


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
    private TableColumn<advertisement, Boolean> charityTableColumn;
    @javafx.fxml.FXML
    private TableColumn<advertisement, Float> vatTableColumn;
    @javafx.fxml.FXML
    private TableColumn<advertisement, Integer> advidTableColumn;
    @javafx.fxml.FXML
    private DatePicker datePickerField;
    @javafx.fxml.FXML
    private TextField advIDTextField;
    @javafx.fxml.FXML
    private ComboBox<String> searchAdvType;
    @javafx.fxml.FXML
    private CheckBox charityCheckBox;


    ArrayList<advertisement> advList = new ArrayList<advertisement>();

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void addNewAdButton(ActionEvent actionEvent) {
        advList.add(
                new advertisement(
        //int advId, int clientId, String advType, float billAmount,
        //float vatPercentage, boolean isForCharity, LocalDate deliveryDate
                        Integer.parseInt(advIDTextField.getText()),
                        Integer.parseInt(clienIDTextField.getText()),
                        adTypefield.getValue(),
                        Integer.parseInt(billidTextField.getText()),
                        Float.parseFloat(VatidTextField.getText()),
                        charityCheckBox.isSelected(),
                        LocalDate.now()
                )

        );

        System.out.println("add new button pressed");

    }


    @javafx.fxml.FXML
    public void FilterLoadAdButton(ActionEvent actionEvent) {
        for  (advertisement adv : advList) {
            System.out.println(adv.toString());
        }

        System.out.println("Filter Load Button pressed");
    }

    @javafx.fxml.FXML
    public void charityAddButton(ActionEvent actionEvent) {
    }
}