package com.example.calculator.controller.converter;

import com.example.calculator.controller.ConverterController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public abstract class SkilletConverter extends ConverterController {
    @FXML
    private Label result;

    @FXML
    private MenuButton type;

    @FXML
    private MenuButton type2;

    @FXML
    void getType(ActionEvent event) {
        type.setText(((MenuItem) event.getSource()).getText());
        converter();
    }

    @FXML
    void getType2(ActionEvent event) {
        type2.setText(((MenuItem) event.getSource()).getText());
        converter();
    }

    protected void converter(){
        if (!getOutput().getText().isEmpty()) {
            double number = Double.parseDouble(getOutput().getText());
            double conversionFactor = getConversionFactor(getType().getText(), getType2().getText());
            double convertedValue = number * conversionFactor;
            String round = round(convertedValue);
            getResult().setText(round);
        }
    }

    protected abstract double getConversionFactor(String fromUnit, String toUnit);

    @Override
    protected void handleProcessNumPad(ActionEvent event) {
        super.handleProcessNumPad(event);
        converter();
    }

    @Override
    protected void cleanOutput(ActionEvent event) {
        result.setText("");
        super.cleanOutput(event);
    }

    @Override
    protected void erase(ActionEvent event) {
        super.erase(event);
        if (getOutput().getText().isEmpty()){
            result.setText("");
        }
        converter();
    }

    public Label getResult() {
        return result;
    }

    public MenuButton getType() {
        return type;
    }

    public MenuButton getType2() {
        return type2;
    }
}
