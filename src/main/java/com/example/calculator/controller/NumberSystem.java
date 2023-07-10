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

/**
 * Controller class for working with the number system
 */
public class NumberSystem extends UsualController implements Initializable {
    @FXML
    private ToggleButton hex;
    @FXML
    private ToggleButton dec;
    @FXML
    private ToggleButton oct;
    @FXML
    private ToggleButton bin;

    @FXML
    private Label outputHex;
    @FXML
    private Label outputDec;
    @FXML
    private Label outputOct;
    @FXML
    private Label outputBin;

    @FXML
    private GridPane gridPane;

    private ToggleButton active;
    private Label output;
    private String num;
    private ToggleButton[] toggleButtons = new ToggleButton[4];

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        toggleButtons[0] = hex;
        toggleButtons[1] = dec;
        toggleButtons[2] = oct;
        toggleButtons[3] = bin;
    }

    //TODO: Переработать.
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
    protected void handleProcessNumPad(ActionEvent event) {
        if (isStart()) {
            clearAllOutputs();
            setStart(false);
        }

        if (trueActive()) {
            String value = ((Button) event.getSource()).getText();
            output.setText(output.getText() + value);
            calculateSystemNumber();
        }
    }

    private void clearAllOutputs() {
        outputHex.setText("");
        outputDec.setText("");
        outputOct.setText("");
        outputBin.setText("");
    }

    @Override
    protected void handleProcessOperation(ActionEvent event) {
        if (output.getText().equals("ERROR")) {
            return;
        }

        String value = ((Button) event.getSource()).getText();

        if (!value.equals("=")) {
            handleNonEqualsOperation(value);
        } else {
            handleEqualsOperation();
        }
    }

    @Override
    protected void handleNonEqualsOperation(String value) {
        if (getOperation().isEmpty()) {
            setOperation(value);
            getInfo().setText(output.getText() + getOperation());
            num = output.getText();
            output.setText("");
        } else {
            setOperation(value);
            getInfo().setText(num + getOperation());
        }
    }

    @Override
    protected void handleEqualsOperation() {
        if (getOperation().isEmpty() || output.getText().isEmpty() || output.getText().equals(".")) {
            output.setText("ERROR");
            setOperation("");
        } else {
            getInfo().setText(getInfo().getText() + output.getText());
            String result = calculateResultOperation(num, output.getText(), getOperation());
            output.setText(String.valueOf(result));
            calculateSystemNumber();
            setOperation("");
            setStart(true);
        }
    }

    private void calculateSystemNumber() {
        if (bin.isSelected()) {
            calculateFromBinary();
        } else if (oct.isSelected()) {
            calculateFromOctal();
        } else if (dec.isSelected()) {
            calculateFromDecimal();
        } else if (hex.isSelected()) {
            calculateFromHexadecimal();
        }
    }

    private void calculateFromBinary() {
        String numText = outputBin.getText();
        int num = Integer.parseInt(numText, 2);
        outputDec.setText(String.valueOf(num));
        outputHex.setText(Integer.toHexString(num));
        outputOct.setText(Integer.toOctalString(num));
    }

    private void calculateFromOctal() {
        String numText = outputOct.getText();
        int num = Integer.parseInt(numText, 8);
        outputDec.setText(String.valueOf(num));
        outputHex.setText(Integer.toHexString(num));
        outputBin.setText(Integer.toBinaryString(num));
    }

    private void calculateFromDecimal() {
        int num = Integer.parseInt(outputDec.getText());
        outputBin.setText(Integer.toBinaryString(num));
        outputHex.setText(Integer.toHexString(num));
        outputOct.setText(Integer.toOctalString(num));
    }

    private void calculateFromHexadecimal() {
        String numText = outputHex.getText();
        int num = Integer.parseInt(numText, 16);
        outputDec.setText(String.valueOf(num));
        outputBin.setText(Integer.toBinaryString(num));
        outputOct.setText(Integer.toOctalString(num));
    }

    @Override
    protected void handleCleanOutput(ActionEvent event) {
        outputBin.setText("");
        outputDec.setText("");
        outputHex.setText("");
        outputOct.setText("");
        getInfo().setText("");
        setOperation("");
        setStart(true);
    }

    @Override
    protected void handleErase(ActionEvent event) {
        if (output != null) {
            String text = output.getText();
            if (text.length() > 0) {
                text = text.substring(0, text.length() - 1);
                output.setText(text);
                if (!output.getText().isEmpty()) {
                    calculateSystemNumber();
                } else {
                    handleCleanOutput(event);
                }
            }
        }
    }

    private void blockingNumPad() {
        Button[] buttons = gridPane.getChildren().stream()
                .filter(node -> node instanceof Button)
                .map(node -> (Button) node)
                .toArray(Button[]::new);

        for (Button b : buttons) {
            boolean disableButton = false;

            if (active == hex) {
                disableButton = false;
            } else if (active == dec) {
                disableButton = b.getText().matches("[A-F]");
            } else if (active == oct) {
                disableButton = b.getText().matches("[8-9A-F]");
            } else if (active == bin) {
                disableButton = b.getText().matches("[2-9A-F]");
            }

            b.setDisable(disableButton);
        }
    }

    private String calculateResultOperation(String num1, String num2, String op) {
        int operand1 = Integer.parseInt(num1, getSelectedBase());
        int operand2 = Integer.parseInt(num2, getSelectedBase());
        double result = Double.parseDouble(calculate(operand1, operand2, op));

        return convertToString(result);
    }

    private int getSelectedBase() {
        if (hex.isSelected()) {
            return 16;
        } else if (dec.isSelected()) {
            return 10;
        } else if (oct.isSelected()) {
            return 8;
        } else if (bin.isSelected()) {
            return 2;
        }
        return 10;  // Default base (decimal)
    }

    private String convertToString(double value) {
        if (hex.isSelected()) {
            return Integer.toHexString((int) value);
        } else if (dec.isSelected()) {
            return String.valueOf((int) value);
        } else if (oct.isSelected()) {
            return Integer.toOctalString((int) value);
        } else if (bin.isSelected()) {
            return Integer.toBinaryString((int) value);
        }
        return null;
    }

    //TODO: Переработать.
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

    private void setInfoAndOutput(ToggleButton active) {
        if (!getInfo().getText().isEmpty()) {
            getInfo().setText(output.getText() + getOperation());
            setNum();
        }
    }

    //setter
    public void setNum() {
        this.num = getInfo().getText().replaceAll("[^0-9a-f]", "");
    }
}
