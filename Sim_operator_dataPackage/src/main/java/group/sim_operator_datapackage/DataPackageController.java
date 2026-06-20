package group.sim_operator_datapackage;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class DataPackageController
{
    @javafx.fxml.FXML
    private Label Fxid_MessageDisplay;
    @javafx.fxml.FXML
    private ComboBox<String> fxid_FilterValidityComboBox;
    @javafx.fxml.FXML
    private TextField fxid_DataAmountField;
    @javafx.fxml.FXML
    private TextField fxid_PackageNameField;
    @javafx.fxml.FXML
    private TextField fxid_PackageNamePrice;
    @javafx.fxml.FXML
    private TableView<DataPackage> Fxid_TableView;
    @javafx.fxml.FXML
    private ComboBox<String> fxid_PriceAvailabilityComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> fxid_ValidityComboBox;
    @javafx.fxml.FXML
    private TableColumn<DataPackage, Float> Fxid_TableColDataAmount;
    @javafx.fxml.FXML
    private TableColumn<DataPackage, String> fxid_TableColPackageName;
    @javafx.fxml.FXML
    private TableColumn<DataPackage, String> Fxid_tableColValidity;
    @javafx.fxml.FXML
    private TableColumn<DataPackage, Integer> Fxid_TableColPrice;
    @javafx.fxml.FXML
    private Label Fxid_BestPackageLabel;

    ArrayList<DataPackage> DataStorage;
    @javafx.fxml.FXML
    private TextField fxid_FilterPrice;

    @javafx.fxml.FXML
    public void initialize() {
        DataStorage = new ArrayList<DataPackage>();

        fxid_ValidityComboBox.getItems().addAll("3 days", "7 days", "15 days", "30 days", "Unlimited");
        fxid_FilterValidityComboBox.getItems().addAll("3 days", "7 days", "15 days", "30 days", "Unlimited");
        fxid_PriceAvailabilityComboBox.getItems().addAll("app only", "recharge Only", "app and recharge");

        Fxid_TableColDataAmount.setCellValueFactory(new PropertyValueFactory<DataPackage, Float>("Data_amount"));
        Fxid_TableColPrice.setCellValueFactory(new PropertyValueFactory<DataPackage, Integer>("price"));
        Fxid_tableColValidity.setCellValueFactory(new PropertyValueFactory<DataPackage, String>("validity"));
        fxid_TableColPackageName.setCellValueFactory(new PropertyValueFactory<DataPackage, String>("Package_name"));
    }
    public int Calculate_OfferEndDate(String Vailidity){
        if (Vailidity.equals("3 days")){
            return 3;
        }
        else if (Vailidity.equals("7 days")){
            return 7;
        }
        else if (Vailidity.equals("15 days")){
            return 15;
        }
        else if (Vailidity.equals("30 days")){
            return 30;
        }
        else if (Vailidity.equals("Unlimited")){
            return 2000;
        }
        return 0;
    }

    @javafx.fxml.FXML
    public void RestButton(ActionEvent actionEvent) {
        Fxid_TableView.getItems().clear();
    }

    @javafx.fxml.FXML
    public void CreatePackageButton(ActionEvent actionEvent) {
        if (fxid_PackageNameField.getText().isEmpty() || fxid_PackageNamePrice.getText().isEmpty() || fxid_DataAmountField.getText().isEmpty() || fxid_ValidityComboBox.getValue().isEmpty() || fxid_PriceAvailabilityComboBox.getValue().isEmpty()){
            Fxid_MessageDisplay.setText("Please fill all the fields");
            return;
        }
        for (DataPackage data: DataStorage) {
            if (fxid_PackageNameField.getText().equals( data.getPackage_name())){
                fxid_PackageNameField.clear();
                Fxid_MessageDisplay.setText("Package Name Already Exists");
                return;
            }
        }

        int extender = Calculate_OfferEndDate(fxid_ValidityComboBox.getValue());
        LocalDate date = LocalDate.now();
        date = date.plusDays(extender);


        DataStorage.add(new DataPackage(
                fxid_PackageNameField.getText(), Float.parseFloat(fxid_DataAmountField.getText()), Integer.parseInt(fxid_PackageNamePrice.getText()), fxid_ValidityComboBox.getValue(), fxid_PriceAvailabilityComboBox.getValue(), date)
        );

        Fxid_MessageDisplay.setText("Package Created");

        fxid_PackageNamePrice.clear();
        fxid_DataAmountField.clear();
        fxid_PackageNameField.clear();
        fxid_ValidityComboBox.setValue(null);
        fxid_PriceAvailabilityComboBox.setValue(null);
    }

    @javafx.fxml.FXML
    public void FilterButton(ActionEvent actionEvent) {
        Fxid_TableView.getItems().clear();
        for (DataPackage data: DataStorage) {
            if(((Integer.parseInt(fxid_FilterPrice.getText())) >= data.getPrice()) && (fxid_FilterValidityComboBox.getValue().equals(data.getValidity()))){
                Fxid_TableView.getItems().add(data);
            }
        }

    }

    @javafx.fxml.FXML
    public void FindBestValuePackageButton(ActionEvent actionEvent) {
        int flag = Fxid_TableView.getItems().get(0).getPrice();
        String packagename = Fxid_TableView.getItems().get(0).getPackage_name();
        for (DataPackage data: Fxid_TableView.getItems()){
            if (flag > data.getPrice()){
                flag = data.getPrice();
                packagename = data.getPackage_name();
            }
        }
        Fxid_BestPackageLabel.setText("Best Package Name: " + packagename);

    }
}