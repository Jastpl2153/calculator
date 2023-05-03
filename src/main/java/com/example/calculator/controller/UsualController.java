package com.example.calculator.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class UsualController {
    @FXML
    private Label output;
    private long num;
    private String operation = "";
    private boolean start = true;

    @FXML
    private void processNumPad (ActionEvent event){
        if (start) {
            output.setText("");
            start = false;
        }
        String value = ((Button) event.getSource()).getText();
        output.setText(output.getText() + value);
    }

    @FXML
    private void processOperation (ActionEvent event){
        if (output.getText().equals("ERROR")){
            return;
        }
        String value = ((Button) event.getSource()).getText();
        if (!value.equals("=")){
            if (!operation.isEmpty()){
                return;
            }
            operation = value;
            num = Long.parseLong(output.getText());
            output.setText("");
        }
        else {
            if (operation.isEmpty()){
                return;
            }
            if (output.getText().isEmpty()){
                output.setText("ERROR");
                operation = "";
                start = true;
                return;
            }
            output.setText(calculate(num, Long.parseLong(output.getText()), operation)) ;
            operation = "";
            start = true;
        }
    }

    @FXML
    private void cleanOutput (ActionEvent event){
        output.setText("0");
        start = true;
        operation = "";
    }

    private String calculate(long num1, long num2, String op) {
        if (op.equals("+")) {
            return String.valueOf(num1 + num2);
        } else if (op.equals("-")) {
            return String.valueOf(num1 - num2);
        } else if (op.equals("×")) {
            return String.valueOf(num1 * num2);
        } else if (op.equals("÷")) {
            if (num2 == 0) {
                return "ERROR";
            }
            return String.valueOf(num1 / num2);
        } else {
            return "ERROR";
        }
    }
}
