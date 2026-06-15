package group.sms;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


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


    ArrayList<advertisement> advList;

    @javafx.fxml.FXML
    public void initialize() {
        advList = new ArrayList<advertisement>();

        adTypefield.getItems().addAll("print", "video", "audio", "billBoard");
        searchAdvType.getItems().addAll("print", "video", "audio", "billBoard");

        advidTableColumn.setCellValueFactory(new PropertyValueFactory<advertisement, Integer>("advId"));
        clientidTableColumn.setCellValueFactory(new PropertyValueFactory<advertisement, Integer>("clientId"));
        advtypeTableColumn.setCellValueFactory(new PropertyValueFactory<advertisement,String>("advType"));
        billTableColumn.setCellValueFactory(new PropertyValueFactory<advertisement, Float>("billAmount"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<advertisement, LocalDate>("deliveryDate"));
        vatTableColumn.setCellValueFactory(new PropertyValueFactory<advertisement, Float>("vatPercentage"));




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

        advIDTextField.clear();
        clienIDTextField.clear();
        VatidTextField.clear();
        billidTextField.clear();
        charityCheckBox.setSelected(false);
        datePickerField.setValue(LocalDate.now());

        System.out.println("add new button pressed");

    }


    @javafx.fxml.FXML
    public void FilterLoadAdButton(ActionEvent actionEvent) {
        advTable.getItems().clear();
        for  (advertisement ad : advList) {
            if ( (Integer.parseInt(searchClientid.getText()) == ad.getClientId()) && searchAdvType.getValue().equals(ad.getAdvType())) {
            advTable.getItems().add(ad);
            }

//            System.out.println(ad.toString());
        }

        System.out.println("Filter Load Button pressed");
    }

    @javafx.fxml.FXML
    public void charityAddButton(ActionEvent actionEvent) {
        int count = 0;
        for  (advertisement adv : advList) {
            if( (adv.getAdvId() == Integer.parseInt(searchClientid.getText())) &&  searchAdvType.getValue().equals(adv.getAdvType())) {
                if( adv.isForCharity() ) {
                    count++;
                }
            }
        }
        charityCountLabel.setText("Count for charity: " + count);
    }
}