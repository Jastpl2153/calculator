package com.example.calculator.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class UsualController {
    @FXML
    private VBox window;
    @FXML
    private Button colorStyle;
    @FXML
    private Label info;
    @FXML
    private Label output;
    private double num;
    private String operation = "";
    private boolean start = true;

    @FXML
    void style(ActionEvent event) {
        if (window.getStyle().equals("-fx-background-color: #111111;")) {
            window.setStyle("-fx-background-color: white;");
            colorStyle.setStyle("-fx-background-color: #111111; -fx-text-fill: white; -fx-background-radius: 50");
            output.setStyle("-fx-text-fill: #111111;");
            info.setStyle("-fx-text-fill: #111111;");
        } else {
            window.setStyle("-fx-background-color: #111111;");
            colorStyle.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-background-radius: 50");
            output.setStyle("-fx-text-fill: white; ");
            info.setStyle("-fx-text-fill: white; ");
        }
    }
    
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
            info.setText(output.getText() + operation);
            num = Double.parseDouble(output.getText());
            output.setText("");
        }
        else {
            if (operation.isEmpty() || output.getText().isEmpty() || output.getText().equals(".")) {
                output.setText("ERROR");
                operation = "";
            } else {
                info.setText(info.getText() + output.getText());
                String result = calculate(num, Double.parseDouble(output.getText()), operation);
                rounding(result);
                operation = "";
                start = true;
            }
        }
    }

    @FXML
    private void cleanOutput (ActionEvent event){
        output.setText("");
        info.setText("");
        start = true;
        operation = "";
    }

    public String calculate(double num1, double num2, String op) {
        switch (op) {
            case "+" -> {
                return String.valueOf(num1 + num2);
            }
            case "-" -> {
                return String.valueOf(num1 - num2);
            }
            case "×" -> {
                return String.valueOf(num1 * num2);
            }
            case "÷" -> {
                if (num2 == 0) {
                    return "ERROR";
                }
                return String.valueOf(num1 / num2);
            }
            case "%" -> {
                return String.valueOf(num1 * num2 / 100);
            }
            default -> {
                return "ERROR";
            }
        }
    }

    private void rounding(String num) {
        String regex = ".*\\.0+";
        if (num.matches(regex)){
            long result = (long) Double.parseDouble(num);
            output.setText(String.valueOf(result));
        } else {
            output.setText(num);
        }
    }

    @FXML
    private void processAbc (ActionEvent event) {
        double num = Double.parseDouble(output.getText());
        if (num > 0) {
            num = -Math.abs(num);
            rounding(String.valueOf(num));
        } else {
            num = Math.abs(num);
            rounding(String.valueOf(num));
        }
    }

    public Label getOutput() {
        return output;
    }

    public void setOutput(Label output) {
        this.output = output;
    }
}
