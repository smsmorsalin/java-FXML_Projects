package com.example.credit_card_system;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import static javafx.beans.binding.Bindings.length;

public class CreditCardController
{
    @javafx.fxml.FXML
    private TextField fxid_fieldCardNo;
    @javafx.fxml.FXML
    private TextField fxid_searchCreditLimit;
    @javafx.fxml.FXML
    private TableView<CreditCard> fxid_tableview;
    @javafx.fxml.FXML
    private ComboBox<String> fxid_fieldCardType;
    @javafx.fxml.FXML
    private DatePicker fxid_fieldDateOfExpire;
    @javafx.fxml.FXML
    private ComboBox<String> fxid_searchGatewayName;
    @javafx.fxml.FXML
    private TextField fxid_fieldHolderName;
    @javafx.fxml.FXML
    private Label fxid_labelAverageCreditLimit;
    @javafx.fxml.FXML
    private ComboBox<String> fxid_fieldGatewayName;
    @javafx.fxml.FXML
    private TableColumn<CreditCard, Integer> fxid_tableviewColCreditLimit;
    @javafx.fxml.FXML
    private TableColumn<CreditCard, String> fxid_tableviewColGatewayName;
    @javafx.fxml.FXML
    private TableColumn<CreditCard, String> fxid_tableviewColHolderName;
    @javafx.fxml.FXML
    private TextField fxid_fieldCreditLimit;
    @javafx.fxml.FXML
    private TableColumn<CreditCard, String> fxid_tableviewColCardNo;

    ArrayList<CreditCard> cardList;

    @javafx.fxml.FXML
    public void initialize() {
        cardList = new ArrayList<CreditCard>();

//        (silver/gold/platinum/titanium)
        fxid_fieldCardType.getItems().addAll("silver", "gold", "platinum", "titanium");
        fxid_fieldGatewayName.getItems().addAll("Visa", "MasterCard");
        fxid_searchGatewayName.getItems().addAll("Visa", "MasterCard");

        fxid_tableviewColCardNo.setCellValueFactory(new PropertyValueFactory<CreditCard, String>("cardNo"));
        fxid_tableviewColCreditLimit.setCellValueFactory(new PropertyValueFactory<CreditCard, Integer>("CreditLimit"));
        fxid_tableviewColGatewayName.setCellValueFactory(new PropertyValueFactory<CreditCard, String>("gatewayName"));
        fxid_tableviewColHolderName.setCellValueFactory(new PropertyValueFactory<CreditCard, String>("holderName"));

    }


    @javafx.fxml.FXML
    public void showAverageCreditLimitButtonOnClick(ActionEvent actionEvent) {
        int sum = 0;
        int count = 0;
        for (CreditCard C: fxid_tableview.getItems()){
            sum = sum + C.getCreditLimit();
            count += 1;
        }
        int avg = sum/count;

        fxid_labelAverageCreditLimit.setText("Average Credit Limit: " + avg);
    }

    @javafx.fxml.FXML
    public void SearchAndLoadButtonOnClick(ActionEvent actionEvent) {
        fxid_tableview.getItems().clear();
        for(CreditCard C: cardList){
            if ( fxid_searchGatewayName.getValue().equals(C.getGatewayName()) && Integer.parseInt(fxid_searchCreditLimit.getText()) >= C.getCreditLimit()  ){
                fxid_tableview.getItems().add(C);
            }
        }
    }

    @javafx.fxml.FXML
    public void validateAndNewCardButtonOnClick(ActionEvent actionEvent) {
        int CardNoLen = fxid_fieldCardNo.getText().length();
        char GatewayNo = '0';
        if ((fxid_fieldGatewayName.getValue().equals("visa"))){
            GatewayNo = '4';
        } else if ((fxid_fieldGatewayName.getValue().equals("MasterCard"))) {
            GatewayNo = '5';
        }
        if(CardNoLen != 16 || (fxid_fieldCardNo.getText().charAt(0) != GatewayNo) ){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("error: card number must be 16 len refering to gateway number visa = 4, mastercard = 5");
            a.showAndWait();
            return;
        }

        cardList.add(
                new CreditCard(
                        fxid_fieldCardNo.getText(),
                        fxid_fieldHolderName.getText(),
                        fxid_fieldDateOfExpire.getValue(),
                        fxid_fieldGatewayName.getValue(),
                        fxid_fieldCardType.getValue(),
                        Integer.parseInt(fxid_fieldCreditLimit.getText())
                )
        );
    }
}