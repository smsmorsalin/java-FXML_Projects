package group.calculator;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Calculator_Controller
{
    @javafx.fxml.FXML
    private TextField CalculatorInputField1;
    @javafx.fxml.FXML
    private Label CalculatorResult;
    @javafx.fxml.FXML
    private TextField CalculatorInputField2;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void CalculatorMulButton(ActionEvent actionEvent) {
        int num1 = Integer.parseInt(CalculatorInputField1.getText());
        int num2 = Integer.parseInt(CalculatorInputField2.getText());
        int result = num1 * num2;
        CalculatorResult.setText(String.valueOf(result));
    }

    @javafx.fxml.FXML
    public void CalculatorAddButton(ActionEvent actionEvent) {
        int num1 = Integer.parseInt(CalculatorInputField1.getText());
        int num2 = Integer.parseInt(CalculatorInputField2.getText());
        int result = num1 + num2;
        CalculatorResult.setText(String.valueOf(result));
    }

    @javafx.fxml.FXML
    public void CalculatorDivButton(ActionEvent actionEvent) {
        int num1 = Integer.parseInt(CalculatorInputField1.getText());
        int num2 = Integer.parseInt(CalculatorInputField2.getText());
        int result = num1 / num2;
        CalculatorResult.setText(String.valueOf(result));
    }

    @javafx.fxml.FXML
    public void CalculatorSubButton(ActionEvent actionEvent) {
        int num1 = Integer.parseInt(CalculatorInputField1.getText());
        int num2 = Integer.parseInt(CalculatorInputField2.getText());
        int result = num1 - num2;
        CalculatorResult.setText(String.valueOf(result));
    }
}