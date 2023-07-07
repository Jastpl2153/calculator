package com.example.calculator.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class NumberSystem extends UsualController implements Initializable {
    @FXML
    private ToggleButton bin;

    @FXML
    private ToggleButton dec;

    @FXML
    private ToggleButton hex;

    @FXML
    private ToggleButton oct;

    @FXML
    private Label outputBin;

    @FXML
    private Label outputDec;

    @FXML
    private Label outputHex;

    @FXML
    private Label outputOct;

    @FXML
    private GridPane gridPane;

    private ToggleButton active;
    private Label output;
    String num;

    private ToggleButton[] toggleButtons = new ToggleButton[4];

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        toggleButtons[0] = hex;
        toggleButtons[1] = dec;
        toggleButtons[2] = oct;
        toggleButtons[3] = bin;
    }

    @FXML
    void buttonAction(ActionEvent event) {
        ToggleButton action = (ToggleButton) event.getSource();
        for (ToggleButton a : toggleButtons) {
            if (a == action) {
                a.setSelected(true);
                a.setDisable(true);
                action.setStyle("-fx-background-color:  F29611; -fx-background-radius: 10 0 0 10; -fx-opacity: 1;");
                active = getActionButton();
                output = getLabelOutput(active);
                setInfoAndOutput(action);
                blockingNumPad();
            } else {
                a.setSelected(false);
                a.setDisable(false);
                a.setStyle("-fx-background-color:  #ACACAC; -fx-background-radius: 10 0 0 10");
            }
        }
        if (!getOperation().isEmpty()) {
            calculateSystemNumber();
            output.setText("");
        }
    }

    @Override
    protected void processNumPad(ActionEvent event) {
        if (isStart()) {
            outputHex.setText("");
            outputDec.setText("");
            outputOct.setText("");
            outputBin.setText("");
            setStart(false);
        }
        if (trueActive()) {
            String value = ((Button) event.getSource()).getText();
            output.setText(output.getText() + value);
            calculateSystemNumber();
        }
    }

    private boolean trueActive(){
        for (ToggleButton b:toggleButtons) {
            if (b.isSelected()){
                return true;
            }
        }
        return false;
    }

    private Label getLabelOutput(ToggleButton active){
        if (active.isSelected()) {
            if (active.equals(hex)) {
                return outputHex;
            } else if (active.equals(dec)) {
                return outputDec;
            } else if (active.equals(oct)) {
                return outputOct;
            } else if (active.equals(bin)) {
                return outputBin;
            }
        }
        return null;
    }

    private ToggleButton getActionButton(){
        for (ToggleButton a : toggleButtons) {
            if (a.isSelected()){
                return a;
            }
        }
        return null;
    }

    private void calculateSystemNumber(){
        int num;
        if (bin.isSelected()) {
            String numText = outputBin.getText();
            num = Integer.parseInt(numText, 2);
            outputDec.setText(String.valueOf(num));
            outputHex.setText(Integer.toHexString(num));
            outputOct.setText(Integer.toOctalString(num));
        } else if (oct.isSelected()) {
            String numText = outputOct.getText();
            num = Integer.parseInt(numText, 8);
            outputDec.setText(String.valueOf(num));
            outputHex.setText(Integer.toHexString(num));
            outputBin.setText(Integer.toBinaryString(num));
        }
        if (dec.isSelected()) {
            num = Integer.parseInt(outputDec.getText());
            outputBin.setText(Integer.toBinaryString(num));
            outputHex.setText(Integer.toHexString(num));
            outputOct.setText(Integer.toOctalString(num));
        } else if (hex.isSelected()) {
            String numText = outputHex.getText();
            num = Integer.parseInt(numText, 16);
            outputDec.setText(String.valueOf(num));
            outputBin.setText(Integer.toBinaryString(num));
            outputOct.setText(Integer.toOctalString(num));
        }
    }
    @Override
    protected void cleanOutput(ActionEvent event) {
        outputBin.setText("");
        outputDec.setText("");
        outputHex.setText("");
        outputOct.setText("");
        getInfo().setText("");
        setOperation("");
        setStart(true);
    }
    @Override
    protected void erase(ActionEvent event) {
        if (output != null) {
            String text = output.getText();
            if (text.length() > 0) {
                text = text.substring(0, text.length() - 1);
                output.setText(text);
                if (!output.getText().isEmpty()) {
                    calculateSystemNumber();
                } else {
                    cleanOutput(event);
                }
            }
        }
    }
    private void blockingNumPad() {
        Button[] buttons = gridPane.getChildren().stream()
                .filter(node -> node instanceof Button)
                .map(node -> (Button) node)
                .toArray(Button[]::new);
        if (active == hex) {
            for (Button b : buttons) {
                    b.setDisable(false);
            }
        } else if (active == dec) {
            for (Button b : buttons) {
                if (b.getText().matches("[A-F]")){
                    b.setDisable(true);
                } else {
                    b.setDisable(false);
                }
            }
        } else if (active == oct) {
            for (Button b : buttons) {
                if (b.getText().matches("[8-9A-F]")){
                    b.setDisable(true);
                } else {
                    b.setDisable(false);
                }
            }
        } else if (active == bin) {
            for (Button b : buttons) {
                if (b.getText().matches("[2-9A-F]")){
                    b.setDisable(true);
                } else {
                    b.setDisable(false);
                }
            }
        }
    }

    @Override
    protected void processOperation(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (!value.equals("=")) {
            if (!getOperation().isEmpty()) {
                return;
            }
            setOperation(value);
            getInfo().setText(output.getText() + getOperation());
            num = output.getText();
            output.setText("");
        }
        else {
            if (getOperation().isEmpty() || output.getText().isEmpty() || output.getText().equals(".")) {
                output.setText("ERROR");
                setOperation("");
            } else {
                getInfo().setText(getInfo().getText() + output.getText());
                String result = calculateProcess(num, output.getText(), getOperation());
                output.setText(String.valueOf(result));
                calculateSystemNumber();
                setOperation("");
                getInfo().setText("");
                setStart(true);
            }
        }
    }

    private String calculateProcess(String num1, String num2, String op) {
        int operand1 = 0, operand2 = 0;
        double result;

        if (hex.isSelected()) {
            operand1 = Integer.parseInt(num1, 16);
            operand2 = Integer.parseInt(num2, 16);
        } else if (dec.isSelected()) {
            operand1 = Integer.parseInt(num1);
            operand2 = Integer.parseInt(num2);
        } else if (oct.isSelected()) {
            operand1 = Integer.parseInt(num1, 8);
            operand2 = Integer.parseInt(num2, 8);
        } else if (bin.isSelected()) {
            operand1 = Integer.parseInt(num1, 2);
            operand2 = Integer.parseInt(num2, 2);
        }

        result = Double.parseDouble(calculate(operand1, operand2, op));

        if (hex.isSelected()) {
            return Integer.toHexString((int) result);
        } else if (dec.isSelected()) {
            return String.valueOf((int) result);
        } else if (oct.isSelected()) {
            return Integer.toOctalString((int) result);
        } else if (bin.isSelected()) {
            return Integer.toBinaryString((int) result);
        }
        return null;
    }

    private void setInfoAndOutput(ToggleButton active) {
        if (!getInfo().getText().isEmpty()) {
            getInfo().setText(output.getText() + getOperation());
            setNum();
        }
    }

    public void setNum() {
        this.num = getInfo().getText().replaceAll("[^0-9a-f]", "");
    }

    @Override
    void style(ActionEvent event) {
        String backgroundColor;
        String textColor;

        if (getWindow().getStyle().equals("-fx-background-color: #111111;")) {
            backgroundColor = "white";
            textColor = "#111111";
        } else {
            backgroundColor = "#111111";
            textColor = "white";
        }

        getWindow().setStyle("-fx-background-color: " + backgroundColor + ";");
        getColorStyle().setStyle("-fx-background-color: " + textColor + "; -fx-text-fill: " + backgroundColor + "; -fx-background-radius: 50");
    }
}
