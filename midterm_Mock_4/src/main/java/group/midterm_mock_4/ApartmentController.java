package group.midterm_mock_4;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class ApartmentController
{
    @javafx.fxml.FXML
    private TextField TF_totalPrice;
    @javafx.fxml.FXML
    private TextField TF_aptNo;
    @javafx.fxml.FXML
    private TableColumn<Apartment, Boolean> TC_isForOffice;
    @javafx.fxml.FXML
    private TableView<Apartment> tableView;
    @javafx.fxml.FXML
    private CheckBox TF_checkBoxIsForOffice;
    @javafx.fxml.FXML
    private TableColumn<Apartment, Float> TC_totalPrice;
    @javafx.fxml.FXML
    private TextField TF_address;
    @javafx.fxml.FXML
    private TextField TF_sqFeet;
    @javafx.fxml.FXML
    private TableColumn<Apartment, Float> TC_sqFeet;
    @javafx.fxml.FXML
    private TextField TF_maintanceFee;
    @javafx.fxml.FXML
    private TableColumn<Apartment, String> TC_aptType;
    @javafx.fxml.FXML
    private ComboBox<String> TF_ComboBoxaptType;
    @javafx.fxml.FXML
    private TableColumn<Apartment, String> TC_aptNo;
    @javafx.fxml.FXML
    private Label Label_avg;
    @javafx.fxml.FXML
    private ComboBox<String> FT_apType;
    @javafx.fxml.FXML
    private CheckBox FT_isForOffice;

    ArrayList<Apartment> AptList;


    @javafx.fxml.FXML
    public void initialize() {
        AptList = new ArrayList<Apartment>();


        TF_ComboBoxaptType.getItems().addAll("1BHK", "2BHk","3BHK", "DUPLEX");
        FT_apType.getItems().addAll("1BHK", "2BHk","3BHK", "DUPLEX");

        TC_aptNo.setCellValueFactory(new PropertyValueFactory<Apartment, String>("aptNo"));
        TC_aptType.setCellValueFactory(new PropertyValueFactory<Apartment, String>("aptType"));
        TC_isForOffice.setCellValueFactory(new PropertyValueFactory<Apartment, Boolean>("isForOffice"));
        TC_sqFeet.setCellValueFactory(new PropertyValueFactory<Apartment, Float>("sqFeet"));
        TC_totalPrice.setCellValueFactory(new PropertyValueFactory<Apartment, Float>("totalPrice"));

    }

    @javafx.fxml.FXML
    public void Validate_Add_New_Apartment_To_ArrayList(ActionEvent actionEvent) throws InterruptedException {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        if (Float.parseFloat(TF_totalPrice.getText()) <= 0){
            a.setContentText("Please Enter total price > 0");
            a.showAndWait();
            return;
        }
        if ( (TF_ComboBoxaptType.getValue().equals("DUPLEX")) && ((Float.parseFloat(TF_sqFeet.getText())) <= 5000f)){
            a.setContentText("Please Enter SqFeet > 5000 for Duplex");
            a.showAndWait();
            return;
        }
        if ( (TF_ComboBoxaptType.getValue().equals("1BHK")) && ((Float.parseFloat(TF_totalPrice.getText())) <= 10000000f)){
            a.setContentText("Please Enter more than 1cr for 1BHK");
            a.showAndWait();
            return;
        }
        AptList.add(new Apartment(
//                String aptNo, String aptType, String address, float sqFeet,
//        boolean isForOffice, float maintenanceFee, float totalPrice
                TF_aptNo.getText(),
                TF_ComboBoxaptType.getValue(),
                TF_address.getText(),
                Float.parseFloat(TF_sqFeet.getText()),
                TF_checkBoxIsForOffice.isSelected(),
                Float.parseFloat(TF_maintanceFee.getText()),
                Float.parseFloat(TF_totalPrice.getText())
        ));
    }

    @javafx.fxml.FXML
    public void Filter_Load_Table(ActionEvent actionEvent) {
        tableView.getItems().clear();
        for (Apartment A: AptList){
            if( FT_apType.getValue().equals(A.getAptType()) && FT_isForOffice.isSelected() == A.isForOffice()){
                tableView.getItems().add(A);
        }}
    }

    @javafx.fxml.FXML
    public void ShowAvgSqFeet(ActionEvent actionEvent) {
        float sum = 0f;
        int count = 0;
        for (Apartment A: tableView.getItems()){
            sum += A.getSqFeet();
            count++;
        }
        Label_avg.setText("Avg" + sum/count);
    }
}